package Parciales2.C1_2023.Ej_2;

import java.util.*;

public class AddressBook {
    private final SortedMap<AddressBookGroup, SortedSet<Contact>> book = new TreeMap<>();

    public void addContact(AddressBookGroup group, String name, String phoneNumber) {
        book.putIfAbsent(group, new TreeSet<>());
        book.get(group).add(new Contact(name, phoneNumber));
    }

    public Contact getContact(AddressBookGroup group, String name) {
        SortedSet<Contact> contactGroup = book.get(group);
        if (group == null) throw new IllegalArgumentException();
        for (Contact contact : contactGroup) {
            if (contact.getName().equals(name)) return contact;
        }
        throw new IllegalArgumentException();
    }

    public List<Contact> getAllContacts(AddressBookGroup group) {
        List<Contact> toReturn = new ArrayList<>();
        SortedSet<Contact> contactGroup = book.get(group);
        if (contactGroup == null) return toReturn;
        toReturn.addAll(contactGroup);
        return toReturn;
    }

    public List<Contact> getAllContacts() {
        List<Contact> toReturn = new ArrayList<>();
        book.values().forEach(toReturn::addAll);
        return toReturn;
    }

    public void renameContact(AddressBookGroup group, String name, String newName) {
        SortedSet<Contact> contactGroup = book.get(group);
        if (contactGroup == null) throw new IllegalArgumentException();
        for (Contact contact : contactGroup) {
            if (contact.getName().equals(name)) {
                contact.setName(newName);
                return;
            }
        }
        throw new IllegalArgumentException();
    }
}
