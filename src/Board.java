/*
 * The Monopoly Board information
 */
public class Board {
    static int MAX = 39;
    enum type { PROPERTY, CHEST, TAX, RAILROAD, CHANCE, JAIL, UTILITY, PARKING, GOTOJAIL, GO };
    private Properties[] properties;
    
    public Board() {
        initProperties();
    }
    
    private void initProperties() {
        properties = new Properties[MAX + 1];
        for (int i = 0; i < properties.length; i++) {
            properties[i] = new Properties();
            properties[i].owner = null;
            properties[i].isComplete = false;
            // fill for now
            properties[i].type = Board.type.PROPERTY;
            properties[i].name = "mediterranean avenue";
            properties[i].value = 60;
            properties[i].rent = 2;
            properties[i].one = 10;
            properties[i].two = 30;
            properties[i].three = 90;
            properties[i].four = 160;
            properties[i].hotel = 250;
            properties[i].mortgage = 30;
            properties[i].houseValue = 50;
            properties[i].hotelValue = 50;
        }
        // all properties added here.
        properties[0].type = Board.type.GO;
        properties[0].name = "GO";
        
        properties[1].type = Board.type.PROPERTY;
        properties[1].name = "Mediterranean Avenue";
        properties[1].value = 60;
        properties[1].rent = 2;
        properties[1].one = 10;
        properties[1].two = 30;
        properties[1].three = 90;
        properties[1].four = 160;
        properties[1].hotel = 250;
        properties[1].mortgage = 30;
        properties[1].houseValue = 50;
        properties[1].hotelValue = 50;
    }
    
    public Properties getProperty(int p) {
        return properties[p];
    }
}
