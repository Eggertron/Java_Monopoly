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
                    print(players[i].getName() + " turn. $" + players[i]
                            .getMoney());
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
                newPosition = player.getPosition() + dice.getDice1() + dice
                        .getDice2();
                if (newPosition > Board.MAX) {
                    print("Get $200 for passing Go!");
                    player.addMoney(200); // for landing/passing GO.
                    player.setPosition(newPosition - Board.MAX - 1);
                }
                else {
                    player.setPosition(newPosition);
                }
                print(player.getName() + " is on " + board.getProperty(player
                        .getPosition()).name + "," + player.getPosition());
                // handle landed space.
                processBoard(player);
            }
        } while (doubles);
    }

    private void processBoard(Player player) {
        Properties property = board.getProperty(player.getPosition());
        switch (property.type) {
        case PROPERTY:
            processProperty(player, property);
            break;
        case CHEST:
            processChest(player, property);
            break;
        case TAX:
            processTax(player, property);
        case RAILROAD:
            processRailroad(player, property);
        default:
            break;
        }
        if (player.getMoney() <= 0) {
            print("You are bankrupt!");
            numOfPlayers--;
            player.setPosition(-1);
        }
    }

    private void processRailroad(Player player, Properties property) {
        if (property.owner == null) {
            processPurchase(player, property);
        }
        else {
            print(player.getName() + " pays railroad rent to " + property.owner.getName());
            player.addMoney(-property.rent); // change this value to reflect multiple
            property.owner.addMoney(property.rent);
        }
    }

    private void processTax(Player player, Properties property) {
        // give option for 10% or $200
        print(player.getName() + " is taxed " + property.value);
        player.addMoney(-property.value);
    }

    private void processChest(Player player, Properties property) {
        print(player.getName() + " landed on Community Chest");
    }

    private void processPurchase(Player player, Properties property) {
        String choice;
        do {
            print("This property is available, do you want to purchase (y/n)? ");
            choice = getInput();
        } while (!choice.toLowerCase().equals("y") && !choice.toLowerCase()
                .equals("n"));
        if (choice.toLowerCase().equals("y")) {
            property.owner = player;
            player.properties.add(property);
            player.addMoney(-property.value);
            print(player.getName() + " purchased " + property.name
                    + " for $" + property.value);
        }
    }
    
    private void processProperty(Player player, Properties property) {
        if (property.owner == null) {
            processPurchase(player, property);
        }
        else {
            if (property.owner == player) {
                print("Landed on your own property.");
            }
            else {
                // need to pay rent to owner
                player.addMoney(-property.rent);
                property.owner.addMoney(property.rent);
                print("pay rent $" + property.rent + " to " + property.owner
                        .getName());
            }
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
