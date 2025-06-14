package Guias.Guía_7.Ej_3;

import java.util.*;

public class ConcatIteratorTester {
    public static void main(String[] args) {
        List<String> list1 = List.of("a", "b", "c", "d");
        List<String> list2 = List.of("1", "2", "3", "4");
        List<String> list3 = List.of("alpha", "beta");
        Iterator<String> iterator = new ConcatIterator<>(
                new ConcatIterator<>(list1.iterator(), list2.iterator()),
                list3.iterator());
        while(iterator.hasNext()) {
            System.out.print(iterator.next());
        }
    }

}

