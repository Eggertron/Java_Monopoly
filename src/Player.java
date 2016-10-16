import java.util.List;

public class Player {
    private String name;
    private int money;
    private int position;
    private List<Properties> properties;
    
    public Player() {
        money = 1500;
        position = 0;
        //properties = new List<Properties>();
    }
    
    public Player(String name) {
        this();
        this.name = name;
    }
    
    public Player(String name, int money) {
        this(name);
        this.money = money;
        position = 0;
    }
}