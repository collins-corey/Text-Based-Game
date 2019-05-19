/*
 *
 * Author: Derek Marks, Corey Collins, Jon Spencer, Alexandru Trefi
 * Date: 4/20/2018
 *
 * */
public class RedSyringe implements ItemInterface{

    private String name;
    private int strength;
    private String details;
    private String type;

    public RedSyringe(){
        this.name = "OVER 9000!";
        this. strength = 3;
        this.type = "Combat Item";
        this.details = "Item Name: " + name + "\nStrength: " + strength + "\nItem Type: " + type + "\nSpecial Combat Action: This item give you a power boost that will make your power for this turn " + strength + "x stronger.";
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