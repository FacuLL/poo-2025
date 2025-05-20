package Guias.Guia_3.Ej_6;

import java.util.Objects;

public class ComplexNumber {

    double real;
    double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public ComplexNumber(Number real) {
        this(real.doubleValue(), 0);
    }

    public ComplexNumber plus(Number number) {
        return new ComplexNumber(
                real + number.doubleValue(),
                imaginary
        );
    }

    public ComplexNumber plus(ComplexNumber number) {
        return new ComplexNumber(
                real + number.real,
                imaginary + number.imaginary
        );
    }

    @Override
    public boolean equals(Object obj) {
        return
            obj instanceof ComplexNumber complex &&
            Double.compare(real, complex.real) == 0 &&
            Double.compare(imaginary, complex.imaginary) == 0;
    }

    @Override
    public String toString() {
        return Double.toString(real) + " + " + Double.toString(imaginary) + "i";
    }
}
