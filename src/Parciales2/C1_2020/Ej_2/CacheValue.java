package Parciales2.C1_2020.Ej_2;

public class CacheValue<V> {
    private V value;
    private Integer access = 0;

    public CacheValue(V value) {
        this.value = value;
    }

    public Integer getAccess() {
        return access;
    }

    public V getValue() {
        access++;
        return value;
    }
}
