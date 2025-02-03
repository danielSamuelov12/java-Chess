public class Rook implements Piece {
    private String color;
    private int x, y;

    public Rook(String color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean isValidMove(int newX, int newY, Board board) {
        if (this.x != newX && this.y != newY) {
            return false;
        }

        if (this.x == newX) {
            int min = Math.min(this.y, newY);
            int max = Math.max(this.y, newY);
            for (int i = min + 1; i < max; i++) {
                if (board.getPiece(this.x, i) != null) {
                    return false;
                }
            }
        }
        else{
            int min = Math.min(this.x, newX);
            int max = Math.max(this.x, newX);
            for (int i = min + 1; i < max; i++) {
                if (board.getPiece(i, this.y) != null) {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public String getType() {
        return "Rook";
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public char getSymbol() {
        return this.color.equals("white") ? 'R' : 'r';
    }
    public Piece clone() {
        return new Rook(this.color, this.x, this.y);
    }
}

}
