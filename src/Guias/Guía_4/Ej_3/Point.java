package Guias.Guía_4.Ej_3;

public class Point implements Movable {
    private double x,y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double distanceTo(Point p) {
        return Math.sqrt(Math.pow(x-p.x, 2) + Math.pow(y-p.y, 2));
    }

    @Override
    public void moveNorth(double delta) {
        this.y += delta;
    }

    @Override
    public void moveEast(double delta) {
        this.y += delta;
    }
}
