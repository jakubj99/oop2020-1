package wsb.threads;

public class Winner {

    private final Double score;
    private final Finisher finisher;

    Winner(Double score, Finisher finisher) {
        this.score = score;
        this.finisher = finisher;
    }

    public Double getScore() {
        return score;
    }
    public Finisher getFinisher() {
        return finisher;
    }
}
