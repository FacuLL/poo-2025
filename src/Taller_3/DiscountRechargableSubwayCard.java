package Taller_3;

public class DiscountRechargableSubwayCard extends RechargableSubwayCard {
    private final double discount;

    public DiscountRechargableSubwayCard(SubwayCentral subwayCentral, double discount) {
        super(subwayCentral);
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    @Override
    public double getRideCost() {
        return super.getRideCost() * (1 - discount / 100);
    }
}

