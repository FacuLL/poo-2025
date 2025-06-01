package Guias.Guía_7.Ej_2;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public interface SimpleList<T> extends List<T> {
    public <V> V reduce(V initial, BiFunction<V, T, V> reducer);
}
