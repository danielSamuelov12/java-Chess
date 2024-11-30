public abstract class Player {
    protected String color;

    protected boolean isWhite;

    public Player(boolean isWhite) {
        if (isWhite == true){
            color = "White";
        }
        else{
            color = "Black";
        }
    }

    public String getColor() {
        return color;
    }

    public abstract String getMove(Board board);
}
