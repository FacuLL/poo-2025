package Guias.Guia_6.Ej_4;

import Guias.Guia_3.Ej_7.BankAccount;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private final List<BankAccount> accounts = new ArrayList<>();

    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    public void removeAccount(BankAccount account) {
        accounts.remove(account);
    }

    public int accountSize() {
        return accounts.size();
    }

    public double totalAmount() {
        double count = 0;
        for (BankAccount account : accounts) {
            count+=account.getBalance();
        }
        return count;
    }
}
