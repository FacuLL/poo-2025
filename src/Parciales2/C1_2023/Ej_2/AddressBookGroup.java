package Parciales2.C1_2023.Ej_2;

import java.util.Objects;

public class AddressBookGroup implements Comparable<AddressBookGroup> {
    private final String name;

    public AddressBookGroup(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(AddressBookGroup o) {
        return name.compareTo(o.name);
    }
}

