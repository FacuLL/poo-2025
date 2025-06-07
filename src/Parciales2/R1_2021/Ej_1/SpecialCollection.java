package Parciales2.R1_2021.Ej_1;

import java.util.SortedSet;
import java.util.function.Predicate;

public interface SpecialCollection<T extends Comparable <? super T>> extends SortedSet<T> {
    public void deleteFirst();
    public void deleteFirst(Predicate<T> predicate);
    public void undoDeleteFirst();
}