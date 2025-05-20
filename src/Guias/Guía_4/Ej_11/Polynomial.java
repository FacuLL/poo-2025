package Guias.Guía_4.Ej_11;

import java.util.function.Function;

public class Polynomial {
    private double[] coefs;

    public Polynomial(int grade) throws InvalidGradeException {
        if (grade < 0) throw new InvalidGradeException("Invalid grade");
        coefs = new double[grade+1];
    }

    public void set(int index, double coef) throws InvalidIndexException {
        if (index < 0 || index >= coefs.length) throw new InvalidIndexException("Invalid index");
        coefs[index] = coef;
    }

    public double eval(double x) {
        double result = 0;
        for (int i = 0; i < coefs.length; i++) {
            result += coefs[i] * Math.pow(x, i);
        }
        return result;
    }
}
