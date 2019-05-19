/*
 *
 * Author: Derek Marks, Corey Collins, Jon Spencer, Alexandru Trefi
 * Date: 4/20/2018
 *
 * */
import java.util.ArrayList;

public class CharacterDecorator implements CharacterInterface{
    private CharacterInterface character;

    public CharacterDecorator(CharacterInterface character){
        this.character = character;
    }

    @Override
    public int getOxygen() {
        return character.getOxygen();
    }

    @Override
    public void setOxygen(int oxygen) {
        character.setOxygen(oxygen);
    }

    @Override
    public int getHp() {
        return character.getHp();
    }

    @Override
    public int getHp2(){
        return character.getHp2();
    }

    @Override
    public void setHp(int hp) {
        character.setHp(hp);
    }

    @Override
    public void setHp2(int hp2){
        character.setHp2(hp2);
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