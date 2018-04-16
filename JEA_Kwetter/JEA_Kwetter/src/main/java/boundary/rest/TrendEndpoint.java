package boundary.rest;

import domain.Trend;
import services.TrendService;

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

@Path("trend")
public class TrendEndpoint extends Application {

    @Inject
    TrendService trendService;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAll() {
        List<Trend> trends = new ArrayList<Trend>(trendService.getAllTrends()) {
        };
        return Response.ok(trendService.convertAllToJson(trends)).header("Access-Control-Allow-Origin", "*").build();
    }

    @GET
    @Path("{name}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response getAccount(@PathParam("name") String name) {
        Trend account = trendService.getTrendByName(name);
        return Response.ok(account.convertToJson()).header("Access-Control-Allow-Origin", "*").build();
    }
}
