/*
 *
 * Author: Derek Marks, Corey Collins, Jon Spencer, Alexandru Trefi
 * Date: 4/20/2018
 *
 * */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);
        //Objects
        String line = new String(new char[50]).replace('\0', '-');
        int temp = 0;
        ItemInterface pipe = new Pipe();
        ItemInterface suit = new Suit();
        ItemInterface knife = new Knife();
        ItemInterface letter = new Letter();
        ItemInterface redSyringe = new RedSyringe();
        ItemInterface blueSyringe = new BlueSyringe();
        ItemInterface greenSyringe = new GreenSyringe();
        CharacterInterface villain;
        CharacterInterface hero;
        CharacterInterface character = new Character();
        CharacterInterface soldier = new TheSoldier(character);
        CharacterInterface captain = new TheCaptain(character);
        CharacterInterface doctor = new TheDoctor(character);
        Caretaker care = new Caretaker();
        Editor edit = new Editor();

        ArrayList<CharacterInterface> characters = new ArrayList<>();
        characters.add(soldier);
        characters.add(captain);
        characters.add(doctor);

        RoomOne r1 = new RoomOne();
        RoomTwo r2 = new RoomTwo();
        RoomThree r3 = new RoomThree();
        RoomFour r4 = new RoomFour();
        RoomFive r5 = new RoomFive();

        System.out.println("*\n*\n*\n*\n*\nWelcome to the Helios 7 Space Station where everything goes wrong and you will probably die.\n" +
                "The story begins as a team of space explorers are doing something cool and exciting in space and something bad happens. " +
                "Original right? \nWhile your character is hanging out in the control room doing control room stuff,\na large explosions occurs and something knocks you unconscious.\n" +
                "Don't worry, more bad stuff will happen I'm sure. Good Luck!" +
                "\n\nSo, we have three characters for you to choose between. Please enter your choice as 1, 2 or 3.");

        //Lists the character's descriptions and attributes
        listCharacters(characters);
        //Here we set the player and the enemy based off the user's choice
        System.out.println(line + "\nPlease select your character: \n" +
                "(1) The Space Marine \n" +
                "(2) The Captain\n" +
                "(3) The Doctor\n" + line);
        int choice = Integer.parseInt(myScan.nextLine());

        hero = characters.get(choice - 1);
        characters.remove(choice - 1);
        Collections.shuffle(characters);
        villain = characters.get(0);
        villain.getList().add(pipe);



        //Let the games begin.
        r1.roomOne(hero, suit, letter);
        r2.roomTwo(hero, suit, knife, care, edit);
        r3.roomThree(hero, suit, care, edit);
        r4.roomFour(hero, redSyringe, blueSyringe, greenSyringe, care, edit);
        r5.roomFive(hero, villain, care, edit);

    }

    public static void listCharacters(ArrayList characters){
        for(int i = 0; i < characters.size(); i++) System.out.println(characters.get(i).toString());
    }
}
