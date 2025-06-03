package Parciales2.R1_2023.Ej_3;

import java.util.Collection;
import java.util.List;
import java.util.TreeSet;
import java.util.function.Predicate;

public class SpecialCollectionImpl<T extends Comparable<? super T>> extends TreeSet<T> implements SpecialCollection<T> {
    private boolean testPredicates(Collection<Predicate<T>> predicates, T element) {
        for (Predicate<T> predicate : predicates) {
            if (!predicate.test(element)) return false;
        }
        return true;
    }

    private int count(Collection<Predicate<T>> predicates) {
        int count = 0;
        for (T elem : this) {
            if (testPredicates(predicates, elem)) count++;
        }
        return count;
    }

    public int count(Predicate<T> predicate) {
        return count(List.of(predicate));
    }

    public int count(T min, T max, Predicate<T> predicate) {
        return count(List.of(predicate, elem -> elem.compareTo(min) >= 0, elem -> elem.compareTo(max) <= 0));
    }
}
