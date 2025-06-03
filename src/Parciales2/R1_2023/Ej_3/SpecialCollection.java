package Parciales2.R1_2023.Ej_3;

import java.util.SortedSet;
import java.util.function.Predicate;

public interface SpecialCollection<T> extends SortedSet<T> {
    int count(Predicate<T> predicate);
    public int count(T min, T max, Predicate<T> predicate);
}
