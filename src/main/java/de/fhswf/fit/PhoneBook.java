package de.fhswf.fit;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import jakarta.inject.Inject;

import org.primefaces.event.CellEditEvent;

@Named("phoneBook")
@SessionScoped
public class PhoneBook implements Serializable {

    transient PhoneBookStore phoneBookStore;

    private List<Person> persons = new ArrayList<Person>();

    public PhoneBook() {
    }

    public void init() {
        System.out.println("initializing PhoneBook");

        List<Person> persons = this.phoneBookStore.getAll();
        this.persons.addAll(persons);
    }

    @Inject
    public void setPhoneBookStore(PhoneBookStore phoneBookStore) {
        this.phoneBookStore = phoneBookStore;
        init();
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
        Person person = new Person(name, phoneNumber);
        System.out.println("addPerson: " + person.getName() + " " + person.getPhoneNumber());
        phoneBookStore.add(person);
        persons = phoneBookStore.getAll();
    }

    public void savePerson(String name, String phoneNumber) {
        Person person = new Person(name, phoneNumber);
        savePerson(person);
    }

    public void savePerson(Person person) {
        System.out.println("savePerson: " + person.getName() + " " + person.getPhoneNumber());
        phoneBookStore.update(person);
        persons = phoneBookStore.getAll();
    }

    public void newEntry() {
        persons.add(new Person("", ""));
    }

    public void removePerson(String name) {
        System.out.println("deletePerson: " + name);
        Person p = phoneBookStore.getByName(name);
        phoneBookStore.delete(p);
        persons = phoneBookStore.getAll();
    }
}
