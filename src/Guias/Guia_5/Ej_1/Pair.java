package Guias.Guia_5.Ej_1;

public class Pair<E, T> {
    private E first;
    private T second;

    Pair(E first, T second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Pair<?,?> pair)) return false;
        return first.equals(pair.first) && second.equals(pair.second);
    }
}
