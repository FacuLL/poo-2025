package Guias.Guia_4.Ej_6;

public class OrExpression extends BinaryExpression {
    public OrExpression(Expression expression1, Expression expression2) {
        super(expression1, expression2);
    }

    @Override
    public boolean evaluate() {
        return getExpression1().evaluate() || getExpression2().evaluate();
    }
}
