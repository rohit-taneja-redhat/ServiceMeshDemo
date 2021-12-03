package com.redhat.training.serviceb;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.HeaderParam;

@Path("/")
@ApplicationScoped
public class ServiceB {

    String message = "X-envoy-attempt-count: ";

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello(@HeaderParam("x-envoy-attempt-count") String count) {
        return message + count;
    }
}
