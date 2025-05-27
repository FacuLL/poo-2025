package Guias.Guia_4.Ej_6;

public abstract class BinaryExpression extends Expression {
    private Expression expression1, expression2;

    public BinaryExpression(Expression expression1, Expression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    protected Expression getExpression1() {
        return expression1;
    }

    protected Expression getExpression2() {
        return expression2;
    }
}
