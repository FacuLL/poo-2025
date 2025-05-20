package Guias.Guía_4.Ej_6;

public abstract class Expression {

    public abstract boolean evaluate();

    public NotExpression not() {
        return new NotExpression(this);
    }

    public OrExpression or(Expression expression) {
        return new OrExpression(this, expression);
    }

    public AndExpression and(Expression expression) {
        return new AndExpression(this, expression);
    }
}
