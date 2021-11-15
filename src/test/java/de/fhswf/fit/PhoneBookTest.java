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

import java.util.logging.Level;
import java.util.logging.Logger;

@RunWith(Arquillian.class)
public class PhoneBookTest {

    private static final Logger LOGGER = Logger.getLogger(PhoneBookTest.class.getName());

    @Inject
    PhoneBook store;

    // @PersistenceContext
    // EntityManager em;

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
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml");

        LOGGER.log(Level.INFO, "deployment unit: {0}", jar);

        return jar;
    }

    @Test
    public void dummy() {
        assertNotNull("Test injection of PhoneBookStore", store);
    }

}
