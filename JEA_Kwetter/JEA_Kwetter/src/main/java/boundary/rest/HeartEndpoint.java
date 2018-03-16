package boundary.rest;

import domain.Heart;
import services.HeartService;

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

@Path("heart")
public class HeartEndpoint extends Application {

    @Inject
    private HeartService heartService;

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getHeartsOfMessage(@PathParam("id") Long id) {
        List<Heart> hearts = new ArrayList<Heart>(heartService.getAllHeartsOfMessage(id)){};
        return Response.ok(heartService.convertAllToJson(hearts)).build();
    }

    @GET
    @Path("account/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAccountsThatGaveHeartsOfMessage(@PathParam("id") Long id) {
        List<Heart> hearts = new ArrayList<Heart>(heartService.getAllHeartedAccountsOfMessage(id)){};
        return Response.ok(heartService.convertAllToJson(hearts)).build();
    }
}
