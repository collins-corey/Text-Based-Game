/*
 *
 * Author: Derek Marks, Corey Collins, Jon Spencer, Alexandru Trefi
 * Date: 4/20/2018
 *
 * */
import java.util.ArrayList;

public class Character implements CharacterInterface{
    private int oxygen;
    private int hp;
    private int hp2;

    public Character(){
        this.oxygen = 100;
        this.hp = 100;
        this.hp2 = 100;
    }

    @Override
    public int getOxygen() {
        return oxygen;
    }


    @Override
    public void setOxygen(int oxygen) {
        this.oxygen = oxygen;
    }

    @Override
    public int getHp() {
        return hp;
    }

    @Override
    public int getHp2(){
        return hp2;
    }

    @Override
    public void setHp(int hp) {
        this.hp = hp;
    }

    @Override
    public void setHp2(int hp2){
        this.hp2 = hp2;
    }

    @Override
    public void getInventory(){
    }

    @Override
    public ArrayList<ItemInterface> getList() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void addStrength(int i) {

    }

    @Override
    public void loseStrength(int i) {

    }

    @Override
    public int getStrength() {
        return 0;
    }

    @Override
    public int getCharisma() {
        return 0;
    }

    @Override
    public int getIntellect() {
        return 0;
    }

    @Override
    public ArrayList<ItemInterface> getCombat() {
        return null;
    }
}