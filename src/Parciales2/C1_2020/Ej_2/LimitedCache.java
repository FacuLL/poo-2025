package Parciales2.C1_2020.Ej_2;

import java.util.HashMap;
import java.util.Map;

public class LimitedCache<K,V> implements Cache<K, V> {
    Map<K, CacheValue<V>> map = new HashMap<>();
    int maxSize;

    public LimitedCache(int maxSize) {
        this.maxSize = maxSize;
    }

    private void removeLast() {
        Map.Entry<K, CacheValue<V>> min = null;
        for (Map.Entry<K, CacheValue<V>> entry : map.entrySet()) {
            if (min == null || min.getValue().getAccess() > entry.getValue().getAccess()) min = entry;
            if (entry.getValue().getAccess() == 0) break;
        }
        if (min == null) return;
        map.remove(min.getKey());
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public V get(K key) {
        CacheValue<V> value = map.get(key);
        if (value == null) return null;
        return value.getValue();
    }

    @Override
    public void add(K key, V value) {
        if (this.size() >= maxSize && !map.containsKey(key)) removeLast();
        map.put(key, new CacheValue<>(value));
    }
}
