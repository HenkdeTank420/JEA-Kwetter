package boundary.rest;

import domain.Account;
import domain.Message;
import services.MessageService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("message")
public class MessageEndpoint extends Application {

    @Inject
    MessageService messageService;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAll() {
        GenericEntity entity = new GenericEntity<List<Message>>(messageService.getAllMessages()) {
        };
        return Response.ok(entity).build();
    }

    @GET
    @Path("{name}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getMessageOfAccount(@PathParam("name") String name) {
        GenericEntity entity = new GenericEntity<List<Message>>(messageService.findMessagesOfAccount(name)){};
        return Response.ok(entity).build();
    }

    @GET
    @Path("search/{word}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getMessageWithWord(@PathParam("word") String word) {
        GenericEntity entity = new GenericEntity<List<Message>>(messageService.findMessgesWithWordInText(word)){};
        return Response.ok(entity).build();
    }
}
