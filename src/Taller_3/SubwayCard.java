package Taller_3;

import Taller_3.Exceptions.InsufficientException;

public abstract class SubwayCard {
    private SubwayCentral subwayCentral;

    public SubwayCard(SubwayCentral subwayCentral) {
        this.subwayCentral = subwayCentral;
    }

    protected SubwayCentral getSubwayCentral() {
        return subwayCentral;
    }

    public abstract boolean canRide();

    public abstract void ride() throws InsufficientException;
}
