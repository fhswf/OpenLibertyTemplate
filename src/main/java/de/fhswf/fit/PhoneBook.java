package de.fhswf.fit;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import org.primefaces.event.CellEditEvent;

@Named("phoneBook")
@ViewScoped
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

        public void setName(String name) {
            this.name = name;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            System.out.println("Setter for " + this.name + ", setPhoneNumber: " + phoneNumber);
            this.phoneNumber = phoneNumber;
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

    public void onCellEdit(CellEditEvent event) {
        String oldValue = event.getOldValue().toString();
        String newValue = event.getNewValue().toString();
        System.out.println("onEdit: " + oldValue + " -> " + newValue);
        if (newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed",
                    "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
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

    public void newEntry() {
        persons.add(new Person("", ""));
    }

    public void removePerson(String name) {
        persons = persons.stream().filter(person -> !person.getName().equals(name)).collect(ArrayList::new,
                ArrayList::add, ArrayList::addAll);
    }
}
