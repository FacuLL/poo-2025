package Parciales.C1_2021.Ej_2;

public interface TVCatalog extends Iterable<TVResponse> {

    TVCatalog addTVShow(String name, double rating);

    void setRatingRange(double min, double max);

}

