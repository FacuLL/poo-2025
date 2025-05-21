package Guias.Guia_6.Ej_6;

import java.util.*;

public class PersonCollectionImpl implements PersonCollection {
    private final TreeSet<Person> persons = new TreeSet<>((p1, p2) -> {
        int cmp;
        if ((cmp = p1.getLastName().compareTo(p2.getLastName())) != 0) return cmp;
        if ((cmp = p1.getFirstName().compareTo(p2.getFirstName())) != 0) return cmp;
        return cmp;
    });

    @Override
    public void addPerson(Person aPerson) {
        persons.add(aPerson);
    }

    @Override
    public Person findByName(String firstName, String lastName) {
        for (Person person: persons) {
            if (person.getLastName().compareTo(lastName) > 0) return null;
            else if (person.getFirstName().compareTo(firstName) > 0) return null;
            else if (person.getFirstName().equals(firstName) && person.getLastName().equals(lastName)) return person;
        }
        return null;
    }

    @Override
    public List<Person> findByLastName(String lastName) {
        List<Person> toReturn = new ArrayList<>();
        if (!persons.isEmpty() && persons.getFirst().getLastName().compareTo(lastName) > 0) return toReturn;
        for (Person person : persons) {
            if (person.getLastName().equals(lastName)) toReturn.add(person);
            else if (!toReturn.isEmpty()) return toReturn;
        }
        return toReturn;
    }
}
