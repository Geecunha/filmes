package org.acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.acme.resources.AutorResource;
import org.acme.resources.EditoraResource;
import org.acme.resources.LivroResource;
import org.eclipse.microprofile.openapi.annotations.Operation;

@Path("/")
public class GreetingResource {

    @Path("livro")
    @Operation(
            summary = "Rotas referentes a livros",
            description = "Rota responsável por gerenciar os livros."
    )
    public Class<LivroResource> livro() {
        return  LivroResource.class;
    }


    @Path("autor")
    @Operation(
            summary = "Rotas referentes a autor",
            description = "Rota responsável por gerenciar os autores."
    )
    public Class<AutorResource> autor() {
        return  AutorResource.class;
    }

    @Path("editora")
    @Operation(
            summary = "Rotas referentes a editora",
            description = "Rota responsável por gerenciar as editoras."
    )
    public Class<EditoraResource> editora() {
        return  EditoraResource.class;
    }
}
