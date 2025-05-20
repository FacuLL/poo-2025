package Guias.Guia_3.Ej_9;

public class Ellipse extends Figure {
    private final Point center;

    private final double xAxis, yAxis;

    public Ellipse(Point center, double xAxis, double yAxis) {
        this.center = center;
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * Math.sqrt((Math.pow(xAxis, 2) + Math.pow(yAxis, 2)) / 2);
    }

    @Override
    public double area() {
        return Math.PI * xAxis * yAxis;
    }
}
