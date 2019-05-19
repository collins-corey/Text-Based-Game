/*
 *
 * Author: Derek Marks, Corey Collins, Jon Spencer, Alexandru Trefi
 * Date: 4/20/2018
 *
 * */
import java.util.ArrayList;

public class TheCaptain extends CharacterDecorator{
    private String line = new String(new char[50]).replace('\0', '-');
    private String name = "The Captain";
    private int strength = 7;
    private int charisma = 8;
    private int intellect = 6;
    private ArrayList<ItemInterface> inventory;
    private ArrayList<ItemInterface> combat;

    public TheCaptain(CharacterInterface character) {
        super(character);
        this.name = name;
        this.strength = strength;
        this.charisma = charisma;
        this.intellect = intellect;
        this.inventory = new ArrayList<>();
        this.combat = new ArrayList<>();
    }



    @Override
    public int getHp() {
        return super.getHp();
    }

    @Override
    public int getHp2(){
        return super.getHp2();
    }

    public void setHP(int num){
        super.setHp(num);
    }

    @Override
    public void setHp2(int hp2){
        super.setHp2(hp2);
    }

    @Override
    public int getOxygen(){
        return super.getOxygen();
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
    public int getCharisma(){
        return charisma;
    }

    @Override
    public int getIntellect(){
        return intellect;
    }

    @Override
    public void addStrength(int num) {
        this.strength = strength + num;
    }

    @Override
    public void loseStrength(int num) {
        this.strength = strength - num;
    }

    @Override
    public void getInventory() {
        for (int i = 0; i < inventory.size(); i++)
            System.out.println(inventory.get(i).getDetails());
    }

    @Override
    public ArrayList<ItemInterface> getCombat(){
        for(int i = 0; i < inventory.size(); i++){
            if(inventory.get(i).getType() == "Combat Item"){
                combat.add(inventory.get(i));
            }
        }
        return combat;
    }

    @Override
    public ArrayList<ItemInterface> getList(){
        return inventory;
    }

    @Override
    public String toString(){
        return line + "\nName: " + name +
                "\nClass Description: " + "\nThe captain, though not the strongest of the classes has an asset that puts him miles ahead of the rest.\n" +
                "His silver tongue gives him the ability to bend any conversation in his favor." + "\nAttributes: " +
                "\nStrength: " + strength + " - Since climbing the ranks has seen less action and slacked off on his workout regimen\n" +
                "leading to the dreaded dad bod which he claims is the new trend." +
                "\nCharisma: " + charisma + " - Master of manipulating any conversation even when climbing the ranks."
                + "\nIntellect: " + intellect + " - He's vastly smarter than the Space Marine but nowhere near the Doctors mental capacity.\n" + line;

    }
}