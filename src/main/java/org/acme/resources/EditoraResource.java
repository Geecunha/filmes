package org.acme.resources;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.DTO.ProdutoraDTO;
import org.acme.entitys.Produtora;
import org.eclipse.microprofile.openapi.annotations.Operation;

import java.net.URI;
import java.util.List;

@Path("/editora")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EditoraResource {

    @GET // rota 1: Lista todas as editoras.
    @Operation(
            summary = "Listar todas as editoras",
            description = "Essa rota é responsável por listar todas as editoras cadastradas."
    )
    @Transactional
    public Response listarTodos() {
        List<Produtora> editoras = Produtora.find(
                "SELECT DISTINCT e FROM Editora e LEFT JOIN FETCH e.livrosEditora LEFT JOIN FETCH e.autoresEditora"
        ).list();

        if (editoras.isEmpty()) {
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            List<ProdutoraDTO> editoraDTOs = editoras.stream()
                    .map(ProdutoraDTO::new)
                    .toList();
            return Response.ok(editoraDTOs).build();
        }
    }

    @GET // rota 2: Busca editora por ID.
    @Path("/{id}")
    @Operation(
            summary = "Busca editora por ID",
            description = "Essa rota é responsável por buscar uma editora pelo ID."
    )
    @Transactional
    public ProdutoraDTO buscarPorId(@PathParam("id") Long id) {
        Produtora editora= Produtora.findById(id);
        if (editora == null) {
            throw new NotFoundException("editora não encontrado!");
        }
        return new ProdutoraDTO(editora);
    }

    @POST // rota 3: Cria nova editora.
    @Operation(
            summary = "Cria uma nova editora",
            description = "Essa rota permite cadastrar uma nova editora."
    )
    @Transactional
    public Response criar(@NotNull @Valid Produtora editora) {
        editora.persist();
        return Response.created(URI.create("/editora/" + editora.editora_id)).entity(editora).build();
    }




    @PUT // rota 4: Atualizar editora por ID.
    @Path("/{id}")
    @Operation(
            summary = "Atualiza editora por ID",
            description = """
                    Essa rota atualiza os dados de uma editora a partir do ID.
                    Caso a editora não exista, retorna 404."""
    )
    @Transactional
    public Response atualizar(@PathParam("id") Long id, @NotNull @Valid Produtora editora) {
        Produtora entidade = Produtora.findById(id);
        if (entidade == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        entidade.nome = editora.nome;
        entidade.cnpj = editora.cnpj;
        entidade.site = editora.site;
        entidade.cep = editora.cep;
        entidade.livrosEditora = editora.livrosEditora;

        return Response.ok(entidade).build();
    }


    @DELETE // rota 5: Excluir editora por ID.
    @Path("deletarEditora/{id}")
    @Operation(
            summary = "Exclui editora por ID",
            description = """
                    Essa rota exclui uma editora a partir do ID.
                    Caso o ID não seja encontrado, retorna 404."""
    )
    @Transactional
    public Response excluir(@PathParam("id") Long id) {
        boolean excluido = Produtora.deleteById(id);
        if (excluido) {
            return Response.noContent().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
