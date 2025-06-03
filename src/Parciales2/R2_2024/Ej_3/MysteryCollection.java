package Parciales2.R2_2024.Ej_3;

import java.util.Collection;
import java.util.TreeSet;
import java.util.function.BinaryOperator;

public class MysteryCollection<T> extends TreeSet<T> {
    private T reduceWith(Collection<T> collection, T base, BinaryOperator<T> reducer) {
        for (T elem : collection) {
            base = reducer.apply(base, elem);
        }
        return base;
    }

    public T reduce(T base, BinaryOperator<T> reducer) {
        return reduceWith(this, base, reducer);
    }

    public T reduceInverse(T base, BinaryOperator<T> reducer) {
        return reduceWith(this.reversed(), base, reducer);
    }
}
