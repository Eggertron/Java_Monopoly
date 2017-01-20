import java.util.Scanner;

public class Game {
    private Dice dice;
    private Board board;
    private int numOfPlayers;
    private int STARTINGCASH = 1500;
    private Player[] players;
    
    
    public Game() {
        dice = new Dice();
        board = new Board();
    }
    
    public void start() {
        // show start screen
        inputNumOfPlayer();
        genPlayers();
        
        while (numOfPlayers > 0) { // while we have active players
            for (int i = 0; i < players.length; i++) {
                // roll dice and move space
                // or go to next player
                if (players[i].getPosition() != -1) { // player isn't bankrupt.
                    print(players[i].getName() + " turn. $" + players[i].getMoney());
                    processPlayer(players[i]);
                }
                getInput(); // just a pause command.
            }
        }
    }
    
    private void processPlayer(Player player) {
        boolean doubles;
        int doublesCount = 0;
        int newPosition;
        do {
            // roll dice.
            doubles = false;
            if (dice.rollDice1() == dice.rollDice2()) {
                doubles = true;
                doublesCount++;
            }
            print("Rolled " + dice.getDice1() + ", " + dice.getDice2());
            if (doublesCount == 3) {
                // goto jail.
                print("Rolled third double, goto Jail!");
                player.setPosition(10);
                doubles = false;
            }
            else {
                newPosition = player.getPosition() + dice.getDice1() + dice.getDice2();
                if (newPosition >= Board.MAX) {
                    print("Get $200 for passing Go!");
                    player.addMoney(200); // for landing/passing GO.
                    player.setPosition(newPosition - Board.MAX - 1);
                }
                else {
                    player.setPosition(newPosition);
                }
                print(player.getName() + " is on " + board.getProperty(player.getPosition()).name + "," + player.getPosition());
                // handle landed space.
                processBoard(player);
            }
        } while (doubles);
    }

    private void processBoard(Player player) {
        // unclaimed property
        Properties property = board.getProperty(player.getPosition());
        if (property.owner == null) { //testing
            print("pay rent $" + property.rent);
            player.addMoney(-property.rent);
        }
        if (player.getMoney() <= 0) {
            print("You are bankrupt!");
            numOfPlayers--;
            player.setPosition(-1);
        }
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
    
    private String getInput() {
        try {
            Scanner sc = new Scanner(System.in);
            return sc.nextLine();
        }
        catch (Exception e) {
            numOfPlayers = 0;
            e.printStackTrace();
        }
        return null;
    }
    
    private void genPlayers() {
        players = new Player[numOfPlayers];
        for (int i = 0; i < numOfPlayers; i++) {
            players[i] = new Player("Player" + (i + 1), STARTINGCASH);
        }
    }
    
    private void print(String msg) {
        System.out.println(msg);
    }
}
