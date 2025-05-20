package Parciales.C2_2023.Ej_3;

import java.util.Arrays;
import java.util.Comparator;

public class MaxToMinReport<E> extends MinToMaxReport<E> {
    public MaxToMinReport(Comparator<? super E> cmp) {
        super(cmp.reversed());
    }
}
