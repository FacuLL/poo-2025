package Parciales.C2_2023.Ej_3;

import java.util.Arrays;

public class ReportsArray<E> implements ReportCollection<E> {
    public static int INITIAL_LENGHT = 10;
    private E[] reports = (E[]) new Object[INITIAL_LENGHT];
    private int dim;

    @Override
    public void add(E report) {
        if (dim == reports.length) {
            reports = Arrays.copyOf(reports, reports.length + INITIAL_LENGHT);
        }
        reports[dim++] = report;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= dim) throw new IllegalArgumentException();
        return reports[index];
    }

    @Override
    public E[] reports() {
        return Arrays.copyOf(reports, dim);
    }
}
