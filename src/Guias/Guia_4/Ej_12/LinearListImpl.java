package Guias.Guia_4.Ej_12;

public class LinearListImpl implements LinearList {
    private Node first, last;
    private int size;

    @Override
    public void add(Object obj) {
        Node newNode = new Node(obj);
        if (last == null) first = newNode;
        else last.setNext(newNode);
        last = newNode;
        size++;
    }

    private Node getNodeAtRecursive(int i, Node actual) {
        if (i == 0) return actual;
        return getNodeAtRecursive(i--, actual.getNext());
    }

    private Node getNodeAt(int i) {
        if (i < 0 || i >= size) throw new IndexOutOfBoundsException();
        return getNodeAtRecursive(i, first);
    }

    @Override
    public void set(int i, Object obj) {
        Node node = getNodeAt(i);
        node.setValue(obj);
    }

    @Override
    public Object get(int i) {
        Node node = getNodeAt(i);
        return node.getValue();
    }

    @Override
    public void remove(int i) {
        if (i == 0) first = first.getNext();
        else {
            Node previous = getNodeAt(i-1);
            Node toRemove = previous.getNext();
            previous.setNext(toRemove.getNext());
            if (toRemove == last) last = previous;
        }
    }

    public int indexOfRecursive(Node actual, int index, Object obj) {
        if (actual == null) return -1;
        if (actual.getValue().equals(obj)) return index;
        return indexOfRecursive(actual.getNext(), index+1, obj);
    }

    @Override
    public int indexOf(Object obj) {
        return indexOfRecursive(first, 0, obj);
    }

    @Override
    public int size() {
        return size;
    }

    private static class Node {
        private Object value;
        private Node next;

        public Node(Object value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(Object value) {
            this(value, null);
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public Object getValue() {
            return value;
        }

        public Node getNext() {
            return next;
        }
    }
}
