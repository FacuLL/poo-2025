package Parciales2.R1_2020.Ej_1;

import java.util.HashMap;
import java.util.Map;
import java.util.function.UnaryOperator;

public class SpecialHashMap<K, V> extends HashMap<K, V> implements SpecialMap<K, V> {
    @Override
    public SpecialMap<K, V> convert(UnaryOperator<K> keyMap, UnaryOperator<V> valueMap) {
        SpecialMap<K, V> newMap = new SpecialHashMap<>();
        for(Map.Entry<K, V> entry : this.entrySet()) {
            newMap.put(keyMap.apply(entry.getKey()), valueMap.apply(entry.getValue()));
        }
        return newMap;
    }
}
