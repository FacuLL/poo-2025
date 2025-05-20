package Talleres.Counter;

public class CounterTester {

    public static void main(String[] args) {
        Counter c = new Counter();
        System.out.println(c.getCount());
        c.increment();
        System.out.println(c.getCount());
        c.decrement();
        System.out.println(c.getCount());

        Counter mc = new MultipleCounter(2);
        System.out.println(mc.getCount());
        mc.increment();
        System.out.println(mc.getCount());
        mc.decrement();
        System.out.println(mc.getCount());
    }

}
