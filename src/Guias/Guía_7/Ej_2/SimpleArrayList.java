package Guias.Guía_7.Ej_2;

import java.util.ArrayList;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class SimpleArrayList<T> extends ArrayList<T> implements SimpleList<T> {
    @Override
    public <V> V reduce(V initial, BiFunction<V, T, V> reducer) {
        for (T elem : this) initial = reducer.apply(initial, elem);
        return initial;
    }
}
