package Guias.Guia_4.Ej_6;

public class SimpleExpression extends Expression {
    private boolean expression;

    public SimpleExpression(boolean expression) {
        this.expression = expression;
    }

    @Override
    public boolean evaluate() {
        return expression;
    }

    public void setValue(boolean expression) {
        this.expression = expression;
    }
}
