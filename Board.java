public class Board {
    private Piece[][] board;

    public Board() {
        board = new Piece[8][8];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn("black", 1, i);
            board[6][i] = new Pawn("white", 6, i);
        }
        board[0][0] = new Rook("black", 0, 0);
        board[0][7] = new Rook("black", 0, 7);
        board[7][0] = new Rook("white", 7, 0);
        board[7][7] = new Rook("white", 7, 7);
        board[0][1] = new Knight("black", 0, 1);
        board[0][6] = new Knight("black", 0, 6);
        board[7][1] = new Knight("white", 7, 1);
        board[7][6] = new Knight("white", 7, 6);
        board[0][2] = new Bishop("black", 0, 2);
        board[0][5] = new Bishop("black", 0, 5);
        board[7][2] = new Bishop("white", 7, 2);
        board[7][5] = new Bishop("white", 7, 5);
        board[0][3] = new Queen("black", 0, 3);
        board[7][3] = new Queen("white", 7, 3);
        board[0][4] = new King("black", 0, 4);
        board[7][4] = new King("white", 7, 4);
    }

    public Piece getPiece(int x, int y) {
        return board[x][y];
    }

    public void setPiece(int x, int y, Piece piece) {
        board[x][y] = piece;
    }

    public void printBoard() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (board[row][col] == null) {
                    System.out.print(". ");
                } else {
                    System.out.print(board[row][col].getSymbol() + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean isKingInCheck(String color) {
        int kingX = -1, kingY = -1;
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Piece piece = board[row][col];
                if (piece != null && piece.getType().equals("King") && piece.getColor().equals(color)) {
                    kingX = row;
                    kingY = col;
                    break;
                }
            }
        }
        if (kingX == -1 || kingY == -1) {
            return true;
        }
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Piece piece = board[row][col];
                if (piece != null && !piece.getColor().equals(color)) {
                    if (piece.isValidMove(kingX, kingY, this)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public Board clone() {
        Board newBoard = new Board();
        newBoard.board = new Piece[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (this.board[i][j] != null) {
                    newBoard.board[i][j] = this.board[i][j].clone();
                }
            }
        }
        return newBoard;
    }
}
