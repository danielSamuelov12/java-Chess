import java.util.ArrayList;
import java.util.List;

public class AIPlayer extends Player {
    public AIPlayer(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public String getMove(Board board) {
        int bestValue = Integer.MIN_VALUE;
        String bestMove = "";
        List<String> validMoves = getValidMoves(board);
        for (String move : validMoves) {
            Board tempBoard = board.clone();
            makeMove(tempBoard, move);
            int moveValue = minimax(tempBoard, 3, false);
            if (moveValue > bestValue) {
                bestValue = moveValue;
                bestMove = move;
            }
        }
        System.out.println("AI move: " + bestMove);
        return bestMove;
    }

    private List<String> getValidMoves(Board board) {
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
        return validMoves;
    }

    private void makeMove(Board board, String move) {
        String[] parts = move.split(" ");
        int startX = Integer.parseInt(parts[0]);
        int startY = Integer.parseInt(parts[1]);
        int endX = Integer.parseInt(parts[2]);
        int endY = Integer.parseInt(parts[3]);
        Piece piece = board.getPiece(startX, startY);
        if (piece != null && piece.isValidMove(endX, endY, board)) {
            board.setPiece(endX, endY, piece);
            board.setPiece(startX, startY, null);
        }
    }

    private int minimax(Board board, int depth, boolean isMaximizing) {
        if (depth == 0 || board.isKingInCheck(this.color)) {
            return evaluateBoard(board);
        }
        List<String> validMoves = getValidMoves(board);
        int bestValue = isMaximizing ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        for (String move : validMoves) {
            Board tempBoard = board.clone();
            makeMove(tempBoard, move);
            int value = minimax(tempBoard, depth - 1, !isMaximizing);
            if (isMaximizing) {
                bestValue = Math.max(bestValue, value);
            } else {
                bestValue = Math.min(bestValue, value);
            }
        }
        return bestValue;
    }

    private int evaluateBoard(Board board) {
        int score = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece piece = board.getPiece(i, j);
                if (piece != null) {
                    int value = getPieceValue(piece);
                    score += piece.getColor().equals(this.color) ? value : -value;
                }
            }
        }
        return score;
    }

    private int getPieceValue(Piece piece) {
        switch (piece.getType()) {
            case "Pawn": return 1;
            case "Knight": return 3;
            case "Bishop": return 3;
            case "Rook": return 5;
            case "Queen": return 9;
            case "King": return 1000;
            default: return 0;
        }
    }
}
