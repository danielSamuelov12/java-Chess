public class Bishop implements Piece {
    private String color;
    private int x, y;

    public Bishop(String color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean isValidMove(int newX, int newY, Board board) {
        if (Math.abs(newX - this.x) != Math.abs(newY - this.y)) {
            return false;
        }

        int xStep = (newX > this.x) ? 1 : -1;
        int yStep = (newY > this.y) ? 1 : -1;

        int currX = this.x + xStep;
        int currY = this.y + yStep;

        while (currX != newX && currY != newY) {
            if (board.getPiece(currX, currY) != null) {
                return false;
            }
            currX += xStep;
            currY += yStep;
        }

        Piece targetPiece = board.getPiece(newX, newY);
        return targetPiece == null || !targetPiece.getColor().equals(this.color);
    }

    @Override
    public String getType() {
        return "Bishop";
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public char getSymbol() {
        return this.color.equals("white") ? 'B' : 'b';
    }
    public Piece clone() {
        return new Bishop(this.color, this.x, this.y);
    }
}

}
