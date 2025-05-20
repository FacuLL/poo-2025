package Parciales.C2_2023.Ej_2;

public class CapacityLounge extends Lounge {
    private final long maxGuests;

    public CapacityLounge(LoungeCentral central, String name, long maxGuests) {
        super(central, name);
        this.maxGuests = maxGuests;
    }

    @Override
    public void enter(Passenger passenger) {
        if (getGuests() + 1 > maxGuests) throw new FullLounge("Lounge is full");
        super.enter(passenger);
    }

    public static class FullLounge extends RuntimeException {
        public FullLounge(String message) {
            super(message);
        }
    }

    @Override
    public String toString() {
        return super.toString() + " up to %d guests".formatted(maxGuests);
    }
}
