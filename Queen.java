public class Queen implements Piece {
    private String color;
    private int x, y;

    public Queen(String color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean isValidMove(int newX, int newY, Board board) {
        if (this.x == newX || this.y == newY) {
            return new Rook(this.color, this.x, this.y).isValidMove(newX, newY, board);
        }
        if (Math.abs(newX - this.x) == Math.abs(newY - this.y)) {
            return new Bishop(this.color, this.x, this.y).isValidMove(newX, newY, board);
        }
        return false;
    }

    @Override
    public String getType() {
        return "Queen";
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public char getSymbol() {
        return this.color.equals("white") ? 'Q' : 'q';
    }
    public Piece clone() {
        return new Queen(this.color, this.x, this.y);
    }
}

}
