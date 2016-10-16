import java.util.Scanner;

public class Game {
    private Dice dice;
    private int numOfPlayers;
    private Player[] players;
    
    public Game() {
        dice = new Dice();
    }
    
    public void start() {
        // show start screen
        inputNumOfPlayer();
        genPlayers();
    }
    
    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
    
    private void inputNumOfPlayer() {
        numOfPlayers = 0;
        do {
            System.out.print("Enter number of players: ");
            try {
                Scanner sc = new Scanner(System.in);
                numOfPlayers = Integer.parseInt(sc.nextLine());
            }
            catch (Exception e) {
                numOfPlayers = 0;
                e.printStackTrace();
            }
        } while (numOfPlayers < 1);
    }
    
    private void genPlayers() {
        players = new Player[numOfPlayers];
        for (int i = 0; i < numOfPlayers; i++) {
            players[i] = new Player("Player" + (i + 1));
        }
    }
}
