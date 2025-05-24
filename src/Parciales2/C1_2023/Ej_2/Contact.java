package Parciales2.C1_2023.Ej_2;

public class Contact implements Comparable<Contact> {
    private String name;
    private final String phoneNumber;

    public Contact(String name, String phoneNumber) {
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

    @Override
    public String toString() {
        return "| %s has %s as phone number |".formatted(name, phoneNumber);
    }

    @Override
    public int compareTo(Contact o) {
        int cmp = name.compareTo(o.name);
        if (cmp == 0) cmp = phoneNumber.compareTo(o.phoneNumber);
        return cmp;
    }
}

