package Guias.Guía_7.Ej_3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ConcatIterator<T> implements Iterator<T> {

    private Iterator<T> iterator1;
    private Iterator<T> iterator2;

    public ConcatIterator(Iterator<T> iterator1, Iterator<T> iterator2) {
        this.iterator1 = iterator1;
        this.iterator2 = iterator2;
    }

    @Override
    public boolean hasNext() {
        return iterator1.hasNext() || iterator2.hasNext();
    }

    @Override
    public T next() {
        if (iterator1.hasNext()) return iterator1.next();
        if (iterator2.hasNext()) return iterator2.next();
        throw new NoSuchElementException();
    }
}
