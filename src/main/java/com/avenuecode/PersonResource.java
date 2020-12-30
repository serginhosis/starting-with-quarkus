package com.avenuecode;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.avenuecode.documents.Person;
import com.avenuecode.services.PersonService;

import java.net.URI;
import java.util.List;

@Path("/person")
public class PersonResource {
    private final PersonService personService;

    public PersonResource(PersonService personService) {
        this.personService = personService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> list() {
        return personService.allPersons();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person findOne(@PathParam("id") String id) {
        return personService.findById(id);
    }

    @POST
    public Response insert(Person p, @Context UriInfo uriInfo){
        URI location = uriInfo.getAbsolutePathBuilder()
                              .path(personService.save(p))
                              .build();
        return Response.created(location).build();
    }
}