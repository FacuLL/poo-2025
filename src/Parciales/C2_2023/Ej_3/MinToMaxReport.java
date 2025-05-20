package Parciales.C2_2023.Ej_3;

import java.util.Arrays;
import java.util.Comparator;

public class MinToMaxReport<E> extends ReportsArray<E> {
    private final Comparator<? super E> cmp;

    public MinToMaxReport(Comparator<? super E> cmp) {
        this.cmp = cmp;
    }

    @Override
    public E[] reports() {
        E[] toReturn = super.reports();
        Arrays.sort(toReturn, cmp);
        return toReturn;
    }
}
