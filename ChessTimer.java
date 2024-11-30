import java.util.Timer;
import java.util.TimerTask;

public class ChessTimer {
    private static final int TURN_TIME_SECONDS = 120;
    private int remainingTime;
    private Timer timer;
    private String color;

    public ChessTimer(String color) {
        this.timer = new Timer();
        this.color = color;
    }

    public void startTurn() {
        this.remainingTime = TURN_TIME_SECONDS;

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                remainingTime--;
                if (remainingTime <= 0) {
                    System.out.println();
                    System.out.println(color + " ran out of time!");
                    endTurn();
                }
            }
        }, 0, 1000);
    }

    public void endTurn() {
        timer.cancel();
    }

    public int getRemainingTime() {
        return remainingTime;
    }
}
