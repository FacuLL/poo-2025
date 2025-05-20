package Guias.Guía_4.Ej_7;

public class Interval {
    private double start, end, interval;

    public Interval(double start, double end, double interval) {
        if (interval == 0) throw new IllegalArgumentException();
        this.start = start;
        this.end = end;
        this.interval = interval;
    }

    public Interval(double start, double end) {
        this(start, end, 1);
    }

    private boolean isInRange(double number) {
        return (number > start && number < end) || (number < start && number > end);
    }

    public long size() {
        long size = (long) ((end - start) / interval) + 1;
        return size < 0 ? 0 : size;
    }

    public double at(long index) {
        double at = start + interval * (index-1);
        if (!isInRange(at)) throw new IllegalArgumentException();
        return at;
    }

    public long indexOf(double number) {
        double indexOf = (number - start) / interval;
        if (indexOf < 0) return 0;
        if (Double.compare(indexOf, (int) indexOf) != 0) return 0;
        return ((int) indexOf) + 1;
    }

    public boolean includes(double number) {
        return indexOf(number) > 0;
    }

    public long count(IntervalCondition condition) {
        int count = 0;
        for (double i = start; i <= end; i+=interval) {
            if (condition.meets(i)) count++;
        }
        return count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{ ");
        for (double i = start; i * interval <= end * interval; i += interval) {
            sb.append("%g, ".formatted(i));
        }
        sb.append("}");
        return sb.toString();
    }
}
