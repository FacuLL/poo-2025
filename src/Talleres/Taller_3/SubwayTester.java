package Talleres.Taller_3;

import Talleres.Taller_3.Exceptions.InsufficientBalanceException;
import Talleres.Taller_3.Exceptions.InsufficientRidesException;

public class SubwayTester {
    public static void main(String[] args) {
        SubwayCentral central = new SubwayCentral(10);
        RechargableSubwayCard rechargableCard = new RechargableSubwayCard(central);
        DiscountRechargableSubwayCard discountCard = new DiscountRechargableSubwayCard(central, 50);
        FixedSubwayCard fixedCard = new FixedSubwayCard(central, 5);
        rechargableCard.recharge(10);
        discountCard.recharge(9);
        try {
            rechargableCard.ride();
            fixedCard.ride();
            discountCard.ride();
            discountCard.ride();
        } catch(InsufficientRidesException error) {
            System.out.println("Viajes insuficientes");
        } catch(InsufficientBalanceException error) {
            System.out.println("Balance insuficiente");
        }
    }
}
