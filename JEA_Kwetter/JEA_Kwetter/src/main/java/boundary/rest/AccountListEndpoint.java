package boundary.rest;

import domain.Account;
import services.AccountService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("account")
@Stateless
public class AccountListEndpoint extends Application{

    @Inject
    AccountService accountService;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAll() {
        List<Account> accounts = new ArrayList<Account>(accountService.getAllAccounts()) { };
        return Response.ok(accountService.convertAllToJson(accounts)).header("Access-Control-Allow-Origin", "*").build();
    }

    @GET
    @Path("{username}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response getAccount(@PathParam("username") String name) {
        Account account = accountService.findByName(name);
        return Response.ok(account.convertToJson()).header("Access-Control-Allow-Origin", "*").build();
    }

    @GET
    @Path("followers/{username}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getFollowersOfAccount(@PathParam("username") String name) {
        GenericEntity entity = new GenericEntity<List<Account>>(accountService.getAllFollowers(name)){};
        return Response.ok(entity).header("Access-Control-Allow-Origin", "*").build();
    }

    @GET
    @Path("followees/{username}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getFolloweesOfAccount(@PathParam("username") String name) {
        GenericEntity entity = new GenericEntity<List<Account>>(accountService.getAllFollowees(name)){};
        return Response.ok(entity).header("Access-Control-Allow-Origin", "*").build();
    }

}
