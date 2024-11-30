import java.util.Scanner;

public class HumanPlayer extends Player {
    public HumanPlayer(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public String getMove(Board board) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your move (startY startX endY endX):");
        String move = scanner.nextLine();
        return move;
    }
}
