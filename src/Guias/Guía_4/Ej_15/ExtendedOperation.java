package Guias.Guía_4.Ej_15;

public enum ExtendedOperation implements Operation {
    MODULE("%", (op1, op2) -> op1%op2),
    POW("**", Math::pow);

    private final String name;
    private final Operation function;

    ExtendedOperation(String name, Operation function) {
        this.name = name;
        this.function = function;
    }

    public double apply(double op1, double op2) {
        return this.function.apply(op1, op2);
    }

    @Override
    public String toString() {
        return name;
    }
}
