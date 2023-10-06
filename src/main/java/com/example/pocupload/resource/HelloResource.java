package com.example.pocupload.resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;


@Path("/hello")
public class HelloResource {

    @GET
    @Produces("text/plain")
    public String hello(@QueryParam("name") String name) {
        return "Hello " + name;
    }
}