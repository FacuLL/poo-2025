package Teoricas.Teorica6.DataPlan;

public enum DataPlan {
    BASIC(10, 10) {
        @Override
        public double extraGb(double gbSpent) {
            return gbSpent - 1;
        }
    },
    PREMIUM(20, 5) {
        @Override
        public double extraGb(double gbSpent) {
            return gbSpent - 3;
        }
    },
    UNLIMITED(70, 0) {
        @Override
        public double extraGb(double gbSpent) {
            return 0;
        }
    };

    private final double planPrice, extraGBPrice;

    DataPlan(double planPrice, double extraGBPrice) {
        this.planPrice = planPrice;
        this.extraGBPrice = extraGBPrice;
    }

    public abstract double extraGb(double gbSpent);

    public boolean belowLimit(double gbSpent) {
        return extraGb(gbSpent) <= 0;
    }

    public double total(double gbSpent) {
        return planPrice + extraGBPrice * extraGb(gbSpent);
    }
}
