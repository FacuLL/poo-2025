package Guias.Guia_6.Ej_3;

import Guias.Guia_5.Ej_1.Pair;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class PairCyclicIterator<E> implements Iterator<Pair<E, E>> {

    private final Collection<E> list;
    private Iterator<E> iterator;

    public PairCyclicIterator(Collection<E> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return list.size() > 1;
    }

    private E getSingleNext() {
        if (iterator == null || !iterator.hasNext()) iterator = list.iterator();
        return iterator.next();
    }

    @Override
    public Pair<E, E> next() {
        if (!hasNext()) throw new NoSuchElementException();
        return new Pair<>(getSingleNext(), getSingleNext());
    }
}
