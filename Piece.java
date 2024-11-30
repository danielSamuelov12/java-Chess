public interface Piece {
    boolean isValidMove(int newX, int newY, Board board);
    String getType();
    String getColor();
    char getSymbol();
}
