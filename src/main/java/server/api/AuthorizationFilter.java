package server.api;

import server.model.AccountService;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 * Created by eugene on 10/14/16.
 */
@SuppressWarnings("DefaultFileTemplate")
@Provider
@Authorized
public class AuthorizationFilter implements ContainerRequestFilter {
    static final AccountService accountService = AccountService.getInstance();

    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        String authHeader = containerRequestContext.getHeaderString("Authorization");
        if(
                        null != authHeader &&
                        authHeader.matches("^Bearer -?[0-9]+$") &&
                        accountService.isTokenValid(authHeader.split(" ")[1])
                ){
            containerRequestContext.getHeaders().add("token",authHeader.split(" ")[1]);
            return;
        }
        containerRequestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
    }
}
