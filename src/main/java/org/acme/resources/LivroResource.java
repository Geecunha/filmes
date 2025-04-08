package org.acme.resources;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.DTO.AutorDTO;
import org.acme.DTO.LivroCadastroDTO;
import org.acme.DTO.LivroDTO;
import org.acme.DTO.LivroPutDTO;
import org.acme.entitys.Autor;
import org.acme.entitys.Editora;
import org.acme.entitys.Livro;
import org.eclipse.microprofile.openapi.annotations.Operation;

import java.net.URI;
import java.util.List;

@Path("/livro")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class LivroResource {

    @GET // rota 1: Lista todos os livros.
    @Operation(
            summary = "Lista todos os livros",
            description = "Essa rota é responsável por listar todos os livros."
    )
    @Transactional
    public Response listarTodos() { // em vez de listar Livros, irá listar LivrosDTO sem causar um erro.
        List<Livro> livros = Livro.find("SELECT l FROM Livro l JOIN FETCH l.editora JOIN FETCH l.autor").list();

        if (livros.isEmpty()) {
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            List<LivroDTO> livrosDTO = livros.stream().map(LivroDTO::new).toList();
            return Response.ok(livrosDTO).build();
        }
    }


    @GET // rota 2: Busca livro por ID.
    @Operation(
            summary = "Busca livro por ID",
            description = """
                    Essa rota é responsável por buscar um livro pelo ID.
                    Se o ID não for encontrado, retorna 404.
                    O ID é gerado automaticamente, é único e numérico."""
    )
    @Path("/{id}")
    @Transactional
    public LivroDTO buscarPorId(@PathParam("id") Long id) {
        Livro livro = Livro.findById(id);
        if (livro == null) {
            throw new NotFoundException("livro não encontrado!");
        }
        return new LivroDTO(livro);
    }


    @POST // rota 3: Cria um novo livro.
    @Path("/livro")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
            summary = "Cria um novo livro",
            description = "Essa rota é responsável por cadastrar um novo livro."
    )
    @Transactional
    public Response criarLivro(@Valid LivroCadastroDTO dto) {
        Autor autor = Autor.findById(dto.autor);
        if (autor == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Autor com ID " + dto.autor + " não encontrado.")
                    .build();
        }

        Editora editora = Editora.findById(dto.editora);
        if (editora == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Editora com ID " + dto.editora + " não encontrada.")
                    .build();
        }

        Livro livro = new Livro();
        livro.titulo = dto.titulo;
        livro.numPag = dto.numPag;
        livro.autor = autor;
        livro.editora = editora;
        livro.persist();

        return Response.status(Response.Status.CREATED).entity(new LivroDTO(livro)).build();
    }


    @PUT // rota 4: Atualiza livro existente com todos os dados.
    @Operation(
            summary = "Atualiza livro por ID",
            description = """
                    Essa rota atualiza os dados de um livro existente a partir do seu ID.
                    Caso o livro não exista, retorna 404."""
    )
    @Path("/{id}")
    @Transactional
    public Response atualizarLivro(@PathParam("id") Long id, @Valid LivroCadastroDTO dto) {
        Livro livro = Livro.findById(id);
        if (livro == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Livro não encontrado").build();
        } else {
            Autor autor = Autor.findById(dto.autor);
            Editora editora = Editora.findById(dto.editora);

            if (autor == null || editora == null) {
                return Response.status(Response.Status.BAD_REQUEST).entity("Autor ou Editora não encontrados").build();
            }

            livro.titulo = dto.titulo;
            livro.numPag = dto.numPag;
            livro.autor = autor;
            livro.editora = editora;

            return Response.ok(new LivroDTO(livro)).build();
        }
    }

    @PUT
    @Path("/basico/{id}")
    @Transactional
    @Operation(
            summary = "Atualiza somente título e número de páginas do livro",
            description = "Essa rota edita apenas o título e o número de páginas de um livro já existente"
    )
    public Response atualizarLivroBasico(@PathParam("id") Long id,@Valid LivroPutDTO dto) {
        Livro livro = Livro.findById(id);
        if (livro == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Livro não encontrado").build();
        } else {
            livro.titulo = dto.titulo;
            livro.numPag = dto.numPag;

            return Response.ok(new LivroDTO(livro)).build();
        }
    }

    @DELETE // rota 5: Exclui livro.
    @Operation(
            summary = "Exclui livro por ID",
            description = """
                    Essa rota exclui um livro do sistema a partir do seu ID.
                    Caso o ID não seja encontrado, retorna 404."""
    )
    @Path("/{id}")
    @Transactional
    public Response excluir(@Valid @PathParam("id") Long id) {
        boolean excluido = Livro.deleteById(id);
        if (excluido) {
            return Response.noContent().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET // rota 6: buscar pelo nome
    @Path("/busca/nome/{nome}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
            summary = "Busca livros por título, autor ou editora",
            description = """
        Essa rota permite buscar livros pelo nome do título, do autor ou da editora.
        A busca é feita ignorando letras maiúsculas ou minúsculas."""
    )
    @Transactional
    public List<LivroDTO> buscarPorNome(@PathParam("nome") String nome) {
        String like = "%" + nome.toLowerCase() + "%";

        List<Livro> livros = Livro.find(
                """
                SELECT l FROM Livro l
                JOIN l.autor a
                JOIN l.editora e
                WHERE LOWER(l.titulo) LIKE ?1
                OR LOWER(a.nome) LIKE ?1
                OR LOWER(e.nome) LIKE ?1
                """, like
        ).list();

        return livros.stream().map(LivroDTO::new).toList();
    }


    @POST
    @Path("/criar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    @Operation(
            summary = "Cria um novo livro",
            description = "Cria um livro com título, número de páginas, autor e editora já existentes."
    )
    public Response novoLivro(@Valid LivroCadastroDTO dto) {
        Autor autor = Autor.findById(dto.autor);
        Editora editora = Editora.findById(dto.editora);

        if (autor == null || editora == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Autor ou Editora não encontrados").build();
        }

        Livro livro = new Livro();
        livro.titulo = dto.titulo;
        livro.numPag = dto.numPag;
        livro.autor = autor;
        livro.editora = editora;

        livro.persist();

        return Response.status(Response.Status.CREATED).entity(new LivroDTO(livro)).build();
    }

}
