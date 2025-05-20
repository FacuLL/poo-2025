package Talleres.Counter;

public class MultipleCounter extends Counter {
    private final int times;

    public MultipleCounter(int times) {
        this.times = times;
    }

    @Override
    public void increment() {
        for (int i = 0; i < times; i++) {
            super.increment();
        }
    }

    @Override
    public void decrement() {
        for (int i = 0; i < times; i++) {
            super.decrement();
        }
    }
}
