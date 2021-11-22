package de.fhswf.fit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import static org.junit.Assert.*;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RunWith(Arquillian.class)
public class PhoneBookTest {

    private static final Logger LOGGER = Logger.getLogger(PhoneBookTest.class.getName());

    @Inject
    PhoneBookStore phoneBook;

    @PersistenceContext
    EntityManager em;

    @Deployment
    public static JavaArchive createDeployment() {
        // return ShrinkWrap.create(WebArchive.class).addPackages(true, "de.fhswf.fit")
        // .addAsResource("META-INF/persistence.xml").addAsManifestResource(EmptyAsset.INSTANCE,
        // "beans.xml");
        JavaArchive jar = ShrinkWrap.create(JavaArchive.class)
                //
                .addPackage(PhoneBook.class.getPackage())
                // .addPackages(true, "de.fhswf.fit")
                // Add JPA persistence configuration.
                // WARN: In a jar archive, persistence.xml should be put into /META-INF
                .addAsResource("META-INF/persistence.xml").addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");

        LOGGER.log(Level.INFO, "deployment unit: {0}", jar);

        return jar;
    }

    @Test
    public void testPhoneBookInjection() {
        assertNotNull("Test injection of PhoneBookStore", phoneBook);
    }

    @Test
    public void testEMInjection() {
        assertNotNull("Test injection of EntityManager", em);
    }

    @Test
    public void testAddEntry() {
        Person person = new Person("Max Mustermann", "0123456789");
        person = phoneBook.update(person);
        Person newPerson = phoneBook.getByName("Max Mustermann");
        LOGGER.info("added: " + person + ", returned: " + newPerson);
        assertTrue("Added person should be returned by findByName()", newPerson.equals(person));
    }

}
