package boundary.rest;

import domain.User;
import services.UserService;

import javax.ejb.Stateless;
import javax.inject.Inject;
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

    public UserEndpoint() {

    }

    @GET
    @Path("{Username}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response getAccount(@PathParam("Username") String name) {
        User user = userService.findByName(name);
        return Response.ok(user.convertToJson()).header("Access-Control-Allow-Origin", "*").build();
    }

    @GET
    @Path("getAll")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAll() {
        List<User> users = new ArrayList<User>(userService.getAllUsers()) {
        };
        return Response.ok(userService.convertAllToJson(users)).header("Access-Control-Allow-Origin", "*").build();
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
        return Response.noContent().header("Access-Control-Allow-Origin", "*").build();
    }
}
