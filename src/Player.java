import java.util.LinkedList;
import java.util.List;

public class Player {
    private String name;
    private int money;
    private int position;
    private boolean inJail;
    List<Properties> properties;
    
    public Player() {
        money = 1500;
        position = 0;
        inJail = false;
        properties = new LinkedList<Properties>();
    }
    
    public Player(String name) {
        this();
        this.name = name;
    }
    
    public Player(String name, int money) {
        this(name);
        this.money = money;
    }
    
    public int getPosition() {
        return position;
    }
    
    public void setPosition(int p) {
        position = p;
    }
    
    public void addMoney(int m) {
        money += m;
    }
    
    public int getMoney() {
        return money;
    }
    
    public String getName() {
        return name;
    }
}
