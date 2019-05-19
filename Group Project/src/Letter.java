/*
 *
 * Author: Derek Marks, Corey Collins, Jon Spencer, Alexandru Trefi
 * Date: 4/20/2018
 *
 * */
public class Letter implements ItemInterface{
    private String name;
    private int strength;
    private String details;
    private String type;

    public Letter(){
        this.name = "Important Letter";
        this. strength = 0;
        this.type = "Story Item";
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