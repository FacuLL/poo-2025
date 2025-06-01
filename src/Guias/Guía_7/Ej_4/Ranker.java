package Guias.Guía_7.Ej_4;

import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.Predicate;

public class Ranker {
    SortedSet<BookRate> books = new TreeSet<>();

    public Ranker add(Genre genre, Book book) {
        books.add(new BookRate(book, genre));
        return this;
    }

    public void rateUp(Book book) {

    }

    private void print(Predicate<BookRate> predicate) {
        for (BookRate bookRate : books) {
            if (predicate.test(bookRate)) System.out.println(bookRate);
        }
    }

    public void printRanking(Genre genre) {
        print(book -> book.getGenre().equals(genre));
    }

    public void printRanking() {
        print(_ -> true);
    }


}
