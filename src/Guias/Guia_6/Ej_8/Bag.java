package Guias.Guia_6.Ej_8;

public interface Bag<T> {
    public void add(T element);
    public void remove(T element);
    public int size();
    public int sizeDistinct();
    public int count(T element);
    public boolean contains(T element);
}
