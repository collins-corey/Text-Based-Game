/*
 *
 * Author: Derek Marks, Corey Collins, Jon Spencer, Alexandru Trefi
 * Date: 4/20/2018
 *
 * */
public class GreenSyringe implements ItemInterface{

    private String name;
    private int strength;
    private String details;
    private String type;

    public GreenSyringe(){
        this.name = "FEELS BAD MAN";
        this. strength = 20;
        this.type = "Combat Item";
        this.details = "Item Name: " + name + "\nStrength: " + strength + "\nItem Type: " + type + "\nSpecial Combat Action: This Syringe contains acid that will damage your opponent for " + strength + " damage.";
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
