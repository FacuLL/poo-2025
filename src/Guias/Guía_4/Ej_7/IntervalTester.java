package Guias.Guía_4.Ej_7;

public class IntervalTester {
    public static void main(String[] args) {
        Interval interval = new Interval(2, 5);
        System.out.println(interval.size()); // 4
        System.out.println(interval.indexOf(-1)); // 0
        System.out.println(interval.includes(2)); // true
        System.out.println(interval.at(2)); // 3
        System.out.println(interval);
        System.out.println(interval.count(number -> number > 3)); // 2

    }
}
