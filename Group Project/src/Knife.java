/*
 *
 * Author: Derek Marks, Corey Collins, Jon Spencer, Alexandru Trefi
 * Date: 4/20/2018
 *
 * */
public class Knife implements ItemInterface {

    private String name;
    private int strength;
    private String details;
    private String type;

    public Knife(){
        this.name = "Butcher's Cleaver";
        this. strength = 9;
        this.type = "Combat Item";
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