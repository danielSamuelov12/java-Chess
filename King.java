public class King implements Piece {
    private String color;
    private int x, y;

    public King(String color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean isValidMove(int newX, int newY, Board board) {
        return Math.abs(newX - this.x) <= 1 && Math.abs(newY - this.y) <= 1;
    }

    @Override
    public String getType() {
        return "King";
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public char getSymbol() {
        return this.color.equals("white") ? 'K' : 'k';
    }
}
