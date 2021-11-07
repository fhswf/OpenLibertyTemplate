package de.fhswf.fit.service;

import java.util.List;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import de.fhswf.fit.Person;
import de.fhswf.fit.PhoneBookStore;
import jakarta.inject.Inject;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.MessageBodyReader;
import jakarta.ws.rs.ext.MessageBodyWriter;
import jakarta.ws.rs.ext.Provider;
import jakarta.ws.rs.ext.Providers;

@ApplicationPath("/phonebook")
@Provider
public class PhoneBookService extends Application implements ExceptionMapper<Exception> {

    Providers providers;

    public PhoneBookService() {
        System.out.println("PhoneBookService ctor");
    }

    @Override
    public Response toResponse(Exception exception) {
        return Response.status(403).entity(exception.getMessage()).build();
    }

}
