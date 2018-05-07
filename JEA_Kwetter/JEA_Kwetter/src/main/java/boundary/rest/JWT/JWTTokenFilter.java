package boundary.rest.JWT;

import services.JWTToken;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
@JWTTokenAnnotation
@Priority(Priorities.AUTHENTICATION)
public class JWTTokenFilter implements ContainerRequestFilter{

    @Inject
    JWTToken jwtToken;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {

        // Get the HTTP Authorization header from the request
        String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

        // Extract the token from the HTTP Authorization header

        try {
            String token = authorizationHeader.substring("Bearer".length()).trim();
            jwtToken.CheckIfTokenIsTrusted(token);
            // Validate the token

        } catch (Exception e) {
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
                    .header("Access-Control-Allow-Origin", "*")
                    .header("Content-Length", "0")
                    .header("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept, Authorization")
                    .build());
        }
    }
}

