package Parciales.C1_2021.Ej_2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayTVCatalog implements TVCatalog {

    private static final int INIT_DIM = 10;
    private static final int MIN_RATING = 0;
    private static final int MAX_RATING = 10;

    private TVShow[] catalog = new TVShow[INIT_DIM];
    private int dim;

    private double minRating;
    private double maxRating = 10;

    @Override
    public TVCatalog addTVShow(String name, double rating) {
        if (dim == catalog.length) {
            this.resize();
        }
        catalog[dim++] = new TVShow(name, rating);
        return this;
    }

    private void resize() {
        catalog = Arrays.copyOf(catalog, dim + 10);
    }

    @Override
    public void setRatingRange(double min, double max) {
        if (min > max || min < MIN_RATING || max > MAX_RATING) {
            throw new IllegalArgumentException("Invalid arguments");
        }
        this.minRating = min;
        this.maxRating = max;
    }

    @Override
    public Iterator<TVResponse> iterator() {
        return new Iterator<TVResponse>() {
            private int current;
            private final double min = minRating;
            private final double max = maxRating;
            @Override
            public boolean hasNext() {
                return current < dim;
            }

            @Override
            public TVResponse next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                boolean inRange =
                        Double.compare(catalog[current].getRating(), min) >= 0 &&
                        Double.compare(catalog[current].getRating(), max) <= 0;
                return new TVResponse(catalog[current++], inRange);
            }
        };
    }
}
