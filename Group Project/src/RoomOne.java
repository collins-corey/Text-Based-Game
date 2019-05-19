/*
 *
 * Author: Derek Marks, Corey Collins, Jon Spencer, Alexandru Trefi
 * Date: 4/20/2018
 *
 * */
import java.util.Scanner;

public class RoomOne {
    boolean alarm = true;
    private CharacterInterface hero;
    private ItemInterface letter;
    private ItemInterface suit;
    boolean wearSuit = false;
    boolean grabLetter = false;
    //public static Object r1;
    //Could add more to putting on the suit maybe
    public void roomOne(CharacterInterface hero, ItemInterface suit, ItemInterface letter){
        this.hero = hero;
        this.letter = letter;
        this.suit = suit;
        Scanner myScan = new Scanner(System.in);
        System.out.println("*\n*\n*\n*\n*\nDarkness slowly fades as you begin to wake up. Your neck is wet from laying in a pool of blood\n" +
                "that still trickles down from your head. Something or someone must have hit you right after the explosion.\n" +
                "Alarms are screeching on and off, the red emergency lights are flashing, and there is someone talking \n" +
                "over the radio, but at a slightly subdued volume.\n" +
                "\t\t\"I have disabled the Helios 7 and I'm transferring the files to you now. I'll\n" +
                "\t\tbe making my way to the escape pod soon, then meet up with everyone else.\"\n" +
                "Before you make out the individual, he is gone. Using the guidance terminal you pull yourself up. Still foggy, \n" +
                "you scan the area to see everything is mostly untouched and the computers are still functioning. You...\n\n" +
                "(1) Access the ships control terminal.\n" +
                "(2) Search the room.\n" +
                "(3) Go to your safe space and cry.\n");
        int choice = Integer.parseInt(myScan.nextLine());
        switch (choice) {
            //Access the ships control terminal
            case 1:
                controlTerminal();
                break;
            //Search the room
            case 2:
                searchRoom();
                break;
            //Go to your safe space and cry
            case 3:
                safeSpace();
                break;
            default:
                System.out.println("Looks like you don't know how to enter a pre-school number so I'm going to press 1 for you.");
                controlTerminal();
                break;
        }
    }
    public void controlTerminal(){
        Scanner myScan = new Scanner(System.in);
        System.out.println("\nSiri, Bixby, Google, whatever these computers are called now days, informs you the\n" +
                "Helios 7 is severely damaged with limited capabilities.\n" +
                "(1) Check the ships status.\n" +
                "(2) Turn off this annoying emergency alarm.\n" +
                "(3) Check Captain's log.\n");
        int choice = Integer.parseInt(myScan.nextLine());
        switch(choice) {
            //Check the ships status
            case 1:
                shipStatus();
                break;
            //Turn off the alarm
            case 2:
                alarm = alarmStatus();
                break;
            //Check Captain's Log
            case 3:
                captainsLog();
                break;
            default:
                System.out.println("Looks like you don't know how to enter a pre-school number so I'm going to press 1 for you.");
                shipStatus();
                break;
        }
    }
    public void searchRoom(){
        Scanner myScan = new Scanner(System.in);
        //If the suit and folder haven't been picked up
        if(wearSuit == false && grabLetter == false){
            System.out.println("\nYou see a space suit, a folded piece of paper on the ground, and the large door leading out of the control room.\n" +
                    "(1) Put on the suit.\n" +
                    "(2) Pick up the folded paper.\n" +
                    "(3) Access the ships control terminal.\n" +
                    "(4) Leave the room.\n");
            int choice = Integer.parseInt(myScan.nextLine());
            switch (choice) {
                //Put on the suit
                case 1:
                    putOnSuit();
                    break;
                //Pick up the folded paper
                case 2:
                    pickUpPaper();
                    break;
                //Access the ships control terminal
                case 3:
                    controlTerminal();
                    break;
                //Leave the room
                case 4:
                    return;
                default:
                    System.out.println("Looks like you don't know how to enter a pre-school number so I'm going to press 1 for you.");
                    putOnSuit();
                    break;
            }
        }
        //If the suit has already been put on
        else if(wearSuit == true && grabLetter == false){
            System.out.println("\nYou see a folded piece of paper on the ground and the large door leading out of the control room.\n" +
                    "(1) Pick up the folded paper.\n" +
                    "(2) Access the ships control terminal.\n" +
                    "(3) Leave the room.\n");
            int choice = Integer.parseInt(myScan.nextLine());
            switch (choice) {
                //Pick up the folded paper
                case 1:
                    pickUpPaper();
                    break;
                //Access the ships control terminal
                case 2:
                    controlTerminal();
                    break;
                //Leave the room
                case 3:
                    return;
                default:
                    System.out.println("Looks like you don't know how to enter a pre-school number so I'm going to press 1 for you.");
                    pickUpPaper();
                    break;
            }
        }
        //If the letter has already been picked up
        else if(wearSuit == false && grabLetter == true){
            System.out.println("\nYou see a space suit and the large door leading out of the control room.\n" +
                    "(1) Put on the suit.\n" +
                    "(2) Access the ships control terminal.\n" +
                    "(3) Leave the room.\n");
            int choice = Integer.parseInt(myScan.nextLine());
            switch (choice) {
                //Put on the suit
                case 1:
                    putOnSuit();
                    break;
                //Access the ships control terminal
                case 2:
                    controlTerminal();
                    break;
                //Leave the room
                case 3:
                    return;
                default:
                    System.out.println("Looks like you don't know how to enter a pre-school number so I'm going to press 1 for you.");
                    putOnSuit();
                    break;
            }
        }
        //If both have been picked up already
        else{
            System.out.println("\nThere is a large door leading out of the control room.\n" +
                    "(1) Access the ships control terminal.\n" +
                    "(2) Leave the room.\n");
            int choice = Integer.parseInt(myScan.nextLine());
            switch (choice) {
                //Access the ships control terminal
                case 1:
                    controlTerminal();
                    break;
                //Leave the room
                case 2:
                    return;
                default:
                    System.out.println("Looks like you don't know how to enter a pre-school number so I'm going to press 1 for you.");
                    controlTerminal();
                    break;
            }
        }



    }
    public void putOnSuit(){
        hero.getList().add(suit);
        wearSuit = true;
        Scanner myScan = new Scanner(System.in);
        //Have not picked up the letter yet
        if(grabLetter == false) {
            System.out.println("You squeeze your way into the suit and the HUD begins reciting its routine analysis of you.\n" +
                    "(1) Pick up the folded paper.\n" +
                    "(2) Access the ships control terminal.\n" +
                    "(3) Leave the room.\n");
            int choiceTwo = Integer.parseInt(myScan.nextLine());
            switch (choiceTwo) {
                //Pick up the folded paper
                case 1:
                    pickUpPaper();
                    break;
                //Access the ships control terminal
                case 2:
                    controlTerminal();
                    break;
                //Leave the room
                case 3:
                    break;
                default:
                    System.out.println("Looks like you don't know how to enter a pre-school number so I'm going to press 1 for you.");
                    pickUpPaper();
                    break;
            }
        }
        //Have picked up the letter already
        else{
            System.out.println("You squeeze your way into the suit and the HUD begins reciting its routine analysis of you.\n" +
                    "(1) Access the ships control terminal\n" +
                    "(2) Leave the room.\n");
            int choiceTwo = Integer.parseInt(myScan.nextLine());
            switch (choiceTwo) {
                //Access the ships control terminal
                case 1:
                    controlTerminal();
                    break;
                //Leave the room
                case 2:
                    break;
                default:
                    System.out.println("Looks like you don't know how to enter a pre-school number so I'm going to press 1 for you.");
                    controlTerminal();
                    break;
            }
        }
    }
    public void safeSpace(){
        Scanner myScan = new Scanner(System.in);
        System.out.println("\nSafe space?...Must be a millennial. You won't last long. Lets try again.\n" +
                "(1) Access the ships control terminal.\n" +
                "(2) Search the room.\n" +
                "(3) Leave the room.");
        int choice = Integer.parseInt(myScan.nextLine());
        switch(choice) {
            //Check the computer to see what has been damaged on the station
            case 1:
                controlTerminal();
                break;
            //Search the room
            case 2:
                searchRoom();
                break;
            //Leave the room
            case 3:
                return;
            default:
                System.out.println("Looks like you don't know how to enter a pre-school number so I'm going to press 1 for you.");
                controlTerminal();
                break;
        }
    }
    public void shipStatus(){
        Scanner myScan = new Scanner(System.in);
        System.out.println("404 page not found...Just kidding. The warp drive and engines have been\n" +
                "heavily damaged and there are multiple hull breaches throughout the station.\n" +
                "Life support systems are failing and oxygen is down to 85% and falling.\n" +
                "(1) Turn off this annoying emergency alarm.\n" +
                "(2) Check Captain's log.\n");
        int choice = Integer.parseInt(myScan.nextLine());
        switch(choice) {
            case 1:
                alarm = alarmStatus();
                break;
            case 2:
                captainsLog();
                break;
            default:
                System.out.println("Looks like you don't know how to enter a pre-school number so I'm going to press 1 for you.");
                alarm = alarmStatus();
                break;
        }
    }
    //Put some more stuff in the captains log.
    //Maybe something relevant to another part of the story
    public void captainsLog(){
        Scanner myScan = new Scanner(System.in);
        //Check if the player the captain
        if(hero.getName().equals("The Captain")){
            System.out.println("It's mostly stories about the captain, being told by the captain, in third person.\n" +
                    "3 hours later your still riveted...man you love hearing yourself talk.\n" +
                    "(1) Go back to the control menu.\n" +
                    "(2) Search the room.\n" +
                    "(3) Leave the room.");
            int choice = Integer.parseInt(myScan.nextLine());
            switch(choice) {
                case 1:
                    controlTerminal();
                    break;
                case 2:
                    searchRoom();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Looks like you don't know how to enter a pre-school number so I'm going to press 1 for you.");
                    controlTerminal();
                    break;
            }
        }
        else{
            System.out.println("It's mostly stories about the captain, being told by the captain, in third person.\n" +
                    "3 hours later....you finally wake up. You should have been using those to fall asleep every night.\n" +
                    "(1) Go back to the control menu.\n" +
                    "(2) Search the room.\n" +
                    "(3) Leave the room.");
            int choice = Integer.parseInt(myScan.nextLine());
            switch(choice) {
                case 1:
                    controlTerminal();
                    break;
                case 2:
                    searchRoom();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Looks like you don't know how to enter a pre-school number so I'm going to press 1 for you.");
                    controlTerminal();
                    break;
            }
        }
    }
    public void pickUpPaper(){
        Scanner myScan = new Scanner(System.in);
        hero.getList().add(letter);
        grabLetter = true;
        //Have not put the suit on yet
        if(wearSuit == false) {
            System.out.println("You pick up the paper and all that's written on it is the numbers \"88351\".\n" +
                    "You put it in your pocket.\n" +
                    "(1) Put on the suit.\n" +
                    "(2) Access the control terminal.\n" +
                    "(3) Leave the room.\n");
            int choice = Integer.parseInt(myScan.nextLine());
            switch (choice) {
                //Put on the suit
                case 1:
                    putOnSuit();
                    break;
                case 2:
                    controlTerminal();
                    break;
                //Leave the room
                case 3:
                    return;
                default:
                    System.out.println("Looks like you don't know how to enter a pre-school number so I'm going to press 1 for you.");
                    putOnSuit();
                    break;
            }
        }
        //Already put the suit on
        else{
            System.out.println("You pick up the paper and all that's written on it is the numbers \"88351\".\n" +
                    "You put it in your pocket.\n" +
                    "(1) Access the control terminal.\n" +
                    "(2) Leave the room.\n");
            int choice = Integer.parseInt(myScan.nextLine());
            switch (choice) {
                case 1:
                    controlTerminal();
                    break;
                //Leave the room
                case 2:
                    return;
                default:
                    System.out.println("Looks like you don't know how to enter a pre-school number so I'm going to press 1 for you.");
                    controlTerminal();
                    break;
            }
        }
    }
    //Alarm status isn't changing
    public boolean alarmStatus() {
        Scanner myScan = new Scanner(System.in);
        if(alarm == true) {
            alarm = false;
            System.out.println("Ahhh much better. Your headache already seems to be going away.\n" +
                    "(1) Access the ships control terminal\n" +
                    "(2) Search the room.\n");
            int choice = Integer.parseInt(myScan.nextLine());
            switch (choice) {
                //Access the terminal
                case 1:
                    controlTerminal();
                    return alarm;
                //Search the room
                case 2:
                    searchRoom();
                    return alarm;
                default:
                    System.out.println("Looks like you don't know how to enter a pre-school number so I'm going to press 1 for you.");
                    controlTerminal();
                    break;
            }
        }
        else {
            System.out.println("Really...you want to turn it back on?? Or are you just checking to see if we looked for bugs??\n" +
                    "(1) Access the ships control terminal\n" +
                    "(2) Search the room.\n");
            int choice = Integer.parseInt(myScan.nextLine());
            switch (choice) {
                //Access the terminal
                case 1:
                    controlTerminal();
                    return alarm;
                //Search the room
                case 2:
                    searchRoom();
                    return alarm;
                default:
                    System.out.println("Looks like you don't know how to enter a pre-school number so I'm going to press 1 for you.");
                    controlTerminal();
                    break;
            }
        }
        return alarm;
    }
}