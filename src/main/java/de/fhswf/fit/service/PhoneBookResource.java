package de.fhswf.fit.service;

import de.fhswf.fit.PhoneBookStore;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import de.fhswf.fit.Person;
import java.util.List;

@Path("/phone")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, "text/html" })
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class PhoneBookResource {

    @Inject
    PhoneBookStore phoneBookStore;

    @GET
    public List<Person> getAll() {
        return phoneBookStore.getAll();
    }

    @GET
    @Path("/{name}")
    public Person getByName(@PathParam("name") String name) {
        return phoneBookStore.getByName(name);
    }

    @POST
    public Person add(Person person) {
        return phoneBookStore.update(person);
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Person addRecord(@FormParam("name") String name, @FormParam("phone") String phone) {
        Person person = new Person();
        person.setName(name);
        person.setPhoneNumber(phone);
        return phoneBookStore.update(person);
    }

    @PUT
    @Path("/{name}")
    public Person updatePerson(@PathParam("name") String name, Person person) {
        person.setName(name);
        return phoneBookStore.update(person);
    }

    @DELETE
    @Path("/{name}")
    public void deletePerson(@PathParam("name") String name) {
        phoneBookStore.delete(name);
    }
}
