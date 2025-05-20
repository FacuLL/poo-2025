package Talleres.Taller_4.List;

public interface List<T> {
    void add(T value);
    int contains(T value);
    boolean remove(int index);
    boolean isEmpty();
    default boolean removeElement(T value) {
        return remove(contains(value));
    }
}
