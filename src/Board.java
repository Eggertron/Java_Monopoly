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
        
        properties[5].type = Board.type.PROPERTY;
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
        
        properties[2].type = Board.type.CHEST;
        properties[2].name = "Community Chest";
        
        properties[3].type = Board.type.PROPERTY;
        properties[3].name = "Baltic Avenue";
        properties[3].value = 60;
        properties[3].rent = 2;
        properties[3].one = 20;
        properties[3].two = 60;
        properties[3].three = 180;
        properties[3].four = 320;
        properties[3].hotel = 40;
        properties[3].mortgage = 30;
        properties[3].houseValue = 50;
        properties[3].hotelValue = 50;
        
        properties[4].type = Board.type.TAX;
        properties[4].name = "Income Tax";
        properties[4].value = 200;
        properties[4].rent = 200;
        
        properties[5].type = Board.type.RAILROAD;
        properties[5].name = "Reading Railroad";
        properties[5].value = 200;
        properties[5].rent = 25;
        properties[5].one = 25;
        properties[5].two = 50;
        properties[5].three = 100;
        properties[5].four = 200;
        properties[5].mortgage = 100;
        
        properties[6].type = Board.type.PROPERTY;
        properties[6].name = "Oriental Avenue";
        properties[6].value = 100;
        properties[6].rent = 6;
        properties[6].one = 30;
        properties[6].two = 90;
        properties[6].three = 270;
        properties[6].four = 400;
        properties[6].hotel = 550;
        properties[6].mortgage = 50;
        properties[6].houseValue = 50;
        properties[6].hotelValue = 50;
    }
    
    public Properties getProperty(int p) {
        return properties[p];
    }
}
