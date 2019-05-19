/*
 *
 * Author: Derek Marks, Corey Collins, Jon Spencer, Alexandru Trefi
 * Date: 4/20/2018
 *
 * */
public class Editor {
    private CharacterInterface hero;

    public void setHero(CharacterInterface hero){
        this.hero = hero;
    }

    public Memento save(){
        return new Memento(hero);
    }

    public CharacterInterface restore(Memento m){
        hero = m.getCharacter();
        return hero;
    }
}