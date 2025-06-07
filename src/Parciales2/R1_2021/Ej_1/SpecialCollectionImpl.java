package Parciales2.R1_2021.Ej_1;

import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Stack;
import java.util.TreeSet;
import java.util.function.Predicate;

public class SpecialCollectionImpl<T extends Comparable<? super T>> extends TreeSet<T> implements SpecialCollection<T> {
    public Stack<T> history = new Stack<>();

    public SpecialCollectionImpl() {
        super(Comparator.reverseOrder());
    }

    public void deleteFirst(Predicate<T> predicate) {
        if (this.isEmpty()) throw new NoSuchElementException();
        if (!predicate.test(this.first())) return;
        history.push(this.first());
        this.remove(this.first());
    }

    public void deleteFirst() {
        this.deleteFirst(_ -> true);
    }

    public void undoDeleteFirst() {
        if (history.isEmpty()) throw new NothingToUndoException("Nothing to undo");
        this.add(history.pop());
    }

    public static class NothingToUndoException extends RuntimeException {
        public NothingToUndoException(String message) {
            super(message);
        }
    }
}
