package Guias.Guia_4.Ej_15;

public enum BasicOperation implements Operation {
    SUM("+", (Double::sum)),
    SUBTRACTION("-", (op1, op2) -> op1 - op2),
    MULTIPLICATION("*", (op1, op2) -> op1 * op2),
    DIVISION("/", (op1, op2) -> op1 / op2);

    private final String name;
    private final Operation function;

    BasicOperation(String name, Operation function) {
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
