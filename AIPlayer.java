import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AIPlayer extends Player {

    public AIPlayer(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public String getMove(Board board) {
        int bestMoveValue = Integer.MIN_VALUE;
        String bestMove = "";

        List<String> validMoves = getValidMoves(board);
        for (String move : validMoves) {
            Board tempBoard = board.clone(); 
            makeMove(tempBoard, move);
            int moveValue = minimax(tempBoard, 3, false);  
            if (moveValue > bestMoveValue) {
                bestMoveValue = moveValue;
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
        String[] moveParts = move.split(" ");
        int startX = Integer.parseInt(moveParts[0]);
        int startY = Integer.parseInt(moveParts[1]);
        int endX = Integer.parseInt(moveParts[2]);
        int endY = Integer.parseInt(moveParts[3]);

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

            int moveValue = minimax(tempBoard, depth - 1, !isMaximizing);
            if (isMaximizing) {
                bestValue = Math.max(bestValue, moveValue);
            } else {
                bestValue = Math.min(bestValue, moveValue);
            }
        }

        return bestValue;
    }
    private int evaluateBoard(Board board) {
        int score = 0;

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                Piece piece = board.getPiece(x, y);
                if (piece != null) {
                    int pieceValue = getPieceValue(piece);
                    score += piece.getColor().equals(this.color) ? pieceValue : -pieceValue;
                }
            }
        }

        return score;
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

