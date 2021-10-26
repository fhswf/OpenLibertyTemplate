package de.fhswf.fit;

import java.util.List;

import jakarta.annotation.ManagedBean;
import jakarta.ejb.Stateless;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceUnit;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@PersistenceUnit
@Named("phoneBookStore")
@Stateless
public class PhoneBookStore {

    @PersistenceContext
    EntityManager em;

    public List<Person> getAll() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Person> cq = cb.createQuery(Person.class);
        Root<Person> root = cq.from(Person.class);
        cq.select(root);
        TypedQuery<Person> query = em.createQuery(cq);
        return query.getResultList();
    }

    public Person getByName(String name) {
        Person p = em.find(Person.class, name);
        return p;
    }

    public Person addPerson(Person p) {
        em.persist(p);
        return p;
    }
}
