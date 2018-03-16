package boundary.rest;

import domain.Account;
import services.AccountService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("account")
public class AccountListEndpoint extends Application{

    @Inject
    AccountService accountService;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAll() {
        List<Account> accounts = new ArrayList<Account>(accountService.getAllAccounts()) {
        };
        return Response.ok(accountService.convertAllToJson(accounts)).build();
    }

    @GET
    @Path("{name}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response getAccount(@PathParam("name") String name) {
        Account account = accountService.findByName(name);
        return Response.ok(account.convertToJson()).build();
    }

    @GET
    @Path("followers/{name}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getFollowersOfAccount(@PathParam("name") String name) {
        GenericEntity entity = new GenericEntity<List<Account>>(accountService.getAllFollowers(name)){};
        return Response.ok(entity).build();
    }

    @GET
    @Path("followees{name}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getFolloweesOfAccount(@PathParam("name") String name) {
        GenericEntity entity = new GenericEntity<List<Account>>(accountService.getAllFollowees(name)){};
        return Response.ok(entity).build();
    }

}
