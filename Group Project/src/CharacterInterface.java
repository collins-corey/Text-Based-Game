/*
 *
 * Author: Derek Marks, Corey Collins, Jon Spencer, Alexandru Trefi
 * Date: 4/20/2018
 *
 * */
import java.util.ArrayList;

public interface CharacterInterface {
    public int getOxygen();

    public void setOxygen(int oxygen);

    public int getHp();

    public int getHp2();

    public void setHp(int hp);

    public void setHp2(int hp2);

    public void getInventory();

    public ArrayList<ItemInterface> getList();

    public String getName();

    public void addStrength(int i);

    public void loseStrength(int i);

    public int getStrength();

    public int getCharisma();

    public int getIntellect();

    public ArrayList<ItemInterface> getCombat();
}