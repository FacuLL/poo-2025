package Teoricas.Teorica6.DataPlan;

public class Client {
    private final String name;
    private final DataPlan dataPlan;
    private double gbSpent;

    public Client(String name, DataPlan dataPlan) {
        this.name = name;
        this.dataPlan = dataPlan;
    }

    public void addGb(int gb) {
        gbSpent+=gb;
    }

    public boolean belowLimit() {
        return this.dataPlan.belowLimit(gbSpent);
    }

    public double total() {
        return this.dataPlan.total(gbSpent);
    }
}
