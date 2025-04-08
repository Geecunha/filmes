package org.acme.resources;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.entitys.Autor;
import org.acme.DTO.AutorDTO;
import org.eclipse.microprofile.openapi.annotations.Operation;

import java.net.URI;
import java.util.List;

@Path("/autor")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AutorResource {

    @GET  // rota 1: Lista todos os autores.
    @Operation(
            summary = "Lista todos os autores",
            description = "Essa rota é responsável por listar todos os autores."
    )
    @Transactional
    public Response listarTodos() {
        var listarTodos = Autor.listAll();
        var autorDTOs = listarTodos.stream()
                .map(a -> new AutorDTO((Autor) a))
                .toList();
        if (listarTodos.isEmpty()) {
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.ok(autorDTOs).build();
        }
    }

    @GET // rota 2: Busca autor por ID.
    @Path("/{id}")
    @Operation(
            summary = "Busca autor por ID",
            description = """
                    Essa rota é responsável por buscar um autor pelo ID.
                    Se o ID não for encontrado, retorna 404.
                    O ID é gerado automaticamente, é único e numérico."""
    )
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public AutorDTO buscarPorId(@PathParam("id") Long id) {
        Autor autor = Autor.findById(id);
        if (autor == null) {
            throw new NotFoundException("Autor não encontrado");
        }
        return new AutorDTO(autor);
    }



    @POST // rota 3: Cria um novo autor.
    @Operation(
            summary = "Cria um novo autor",
            description = "Essa rota é responsável por cadastrar um novo autor no sistema."
    )
    @Transactional
    public Response criar(@NotNull @Valid Autor autor) {
        autor.persist();
        return Response.created(URI.create("/autor/" + autor.autor_id)).entity(autor).build();
    }

    @PUT // rota 4: Atualiza autor existente.
    @Path("/{id}")
    @Operation(
            summary = "Atualiza autor por ID",
            description = """
                    Essa rota atualiza os dados de um autor existente a partir do seu ID.
                    Caso o autor não exista, retorna 404."""
    )
    @Transactional
    public Response atualizar(@PathParam("id") Long id, @NotNull @Valid Autor autor) {
        Autor entidade = Autor.findById(id);
        if (entidade == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        entidade.nome = autor.nome;
        entidade.cpf = autor.cpf;
        entidade.idade = autor.idade;
        entidade.livrosAutor = autor.livrosAutor;
        entidade.editoraAutor = autor.editoraAutor;

        return Response.ok(entidade).build();
    }

    @DELETE // rota 5: Exclui autor por ID.
    @Path("/{id}")
    @Transactional
    @Operation(
            summary = "Exclui autor por ID",
            description = """
                    Essa rota exclui um autor do sistema a partir do seu ID.
                    Caso o ID não seja encontrado, retorna 404."""
    )
    public Response excluir(@PathParam("id") Long id) {
        boolean excluido = Autor.deleteById(id);
        if (excluido) {
            return Response.noContent().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
