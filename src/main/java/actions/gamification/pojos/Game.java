package actions.gamification.pojos;

import java.util.List;

public class Game {
    private int gameId;
    private String promoId;
    private String gameStatus;
    private String sourceChannel;
    private String optInDate;
    private String completedDate;
    private boolean confettiSeen;
    private double pointsEarned;
    private List<Task> task;
}
