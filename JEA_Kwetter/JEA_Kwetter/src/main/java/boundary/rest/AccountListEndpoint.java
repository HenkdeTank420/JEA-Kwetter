package boundary.rest;

import domain.Account;
import services.AccountService;

import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("account")
public class AccountListEndpoint extends Application{

    @Inject
    AccountService accountService;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAll() {
        GenericEntity entity = new GenericEntity<List<Account>>(accountService.getAllAccounts()) {
        };
        return Response.ok(entity).build();
    }

}
