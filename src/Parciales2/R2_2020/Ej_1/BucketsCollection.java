package Parciales2.R2_2020.Ej_1;

import java.util.*;
import java.util.function.Function;

class BucketsCollection<T, V extends Comparable<? super V>> {
    private final SortedMap<V, List<T>> bucket = new TreeMap<>();
    private final Function<T, V> function;

    public BucketsCollection(Function<T, V> function) {
        this.function = function;
    }

    public BucketsCollection<T, V> add(T element) {
        V key = this.function.apply(element);
        this.bucket.putIfAbsent(key, new ArrayList<>());
        this.bucket.get(key).add(element);
        return this;
    }

    public Set<V> bucketIds() {
        return bucket.sequencedKeySet().reversed();
    }

    public List<T> elements(V key) {
        return bucket.getOrDefault(key, List.of());
    }
}
