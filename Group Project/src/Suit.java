/*
 *
 * Author: Derek Marks, Corey Collins, Jon Spencer, Alexandru Trefi
 * Date: 4/20/2018
 *
 * */
public class Suit implements ItemInterface{
    private String name;
    private int strength;
    private String details;
    private String type;

    public Suit(){
        this.name = "Hi-Tech Space Suit";
        this. strength = 0;
        this.type = "Equipment Item";
        this.details = "Item Name: " + name + "\nStrength: " + strength + "\nItem Type: " + type;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getStrength() {
        return strength;
    }

    @Override
    public String getDetails() {
        return details;
    }

    @Override
    public String getType() {
        return type;
    }
}