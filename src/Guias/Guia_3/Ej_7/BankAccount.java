package Guias.Guia_3.Ej_7;

public abstract class BankAccount {
    private int id;
    private double balance;

    public BankAccount(int id) {
        this.id = id;
    }

    public abstract boolean canExtract(double amount);

    public void extract(double amount) {
        if (canExtract(amount)) balance -= amount;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Cuenta %d con balance $%g".formatted(id, balance);
    }
}
