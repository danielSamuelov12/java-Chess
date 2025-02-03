public class ChessGame {
    private Player whitePlayer;
    private Player blackPlayer;
    private Board board;
    private Player currentPlayer;

    public ChessGame(Player whitePlayer, Player blackPlayer) {
        this.whitePlayer = whitePlayer;
        this.blackPlayer = blackPlayer;
        this.board = new Board();
        this.currentPlayer = whitePlayer;
    }

    public ChessGame(Player whitePlayer) {
        this.whitePlayer = whitePlayer;
        this.blackPlayer = new AIPlayer(false);
        this.board = new Board();
        this.currentPlayer = whitePlayer;
    }

    public void play() {
        while (true) {
            board.printBoard();
            System.out.println("It's " + currentPlayer.getColor() + "'s turn.");
            String move = currentPlayer.getMove(board);

            String[] moveParts = move.split(" ");
            int startX = Integer.parseInt(moveParts[0]);
            int startY = Integer.parseInt(moveParts[1]);
            int endX = Integer.parseInt(moveParts[2]);
            int endY = Integer.parseInt(moveParts[3]);

            Piece piece = board.getPiece(startX, startY);
            if (piece != null && piece.getColor().equals(currentPlayer.getColor()) && piece.isValidMove(endX, endY, board)) {
                board.setPiece(endX, endY, piece);
                board.setPiece(startX, startY, null);
            } else {
                System.out.println("Invalid move, try again.");
                continue;
            }

            if (checkGameOver()) {
                break;
            }

            switchPlayer();
        }
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == whitePlayer) ? blackPlayer : whitePlayer;
    }

    private boolean checkGameOver() {
        if (board.isKingInCheck(currentPlayer.getColor())) {
            if (isCheckmate(currentPlayer.getColor())) {
                System.out.println("Checkmate! " + currentPlayer.getColor() + " loses.");
                return true;
            } else {
                System.out.println("Check! " + currentPlayer.getColor() + " is in check.");
                return false;
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

                                if (!board.isKingInCheck(color)) {
                                    board.setPiece(row, col, piece);
                                    board.setPiece(newRow, newCol, tempPiece);
                                    return false;
                                }

                                board.setPiece(row, col, piece);
                                board.setPiece(newRow, newCol, tempPiece);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
