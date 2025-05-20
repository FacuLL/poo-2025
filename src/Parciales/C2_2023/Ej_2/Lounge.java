package Parciales.C2_2023.Ej_2;

public class Lounge {
    private LoungeCentral central;
    private final String name;
    private long guests;

    public Lounge(LoungeCentral central, String name) {
        this.central = central;
        this.name = name;
    }

    public void enter(Passenger passenger) {
        if (!this.central.isOpen()) throw new LoungeCentralClosed("Cannot enter");
        passenger.usePass();
        guests++;
    }

    public void exit(long guests) {
        if (guests <= 0) throw new IllegalArgumentException();
        if (guests > this.guests) throw new IllegalArgumentException();
        this.guests-=guests;
    }

    public void exit() {
        this.exit(1);
    }

    protected long getGuests() {
        return guests;
    }

    @Override
    public String toString() {
        return "%s has %d guests".formatted(name, guests);
    }

    public static class LoungeCentralClosed extends RuntimeException {
        public LoungeCentralClosed(String message) {
            super(message);
        }
    }
}
