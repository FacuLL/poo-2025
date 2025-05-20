package Guias.Guia_3.Ej_9;

public class Triangle extends Figure {
    private final Point p1,p2,p3;

    public Triangle(Point p1, Point p2, Point p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    @Override
    public double perimeter() {
        return p1.distanceTo(p2) + p1.distanceTo(p3) + p2.distanceTo(p3);
    }

    @Override
    public double area() {
        double semiperimeter = perimeter() / 2;
        return Math.sqrt(
            semiperimeter *
            (semiperimeter - p1.distanceTo(p2)) *
            (semiperimeter - p1.distanceTo(p3)) *
            (semiperimeter - p2.distanceTo(p3))
        );
    }
}
