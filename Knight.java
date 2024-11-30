public class Knight implements Piece {
    private String color;
    private int x, y;

    public Knight(String color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean isValidMove(int newX, int newY, Board board) {
        boolean validLMove = (Math.abs(newX - this.x) == 2 && Math.abs(newY - this.y) == 1) ||
                (Math.abs(newX - this.x) == 1 && Math.abs(newY - this.y) == 2);
        if (!validLMove) return false;

        Piece targetPiece = board.getPiece(newX, newY);
        return targetPiece == null || !targetPiece.getColor().equals(this.color);
    }

    @Override
    public String getType() {
        return "Knight";
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public char getSymbol() {
        return this.color.equals("white") ? 'N' : 'n';
    }
}
