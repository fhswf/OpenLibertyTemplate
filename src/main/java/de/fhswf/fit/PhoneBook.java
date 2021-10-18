package de.fhswf.fit;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named("phoneBook")
@SessionScoped
public class PhoneBook implements Serializable {
    public static class Person {
        private String name;
        private String phoneNumber;

        public Person(String name, String phoneNumber) {
            this.name = name;
            this.phoneNumber = phoneNumber;
        }

        public String getName() {
            return name;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }
    }

    private List<Person> persons = new ArrayList<Person>();

    public PhoneBook() {
        persons.add(new Person("John Doe", "123456789"));
        persons.add(new Person("Jane Doe", "987654321"));
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
                person.phoneNumber = phoneNumber;
            }
        }
    }

    public void removePerson(String name) {
       persons = persons.stream().filter(person -> !person.getName().equals(name)).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }
}
