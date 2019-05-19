/*
 *
 * Author: Derek Marks, Corey Collins, Jon Spencer, Alexandru Trefi
 * Date: 4/20/2018
 *
 * */
import java.util.ArrayList;

public class TheSoldier extends CharacterDecorator{
    private String line = new String(new char[50]).replace('\0', '-');
    private String name = "The Space Marine";
    private int strength = 9;
    private int charisma = 4;
    private int intellect = 2;
    private ArrayList<ItemInterface> inventory;
    private ArrayList<ItemInterface> combat;

    public TheSoldier(CharacterInterface character) {
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
    public String getName(){
        return name;
    }

    @Override
    public int getStrength() {
        return strength;
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
    public int getCharisma(){
        return charisma;
    }

    @Override
    public int getIntellect(){
        return intellect;
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
                "\nClass Description: " + "\nThe Space Marine is a strong and combat savvy class which relies on his knowledge and victories\n" +
                "from many wars to guide him through his decision making." + "\nAttributes: " +
                "\nStrength: " + strength + " - Very strong and combat savvy." +
                "\nCharisma: " + charisma + " - Rugged good looks with washboard abs hiding beneath his space suit."
                + "\nIntellect: " + intellect + " - Dumb as a space rock and has accidentally mistook crayons for candy.\n" + line;
    }

}