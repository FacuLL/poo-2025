package Parciales.C2_2023.Ej_2;

public class Passenger {
    private final String name, airline;
    private long passes;

    public Passenger(String name, String airline, long passes) {
        this.name = name;
        this.airline = airline;
        this.passes = passes;
    }

    public long getPasses() {
        return passes;
    }

    public void usePass() {
        if (passes <= 0) throw new NotPassAvailable("Cannot enter lounge");
        passes--;
    }

    public String getAirline() {
        return airline;
    }

    static public class NotPassAvailable extends RuntimeException {
        public NotPassAvailable(String message) {
            super(message);
        }
    }
}
