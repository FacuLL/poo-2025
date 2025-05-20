package Guias.Guía_4.Ej_3;

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

    @Override
    public void moveNorth(double delta) {
        this.center.moveNorth(delta);
    }

    @Override
    public void moveEast(double delta) {
        this.center.moveEast(delta);
    }
}
