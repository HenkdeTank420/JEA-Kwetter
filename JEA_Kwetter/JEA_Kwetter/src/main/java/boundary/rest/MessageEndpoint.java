package boundary.rest;

import domain.Account;
import domain.Message;
import org.springframework.web.bind.annotation.ResponseBody;
import services.AccountService;
import services.MessageService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("message")
@Stateless
public class MessageEndpoint extends Application {

    @Inject
    MessageService messageService;
    @Inject
    AccountService accountService;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAll() {
        List<Message> messages = new ArrayList<Message>(messageService.getAllMessages()) {};
        return Response.ok(messageService.convertAllToJson(messages)).header("Access-Control-Allow-Origin", "*").build();
    }

    @GET
    @Path("{name}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getMessageOfAccount(@PathParam("name") String name) {
        List<Message> messages = new ArrayList<Message>(messageService.findMessagesOfAccount(name)){};
        return Response.ok(messageService.convertAllToJson(messages)).header("Access-Control-Allow-Origin", "*").build();
    }

    @GET
    @Path("search/{word}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getMessageWithWord(@PathParam("word") String word) {
        List<Message> messages = new ArrayList<Message>(messageService.findMessgesWithWordInText(word)){};
        return Response.ok(messageService.convertAllToJson(messages)).header("Access-Control-Allow-Origin", "*").build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Message createMessage(Message message) {
        if (message == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        Account account = accountService.findByName(message.getUsername());
        message.setOwner(account);
        messageService.create(message);
        return message;
    }

    @DELETE
    @Path("{ID}")
    public Response deleteMessage(@PathParam("ID") Long ID) {
        messageService.delete(messageService.findById(ID));
        return Response.noContent().header("Access-Control-Allow-Origin", "*").build();
    }
}
