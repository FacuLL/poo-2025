package Guias.Guia_3.Ej_7;

public class SavingsAccount extends BankAccount {

    public SavingsAccount(int id) {
        super(id);
    }

    @Override
    public boolean canExtract(double amount) {
        return amount <= this.getBalance();
    }
}
