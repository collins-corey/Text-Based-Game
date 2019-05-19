/*
 *
 * Author: Derek Marks, Corey Collins, Jon Spencer, Alexandru Trefi
 * Date: 4/20/2018
 *
 * */
public class BlueSyringe implements ItemInterface{

    private String name;
    private int strength;
    private String details;
    private String type;

    public BlueSyringe(){
        this.name = "DR. FEEL GOOD";
        this. strength = 25;
        this.type = "Combat Item";
        this.details = "Item Name: " + name + "\nStrength: " + strength + "\nItem Type: " + type + "\nSpecial Combat Action: This item has the ability to heal yourself for " + strength + "hp during combat.";
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