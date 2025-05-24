package Parciales2.C2_2023.Ej_2;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class ScoreBoard<S extends Comparable<? super S>> extends TreeSet<PlayerScore<S>> {

    public List<PlayerScore<S>> getTopScores(int n) {
        List<PlayerScore<S>> toReturn = new ArrayList<>();
        for (PlayerScore<S> score : this) {
            if (n-- == 0) return toReturn;
            toReturn.add(score);
        }
        return toReturn;
    }

}
