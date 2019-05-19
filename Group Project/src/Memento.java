/*
 *
 * Author: Derek Marks, Corey Collins, Jon Spencer, Alexandru Trefi
 * Date: 4/20/2018
 *
 * */
public class Memento {
    private CharacterInterface character;

    public Memento(CharacterInterface character){
        this.character = character;
    }

    public CharacterInterface getCharacter(){
        return character;
    }
}