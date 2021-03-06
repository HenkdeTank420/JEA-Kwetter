package boundary.rest;

import boundary.rest.JWT.JWTTokenAnnotation;
import domain.User;
import services.JWTToken;
import services.UserService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.Json;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("user")
@Stateless
public class UserEndpoint {

    @Inject
    UserService userService;
    @Inject
    JWTToken jwtToken;

    public UserEndpoint() {

    }

    @GET
    @Path("{Username}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response getAccount(@PathParam("Username") String name) {
        User user = userService.findByName(name);
        return Response.ok(user.convertToJson())
                .header("Access-Control-Allow-Origin", "*")
                .header("Content-Length", "0")
                .header("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept, Authorization")
                .build();
    }

    @GET
    @Path("getAll")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAll() {
        List<User> users = new ArrayList<User>(userService.getAllUsers()) {
        };
        return Response.ok(userService.convertAllToJson(users))
                .header("Access-Control-Allow-Origin", "*")
                .header("Content-Length", "0")
                .header("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept, Authorization")
                .build();
    }

    @OPTIONS
    public Response optionsResponse(){
        return Response.status(200).header("Allow","OPTIONS, POST, GET").header("Access-Control-Allow-Origin", "*")
                .header("Content-Type", MediaType.APPLICATION_JSON)
                .header("Content-Length", "0")
                .header("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept")
                .build();
    }

    @OPTIONS
    @Path("login")
    public Response optionsLoginResponse(){
        return Response.status(200).header("Allow","OPTIONS, POST").header("Access-Control-Allow-Origin", "*")
                .header("Content-Type", MediaType.APPLICATION_JSON)
                .header("Content-Length", "0")
                .header("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept")
                .build();
    }

    @POST
    @Path("login")
    public Response JWTLogin(User user) {
        if (user == null) {
            return Response.status(Response.Status.NOT_FOUND).header("Access-Control-Allow-Origin", "*").build();
        }
        User checkedUser = userService.findByCredentials(user.getUsername(), user.getPassword());
        String token = jwtToken.EncodeToken(checkedUser.getUsername());
        return Response.ok(Json.createObjectBuilder().add("Token", token).add("valid",1).add("username",checkedUser.getUsername()).build())
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept, Authorization")
                .build();

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User createUser(User user) {
        if (user == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        userService.create(user);
        return user;
    }

    @DELETE
    @Path("{Username}")
    public Response deleteAccount(@PathParam("Username") String username) {
        User userToRemove = userService.findByName(username);
        userService.remove(userToRemove);
        return Response.noContent()
                .header("Access-Control-Allow-Origin", "*")
                .header("Content-Length", "0")
                .header("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept, Authorization")
                .build();
    }
}
