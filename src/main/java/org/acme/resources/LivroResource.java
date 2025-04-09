package org.acme.resources;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.DTO.LivroCadastroDTO;
import org.acme.DTO.FilmeDTO;
import org.acme.entitys.Diretor;
import org.acme.entitys.Produtora;
import org.acme.entitys.Filme;
import org.eclipse.microprofile.openapi.annotations.Operation;

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
        List<Filme> livros = Filme.find("SELECT l FROM Livro l JOIN FETCH l.editora JOIN FETCH l.autor").list();

        if (livros.isEmpty()) {
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            List<FilmeDTO> livrosDTO = livros.stream().map(FilmeDTO::new).toList();
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
    public FilmeDTO buscarPorId(@PathParam("id") Long id) {
        Filme livro = Filme.findById(id);
        if (livro == null) {
            throw new NotFoundException("livro não encontrado!");
        }
        return new FilmeDTO(livro);
    }


    @POST // rota 3: Cria um novo livro.
    @Path("/criar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
            summary = "Cria um novo livro",
            description = "Essa rota é responsável por cadastrar um novo livro."
    )
    @Transactional
    public Response criarLivro(@Valid LivroCadastroDTO dto) {
        Diretor autor = Diretor.findById(dto.autor);
        if (autor == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Autor com ID " + dto.autor + " não encontrado.")
                    .build();
        }

        Produtora editora = Produtora.findById(dto.editora);
        if (editora == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Editora com ID " + dto.editora + " não encontrada.")
                    .build();
        }

        Filme livro = new Filme();
        livro.titulo = dto.titulo;
        livro.numPag = dto.numPag;
        livro.autor = autor;
        livro.editora = editora;
        livro.persist();

        return Response.status(Response.Status.CREATED).entity(new FilmeDTO(livro)).build();
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
        Filme livro = Filme.findById(id);
        if (livro == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Livro não encontrado").build();
        } else {
            Diretor autor = Diretor.findById(dto.autor);
            Produtora editora = Produtora.findById(dto.editora);

            if (autor == null || editora == null) {
                return Response.status(Response.Status.BAD_REQUEST).entity("Autor ou Editora não encontrados").build();
            }

            livro.titulo = dto.titulo;
            livro.numPag = dto.numPag;
            livro.autor = autor;
            livro.editora = editora;

            return Response.ok(new FilmeDTO(livro)).build();
        }
    }

    @PUT
    @Path("/basico/{id}")// rota 5: Atualiza somente título e número de páginas do livro
    @Transactional
    @Operation(
            summary = "Atualiza somente título e número de páginas do livro",
            description = "Essa rota edita apenas o título e o número de páginas de um livro já existente"
    )
    public Response atualizarLivroBasico(@PathParam("id") Long id,@Valid FilmePutDTO dto) {
        Filme livro = Filme.findById(id);
        if (livro == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Livro não encontrado").build();
        } else {
            livro.titulo = dto.titulo;
            livro.numPag = dto.numPag;

            return Response.ok(new FilmeDTO(livro)).build();
        }
    }

    @DELETE // rota 6: Exclui livro.
    @Operation(
            summary = "Exclui livro por ID",
            description = """
                    Essa rota exclui um livro do sistema a partir do seu ID.
                    Caso o ID não seja encontrado, retorna 404."""
    )
    @Path("deletarLivro/{id}")
    @Transactional
    public Response excluir(@Valid @PathParam("id") Long id) {
        boolean excluido = Filme.deleteById(id);
        if (excluido) {
            return Response.noContent().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

}
