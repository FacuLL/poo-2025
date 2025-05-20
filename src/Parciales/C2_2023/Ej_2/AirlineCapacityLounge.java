package Parciales.C2_2023.Ej_2;

public class AirlineCapacityLounge extends CapacityLounge {
    private String admittedAirline;

    public AirlineCapacityLounge(LoungeCentral central, String name, long maxGuests, String admittedAirline) {
        super(central, name, maxGuests);
        this.admittedAirline = admittedAirline;
    }

    @Override
    public void enter(Passenger passenger) {
        if (!passenger.getAirline().equals(admittedAirline)) throw new UnadmittedAirline("Cannot enter lounge");
        super.enter(passenger);
    }

    @Override
    public String toString() {
        return admittedAirline + " " + super.toString();
    }

    public static class UnadmittedAirline extends RuntimeException {
        public UnadmittedAirline(String message) {
            super(message);
        }
    }
}
