package Guias.Guia_5.Ej_1;

import java.util.Objects;

public class Pair<E, T> {
    private E first;
    private T second;

    public Pair(E first, T second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Pair<?,?> pair)) return false;
        return first.equals(pair.first) && second.equals(pair.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    @Override
    public String toString() {
        return "# %s + %s #".formatted(first.toString(), second.toString());
    }
}
