package Parciales2.R1_2020.Ej_1;

import java.util.Map;
import java.util.function.UnaryOperator;

public interface SpecialMap<K, V> extends Map<K, V> {
    public SpecialMap<K, V> convert(UnaryOperator<K> keyMap, UnaryOperator<V> valueMap);
}
