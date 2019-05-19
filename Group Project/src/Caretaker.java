/*
 *
 * Author: Derek Marks, Corey Collins, Jon Spencer, Alexandru Trefi
 * Date: 4/20/2018
 *
 * */
import java.util.ArrayList;

public class Caretaker {
    private ArrayList<Memento> saves = new ArrayList<>();

    public void addMemento(Memento m){
        saves.add(m);
    }

    public Memento getMementos(){
        return saves.get(saves.size() - 1);
    }
}