package de.fhswf.fit.service;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Vector;

import de.fhswf.fit.Person;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.ext.MessageBodyWriter;
import jakarta.ws.rs.ext.Provider;
import jakarta.ws.rs.ext.Providers;

@Provider
@Produces({ "text/html", "text/html;charset=UTF-8" })
public class HTMLMessageBodyWriter implements MessageBodyWriter<Vector> {

    @Override
    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return type == Vector.class;
    }

    @Override
    public long getSize(Vector t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return -1;
    }

    @Override
    public void writeTo(Vector t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType,
            jakarta.ws.rs.core.MultivaluedMap<String, Object> httpHeaders, java.io.OutputStream entityStream)
            throws java.io.IOException, jakarta.ws.rs.WebApplicationException {
        entityStream.write("<html><body><dl>".getBytes());
        for (Object o : t) {
            if (o instanceof Person) {
                Person p = (Person) o;
                entityStream.write(("<dt>" + p.getName() + "</dt><dd> " + p.getPhoneNumber() + "</dd>").getBytes());
            }
        }
        entityStream.write("</dl></body></html>".getBytes());
    }

}
