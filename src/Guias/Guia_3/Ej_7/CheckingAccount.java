package Guias.Guia_3.Ej_7;

public class CheckingAccount extends BankAccount {

    private final double overdraft;

    CheckingAccount(int id, double overdraft) {
        super(id);
        this.overdraft = overdraft;
    }

    @Override
    public boolean canExtract(double amount) {
        return amount <= this.getBalance() + overdraft;
    }
}
