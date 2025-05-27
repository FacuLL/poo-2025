package Guias.Guia_6.Ej_7;

import java.util.Collection;

public class Ej_7 {
    public static <T extends Comparable<? super T>> T mayor(Collection<T> collection) {
        T max = null;
        for (T elem : collection) {
            if (max == null || max.compareTo(elem) < 0) max = elem;
        }
        return max;
    }
}
