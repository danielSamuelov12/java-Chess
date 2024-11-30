public class Main {
    public static void main(String[] args) {
        Player humanPlayer = new HumanPlayer(true);
        Player secondHumanPlayer = new HumanPlayer(false);
        ChessGame game = new ChessGame(humanPlayer , secondHumanPlayer);
        game.play();
    }
}
