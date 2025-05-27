package Guias.Guia_6.Ej_8;

import java.util.HashMap;
import java.util.Map;

public class BagImpl<T> implements Bag<T> {
    private final Map<T, Integer> map = new HashMap<>();

    @Override
    public void add(T element) {
        map.put(element, map.getOrDefault(element, 0) + 1);
    }

    @Override
    public void remove(T element) {
        Integer count = map.getOrDefault(element, 0);
        if (count < 1) return;
        if (count == 1) map.remove(element);
        map.put(element, count - 1);
    }

    @Override
    public int size() {
        int count = 0;
        for (Integer value : map.values()) count += value;
        return count;
    }

    @Override
    public int sizeDistinct() {
        return map.size();
    }

    @Override
    public boolean contains(T element) {
        return map.containsKey(element);
    }

    @Override
    public int count(T element) {
        return map.getOrDefault(element, 0);
    }
}
