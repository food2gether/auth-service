package com.github.food2gether.authservice.resources;

import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Basic;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/api/v1/authentication/")
public class AuthenticationResorce {

  @PUT
  @Path("/{email}/{password}")
  @Consumes(MediaType.APPLICATION_JSON)
  public Response authenticate(@PathParam("email") String email, @PathParam("password") String password) {
      if (password.equals("password")) {
        String dummyResponse = """
            {
              "success": true,
              "data": {
                "token": "<session_token>"
              }
            }""";
        return Response.status(Status.CREATED).entity(dummyResponse).build();
      }
      else {
        String dummyResponse = """
            {
              "success": false,
              "error": {
                "code": 401,
                "message": "Unauthorized"
              }
            }""";
         return Response.status(Status.CONFLICT).entity(dummyResponse).build();
      }
  }

  @POST
  @Path("/{authorization}")
  @Consumes(MediaType.APPLICATION_JSON)
  public Response authorize(@PathParam("authorization")String authorization) {
    if (authorization.equals("password")) {
      String dummyResponse = """
          {
            "success": true,
            "data": {
              "token": "<session_token>"
            }
          }""";
      return Response.status(Status.OK).entity(dummyResponse).build();
    } else {
      String dummyResponse = """
          {
            "success": false,
            "error": {
              "code": 401,
              "message": "Unauthorized"
            }
          }""";
      return Response.status(Status.UNAUTHORIZED).entity(dummyResponse).build();
    }
  }

  @DELETE
  @Path("/{authorization}")
  @Consumes(MediaType.APPLICATION_JSON)
  public Response deauthorize(@PathParam("authorization")String authorization) {
    if (authorization.equals("password")) {
      String dummyResponse = """
          {
            "success": true,
            "data": null
          }""";
      return Response.status(Status.OK).entity(dummyResponse).build();
    } else {
      String dummyResponse = """
          {
            "success": false,
            "error": {
              "code": 401,
              "message": "Unauthorized"
            }
          }""";
      return Response.status(Status.UNAUTHORIZED).entity(dummyResponse).build();
    }
  }

  @PUT
  @Path("/reset/{email}")
  @Consumes(MediaType.APPLICATION_JSON)
  public Response resetPassword(@PathParam("email") String email) {
    if (email.equals("mail")) {
      String dummyResponse = """
          {
            "success": true,
            "data": null
          }""";
      return Response.status(Status.OK).entity(dummyResponse).build();
    } else {
      String dummyResponse = """
          {
            "success": false,
            "error": {
              "code": 404,
              "message": "account.notfound"
            }
          }""";
      return Response.status(Status.NOT_FOUND).entity(dummyResponse).build();
    }
  }

  @POST
  @Path("/reset/{authorization}/{password}")
  @Consumes(MediaType.APPLICATION_JSON)
  public Response resetPassword(@PathParam("authorization") String authorization, @PathParam("password") String password) {
    if (authorization.equals("password")) {
      String dummyResponse = """
          {
            "success": true,
            "data": null
          }""";
      return Response.status(Status.OK).entity(dummyResponse).build();
    } else {
      String dummyResponse = """
          {
            "success": false,
            "error": {
              "code": 401,
              "message": "token.invalid"
            }
          }""";
      return Response.status(Status.BAD_REQUEST).entity(dummyResponse).build();
    }
  }
}
