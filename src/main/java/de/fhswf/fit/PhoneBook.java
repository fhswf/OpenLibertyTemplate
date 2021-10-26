package de.fhswf.fit;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import org.primefaces.event.CellEditEvent;

@Named("phoneBook")
@ViewScoped
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
                person.setPhoneNumber(phoneNumber);
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
