package Parciales2.C2_2023.Ej_2;

public class PlayerScore<S extends Comparable<? super S>> implements Comparable<PlayerScore<S>> {
    private final String player;
    private final S score;

    public PlayerScore(String player, S score) {
        this.player = player;
        this.score = score;
    }

    @Override
    public int compareTo(PlayerScore<S> o) {
        int cmp = o.score.compareTo(score);
        if (cmp == 0) cmp = player.compareTo(o.player);
        return cmp;
    }

    @Override
    public String toString() {
        return "Player %s scored %s".formatted(player, score);
    }
}


