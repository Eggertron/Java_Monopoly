import java.util.Random;

public class Dice {

    private Random random;
    private int dice1;
    private int dice2;
    
    public Dice() {
        random = new Random();
        dice1 = 0;
        dice2 = 0;
    }
    
    public int rollDice() {
        return random.nextInt(5) + 1;
    }
    
    public int getDice1() {
        return dice1;
    }
    
    public int getDice2() {
        return dice2;
    }
    
    public int rollDice1() {
        dice1 = rollDice();
        return dice1;
    }
    
    public int rollDice2() {
        dice2 = rollDice();
        return dice2;
    }
}
