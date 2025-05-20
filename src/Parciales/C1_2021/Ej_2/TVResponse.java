package Parciales.C1_2021.Ej_2;

public class TVResponse {
    private TVShow show;
    private boolean inRange;

    TVResponse(TVShow show, boolean inRange) {
        this.show = show;
        this.inRange = inRange;
    }

    @Override
    public String toString() {
        return show.toString() + " " + (inRange ? "In Range" : "Out of Range");
    }
}
