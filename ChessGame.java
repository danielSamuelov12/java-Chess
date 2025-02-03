import java.util.Stack;

public class ChessGame {
    private Player whitePlayer;
    private Player blackPlayer;
    private Board board;
    private Player currentPlayer;
    private Stack<Board> history;

    public ChessGame(Player whitePlayer, Player blackPlayer) {
        this.whitePlayer = whitePlayer;
        this.blackPlayer = blackPlayer;
        this.board = new Board();
        this.currentPlayer = whitePlayer;
        this.history = new Stack<>();
    }

    public ChessGame(Player whitePlayer) {
        this.whitePlayer = whitePlayer;
        this.blackPlayer = new AIPlayer(false);
        this.board = new Board();
        this.currentPlayer = whitePlayer;
        this.history = new Stack<>();
    }

    public void play() {
        while (true) {
            board.printBoard();
            System.out.println("It's " + currentPlayer.getColor() + "'s turn.");
            String move = currentPlayer.getMove(board);
            if (move.equalsIgnoreCase("undo")) {
                undoMove();
                continue;
            }
            String[] moveParts = move.split(" ");
            if (moveParts.length != 4) {
                System.out.println("Invalid move format, try again.");
                continue;
            }
            int startX, startY, endX, endY;
            try {
                startX = Integer.parseInt(moveParts[0]);
                startY = Integer.parseInt(moveParts[1]);
                endX = Integer.parseInt(moveParts[2]);
                endY = Integer.parseInt(moveParts[3]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid move numbers, try again.");
                continue;
            }
            Piece piece = board.getPiece(startX, startY);
            if (piece == null || !piece.getColor().equals(currentPlayer.getColor()) || !piece.isValidMove(endX, endY, board)) {
                System.out.println("Invalid move, try again.");
                continue;
            }
            history.push(board.clone());
            board.setPiece(endX, endY, piece);
            board.setPiece(startX, startY, null);
            if (checkGameOver()) {
                board.printBoard();
                break;
            }
            switchPlayer();
        }
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == whitePlayer) ? blackPlayer : whitePlayer;
    }

    public void undoMove() {
        if (!history.isEmpty()) {
            board = history.pop();
            System.out.println("Undo successful.");
            switchPlayer();
        } else {
            System.out.println("No moves to undo.");
        }
    }

    private boolean checkGameOver() {
        if (board.isKingInCheck(currentPlayer.getColor())) {
            if (isCheckmate(currentPlayer.getColor())) {
                System.out.println("Checkmate! " + currentPlayer.getColor() + " loses.");
                return true;
            } else {
                System.out.println("Check! " + currentPlayer.getColor() + " is in check.");
            }
        }
        return false;
    }

    private boolean isCheckmate(String color) {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Piece piece = board.getPiece(row, col);
                if (piece != null && piece.getColor().equals(color)) {
                    for (int newRow = 0; newRow < 8; newRow++) {
                        for (int newCol = 0; newCol < 8; newCol++) {
                            if (piece.isValidMove(newRow, newCol, board)) {
                                Piece tempPiece = board.getPiece(newRow, newCol);
                                board.setPiece(newRow, newCol, piece);
                                board.setPiece(row, col, null);
                                boolean inCheck = board.isKingInCheck(color);
                                board.setPiece(row, col, piece);
                                board.setPiece(newRow, newCol, tempPiece);
                                if (!inCheck) {
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
