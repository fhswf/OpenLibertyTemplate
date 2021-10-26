package de.fhswf.fit;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Startup
@Singleton
public class Bootstrap {

    @Inject
    PhoneBookStore phoneBookStore;

    @PostConstruct
    public void init() {
        System.out.println("bootstraping application...");

        List<Person> persons = phoneBookStore.getAll();
        if (persons.isEmpty()) {
            Stream.of("Christian Gawron", "Sebastian Schmidt").map(s -> {
                Person person = new Person();
                person.setName(s);

                return person;
            }).map(data -> phoneBookStore.addPerson(data)).collect(Collectors.toList())
                    .forEach(person -> System.out.println(" person saved: " + person));
        } else {
            for (Person p : persons) {
                System.out.println(" person found: " + p.getName());
            }
        }
    }
}
