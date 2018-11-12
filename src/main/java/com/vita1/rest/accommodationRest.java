package com.vita1.rest;

import com.google.gson.reflect.TypeToken;
import com.vita1.api.Accommodation;
import com.vita1.app.ServerInterfaceImpl;


import com.google.gson.Gson;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.lang.reflect.Type;
import java.util.List;

@Path("/")
public class accommodationRest {
    List<Accommodation> accommodations = ServerInterfaceImpl.getAccommodations();
    @GET // This annotation indicates GET request
    @Path("/accommodation")
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {
        Type listType = new TypeToken<List<Accommodation>>() {}.getType();
        Gson gson = new Gson();
        String userIdList = gson.toJson(accommodations, listType);
        return Response.ok(userIdList).build();
    }
}