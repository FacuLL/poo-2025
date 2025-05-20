package Guias.Guia_3.Ej_9;

public class Rectangle extends Figure {
    private final Point corner1, corner2;

    public Rectangle(Point corner1, Point corner2) {
        this.corner1 = corner1;
        this.corner2 = corner2;
    }

    public double base() {
        return Math.abs(corner1.getX() - corner2.getX());
    }

    public double height() {
        return Math.abs(corner1.getY() - corner2.getY());
    }

    @Override
    public double perimeter() {
        return (base() + height()) * 2;
    }

    @Override
    public double area() {
        return base() * height();
    }
}
