package boundary.rest;

import domain.User;
import services.UserService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
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
        return Response.ok(user.convertToJson()).build();
    }

    @GET
    @Path("getAll")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAll() {
        List<User> users = new ArrayList<User>(userService.getAllUsers()) {
        };
        return Response.ok(userService.convertAllToJson(users)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser(User user) {
        if (user == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        userService.create(user);
        URI id = URI.create(user.getUsername());
        return Response.created(id).build();
    }

    @POST
    @Path("test")
    @Produces(MediaType.APPLICATION_JSON)
    public String addMessage() {
        return "Post works!";
    }

    @DELETE
    public Response deleteAccount() {
        User userToRemove = userService.findByName("Koen");

        if (userToRemove == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }

        userService.remove(userToRemove);
        return Response.noContent().build();
    }
}
