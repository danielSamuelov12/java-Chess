public class Pawn implements Piece {
    private String color;
    private int x, y;

    public Pawn(String color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean isValidMove(int newX, int newY, Board board) {
        Piece targetPiece = board.getPiece(newX, newY);


        if (targetPiece == null) {
            if (this.color.equals("white")) {
                if (x == 6) {
                    return (newX == x - 1 && newY == y) || (newX == x - 2 && newY == y);
                }
                return newX == x - 1 && newY == y;
            } else {
                if (x == 1) {
                    return (newX == x + 1 && newY == y) || (newX == x + 2 && newY == y);
                }
                return newX == x + 1 && newY == y;
            }
        }

        else if (!targetPiece.getColor().equals(this.color)) {
            return Math.abs(newY - y) == 1 && (this.color.equals("white") ? newX == x + 1 : newX == x - 1);
        }

        return false;
    }

    @Override
    public String getType() {
        return "Pawn";
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public char getSymbol() {
        return this.color.equals("white") ? 'P' : 'p';
    }
}
