package Taller_3;

import Taller_3.Exceptions.InsufficientRidesException;

public class FixedSubwayCard extends SubwayCard {
    private int rides;

    public FixedSubwayCard(SubwayCentral subwayCentral, int rides) {
        super(subwayCentral);
        this.rides = rides;
    }

    @Override
    public boolean canRide() {
        return rides > 0;
    }

    @Override
    public void ride() throws InsufficientRidesException {
        if (!canRide()) throw new InsufficientRidesException();
        rides--;
        System.out.println("Viajando...");
    }
}
