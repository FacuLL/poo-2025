package Guias.Guía_4.Ej_6;

public class NotExpression extends Expression {

    Expression expression;

    public NotExpression(Expression expression) {
        this.expression = expression;
    }

    @Override
    public boolean evaluate() {
        return !expression.evaluate();
    }
}
