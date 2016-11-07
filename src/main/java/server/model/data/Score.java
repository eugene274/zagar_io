package server.model.data;


public class Score {
    private final Long userId;
    private Integer score;

    public Score (Long userID, int score){
        this.score = score;
        this.userId = userID;
    }

    public Long getUserId() {
        return userId;
    }

    public Integer getScore() {
        return score;
    }

    public void addScore (int amount){
        score += amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Score score = (Score) o;

        return getUserId().equals(score.getUserId());

    }

    @Override
    public int hashCode() {
        return getUserId().hashCode();
    }
}
