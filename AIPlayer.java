import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AIPlayer extends Player {
    public AIPlayer(boolean isWhite) {
        super(isWhite);
    }

    @Override

    public String getMove(Board board) {
        Random random = new Random();
        List<String> validMoves = new ArrayList<>();

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                Piece piece = board.getPiece(x, y);
                if (piece != null && piece.getColor().equals(this.color)) {
                    for (int newX = 0; newX < 8; newX++) {
                        for (int newY = 0; newY < 8; newY++) {
                            if (piece.isValidMove(newX, newY, board)) {
                                validMoves.add(x + " " + y + " " + newX + " " + newY);
                            }
                        }
                    }
                }
            }
        }

        if (validMoves.isEmpty()) {
            return "No valid moves";
        }

        String move = validMoves.get(random.nextInt(validMoves.size()));
        System.out.println("AI move: " + move);
        return move;
    }
    }

