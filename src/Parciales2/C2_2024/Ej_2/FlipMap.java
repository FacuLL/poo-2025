package Parciales2.C2_2024.Ej_2;
import java.util.*;
import java.util.function.BinaryOperator;

public class FlipMap<T extends Comparable<? super T>, V> extends TreeMap<T, V> {
    private Map<V, T> flip(SequencedMap<T, V> map, T base, BinaryOperator<T> function) {
        Map<V, T> toReturn = new HashMap<>();
        map.forEach((key, value) -> {
            T previous = toReturn.getOrDefault(value, base);
            toReturn.put(value, function.apply(previous, key));
        });
        return toReturn;
    }

    public Map<V, T> flip(T base, BinaryOperator<T> function) {
        return this.flip(this, base, function);
    }

    public Map<V, T> flipInverse(T base, BinaryOperator<T> function) {
        return this.flip(this.reversed(), base, function);
    }

}
