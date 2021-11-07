package de.fhswf.fit.service;

import java.util.List;

import de.fhswf.fit.Person;
import de.fhswf.fit.PhoneBookStore;

import jakarta.inject.Inject;
import jakarta.ws.rs.ApplicationPath;
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

@Path("/phone")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN, "text/html",
        "text/html;charset=UTF-8" })
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class PhonebookResource {

    @Inject
    transient PhoneBookStore phoneBookStore;

    @GET
    public List<Person> getAll() {
        return phoneBookStore.getAll();
    }

    @GET
    @Path("/{name}")
    public Person getByName(@PathParam("name") String name) {
        System.out.println("name: " + name);
        return phoneBookStore.getByName(name);
    }

    @POST
    public Person addRecord(Person person) {
        System.out.println("Add: " + person);
        return phoneBookStore.update(person);
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Person addRecord(@FormParam("name") String name, @FormParam("phoneNumber") String phoneNumber) {
        Person person = new Person(name, phoneNumber);
        System.out.println("Add: " + person);
        return phoneBookStore.update(person);
    }

    @PUT
    @Path("/{name}")
    public Person updateNumber(@PathParam("name") String name, Person person) {
        System.out.println("Update: " + name + "  " + person);
        person.setName(name);
        return phoneBookStore.update(person);
    }

    @DELETE
    @Path("/{name}")
    public void deleteNumber(@PathParam("name") String name) {
        System.out.println("Delete " + name);
        phoneBookStore.delete(name);
    }
}
