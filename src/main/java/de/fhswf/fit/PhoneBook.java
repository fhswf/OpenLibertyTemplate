package de.fhswf.fit;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named("phoneBook")
@SessionScoped
public class PhoneBook implements Serializable {

    transient PhoneBookStore phoneBookStore;

    private List<Person> persons = new ArrayList<Person>();

    public PhoneBook() {
    }

    @Inject
    @Named("phoneBookStore")
    public void setPhoneBookStore(PhoneBookStore phoneBookStore) {
        this.phoneBookStore = phoneBookStore;
        System.out.println("initializing PhoneBook");

        List<Person> persons = this.phoneBookStore.getAll();
        this.persons.addAll(persons);
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void addPerson(String name, String phoneNumber) {
        persons.add(new Person(name, phoneNumber));
    }

    public void savePerson(String name, String phoneNumber) {
        for (Person person : persons) {
            if (person.getName().equals(name)) {
                person.setPhoneNumber(phoneNumber);
            }
        }
    }

    public void removePerson(String name) {
        persons = persons.stream().filter(person -> !person.getName().equals(name)).collect(ArrayList::new,
                ArrayList::add, ArrayList::addAll);
    }
}
