package Talleres.Taller_3;

import Talleres.Taller_3.Exceptions.InsufficientBalanceException;

public class RechargableSubwayCard extends SubwayCard {
    private double balance;

    public RechargableSubwayCard(SubwayCentral subwayCentral) {
        super(subwayCentral);
        this.balance = 0.0;
    }

    public double getRideCost() {
        return getSubwayCentral().getRidePrice();
    }

    public double getBalance() {
        return balance;
    }

    public void recharge(double balance) {
        this.balance+=balance;
    }

    @Override
    public boolean canRide() {
        return getRideCost() <= balance;
    }

    @Override
    public void ride() throws InsufficientBalanceException {
        if (!canRide()) throw new InsufficientBalanceException();
        balance -= getSubwayCentral().getRidePrice();
        System.out.println("Viajando...");
    }
}
