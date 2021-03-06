package boundary.rest;

import boundary.rest.JWT.JWTTokenAnnotation;
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
    @JWTTokenAnnotation
    public Response getAll() {
        List<Message> messages = new ArrayList<Message>(messageService.getAllMessages()) {};
        return Response.ok(messageService.convertAllToJson(messages))
                .header("Access-Control-Allow-Origin", "*")
                .header("Content-Length", "0")
                .header("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept, Authorization")
                .build();
    }

    @GET
    @Path("{name}")
    @Produces({MediaType.APPLICATION_JSON})
    @JWTTokenAnnotation
    public Response getMessageOfAccount(@PathParam("name") String name) {
        List<Message> messages = new ArrayList<Message>(messageService.findMessagesOfAccount(name)){};
        return Response.ok(messageService.convertAllToJson(messages))
                .header("Access-Control-Allow-Origin", "*")
                .header("Content-Length", "0")
                .header("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept, Authorization")
                .build();
    }

    @GET
    @Path("search/{word}")
    @Produces({MediaType.APPLICATION_JSON})
    @JWTTokenAnnotation
    public Response getMessageWithWord(@PathParam("word") String word) {
        List<Message> messages = new ArrayList<Message>(messageService.findMessgesWithWordInText(word)){};
        return Response.ok(messageService.convertAllToJson(messages)).header("Access-Control-Allow-Origin", "*").build();
    }

    @OPTIONS
    public Response optionsResponse(){
        return Response.status(200).header("Allow","OPTIONS, POST, GET, DELETE")
                .header("Access-Control-Allow-Origin", "*")
                .header("Content-Length", "0")
                .header("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept, Authorization")
                .build();
    }

    @OPTIONS
    @Path("{ID}")
    public Response optionsDeleteResponse(){
        return Response.status(200).header("Allow","OPTIONS, DELETE")
                .header("Access-Control-Allow-Origin", "*")
                .header("Content-Length", "0")
                .header("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept, Authorization")
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createMessage(Message message) {
        if (message == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .header("Access-Control-Allow-Origin", "*")
                    .header("Content-Length", "0")
                    .header("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept, Authorization")
                    .build();
        }
        Account account = accountService.findByName(message.getUsername());
        message.setOwner(account);
        messageService.create(message);
        return Response.ok()
                .header("Access-Control-Allow-Origin", "*")
                .header("Content-Length", "0")
                .header("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept, Authorization")
                .build();
    }

    @DELETE
    @Path("{ID}")
    public Response deleteMessage(@PathParam("ID") Long ID) {
        messageService.delete(messageService.findById(ID));
        return Response.ok()
                .header("Access-Control-Allow-Origin", "*")
                .header("Content-Length", "0")
                .header("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept, Authorization")
                .build();
    }
}
