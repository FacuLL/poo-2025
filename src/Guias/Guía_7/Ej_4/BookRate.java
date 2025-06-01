package Guias.Guía_7.Ej_4;

public class BookRate implements Comparable<BookRate> {
    private final Book book;
    private Genre genre;
    private Integer rating = 0;

    public BookRate(Book book, Genre genre) {
        this.book = book;
        this.genre = genre;
    }

    @Override
    public int compareTo(BookRate o) {
        return o.rating.compareTo(this.rating);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof BookRate bookRate)) return false;
        return bookRate.getBook().equals(book);
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public void rateUp(Integer rating) {
        this.rating++;
    }

    public Book getBook() {
        return book;
    }

    public Genre getGenre() {
        return genre;
    }

    public Integer getRating() {
        return rating;
    }
}
