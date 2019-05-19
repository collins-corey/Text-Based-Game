/*
 *
 * Author: Derek Marks, Corey Collins, Jon Spencer, Alexandru Trefi
 * Date: 4/20/2018
 *
 * */
import java.util.ArrayList;
import java.util.Scanner;

public class RoomFive {
    CharacterInterface hero;
    CharacterInterface villain;
    ItemInterface letter;
    int villainCounter = 0;
    int choice;
    private Caretaker care;
    private Editor edit;
    private int roomHp;
    ArrayList<ItemInterface> heroItems;
    ArrayList<ItemInterface> villainItems;
    Scanner myScan = new Scanner(System.in);
    int combatLength;

    public void roomFive(CharacterInterface hero, CharacterInterface villain, Caretaker care, Editor edit) {
        this.villainItems = villain.getCombat();
        this.heroItems = hero.getCombat();
        combatLength = heroItems.size();
        this.hero = hero;
        this.villain = villain;
        for(int i = 0; i < hero.getList().size(); i++){
            if(hero.getList().get(i).getName() == "Important Letter"){
                this.letter = hero.getList().get(i);
            }
            else{
                this.letter = null;
            }
        }
        this.care = care;
        this.edit = edit;
        this.roomHp = hero.getHp();

        edit.setHero(hero);
        care.addMemento(edit.save());
        System.out.println("*\n*\n*\n*\n*\nYou emerge from the hatch and arrive in the observation deck where all the escape pods are\n" +
                "located. Unfortunately, all but one have been jettisoned. Against the far wall you see the final\n" +
                "escape pod with " + villain.getName() + " pacing in front of it looking very puzzled.\n");
        if(!hero.getList().contains(letter)){
            System.out.println("I thought I took care of you. No matter, I will finish the job here and now. Said " + villain.getName() + ".\n" +
                    "He grabs a pipe, already stained with your blood, that was on the ground next to him and aggressively runs at you.");
        }
        else{
            System.out.println("You realize the paper you picked up from the control room must have the code for the escape pod\n" +
                    "written on it. \"Looking for this?\" As you hold up the paper you found in the control room. You can see the anger\n" +
                    "boiling over inside him. " + villain.getName() + " stands there quietly. A palpable tension\n" +
                    "lingers in the air has he reaches for a pipe, already stained with your blood, that is laying\n" +
                    "on the ground next to him and aggressively runs at you.");
        }
        if(hero.getName().equals("The Captain")){
            System.out.println("Que pokemon fight music." +
                    "\nWhat do you do?" +
                    "\n(1) Fight " + villain.getName() + " for the last remaining escape pod." +
                    "\n(2) Use that silver tongue." +
                    "\n(3) Give up and accept death.");
            int choice = Integer.parseInt(myScan.nextLine());
            switch (choice) {
                //Fight
                case 1:
                    fight(hero, villain);
                    break;
                //Use that silver tongue
                case 2:
                    System.out.println("\nYou stop him and start weaving lies of how its ok that he destroyed your station and hit you over the head\n" +
                            "and all you want is a hug and we can forget about this whole thing. He believes you, lowers his guard and\n" +
                            "walks in for a hug. This give you an opportunity to get the first hit in. You...\n" +
                            "(1) Take the free attack.\n" +
                            "(2) Believe your own lies and go with him.\n" +
                            "(3) Do nothing.");
                    int choice2 = Integer.parseInt(myScan.nextLine());
                    switch (choice2) {
                        //Take the free attack
                        case 1:
                            System.out.println("\nYou use this time that he isn't paying attention to your advantage.");
                            villain.setHp2(villain.getHp2() - hero.getStrength());
                            System.out.println(villain.getName() + "'s HP: " + villain.getHp2() + "\nNow its go time.");
                            fight(hero, villain);
                            break;
                        //Believe your lies
                        case 2:
                            if(!hero.getList().contains(letter)) {
                                System.out.println("\nYou feel compassion for him and start to believe in his cause. You hand him the letter with the code on it\n" +
                                        "and you both jettison the escape pod. The screen fades to black and the credits begin to roll...\n" +
                                        "Thanks for playing.");
                                System.exit(0);
                            }
                            return;
                        //Do nothing
                        case 3:
                            System.out.println("\nYour such a pansy. He realizes what you've done and punches you in kidney.");
                            hero.setHp(hero.getHp() - villain.getStrength());
                            System.out.println("Hero's HP: " + hero.getHp());
                            fight(hero, villain);
                            break;
                        default:
                            System.out.println("\nLooks like you don't know how to enter a pre-school number so I'm going to press 1 for you.");
                            System.out.println("You use this time that he isn't paying attention to your advantage.");
                            villain.setHp2(villain.getHp2() - hero.getStrength());
                            System.out.println(villain.getName() + "'s HP: " + villain.getHp2() + "\nNow its go time.");
                            fight(hero, villain);
                            break;
                    }
                    break;
                //Give up
                case 3:
                    deathMenu();
                    break;
                default:
                    System.out.println("\nLooks like you don't know how to enter a pre-school number so I'm going to press 1 for you.");
                    roomFive(hero, villain, care, edit);
                    break;
            }
        }
        else{
            System.out.println("Que pokemon fight music." +
                    "\nWhat do you do?" +
                    "\n(1) Fight " + villain.getName() + " for the last remaining escape pod." +
                    "\n(2) Give up and accept death.");
            int choice = Integer.parseInt(myScan.nextLine());
            switch (choice) {
                //Fight
                case 1:
                    fight(hero, villain);
                    break;
                //Give up
                case 2:
                    deathMenu();
                    break;
                default:
                    roomFive(hero, villain, care, edit);
                    break;
            }
        }
    }

    public void fight(CharacterInterface hero, CharacterInterface villain) {
        while(hero.getHp() > 0 && villain.getHp2() > 0) {
            if (combatLength == 1 && heroItems != null) {
                System.out.println("\nIt is your turn what will you do:" +
                        "\n(1) Attack" +
                        "\n(2) Check combat items details" +
                        "\n(3) Use " + heroItems.get(0).getName());
                choice = Integer.parseInt(myScan.nextLine());
                switch (choice) {
                    case 1:
                        villain.setHp2(villain.getHp2() - hero.getStrength());
                        System.out.println("\nYou attacked " + villain.getName());
                        break;
                    case 2:
                        for (int i = 0; i < heroItems.size(); i++) {
                            System.out.println(" \n" + heroItems.get(i).getDetails() + "\n");
                        }
                        fight(hero, villain);
                        break;
                    case 3:
                        if(heroItems.get(0).getName().equals("OVER 9000!")){
                            villain.setHp2(villain.getHp2() - (hero.getStrength() * heroItems.get(0).getStrength()));
                            System.out.println("\nYou have used the syringe.");
                        }
                        else if(heroItems.get(0).getName().equals("FEELS BAD MAN")){
                            villain.setHp2(villain.getHp2() - heroItems.get(0).getStrength());
                            System.out.println("\nYou have used the syringe.");
                        }
                        else if(heroItems.get(0).getName().equals("DR. FEEL GOOD")){
                            hero.setHp(hero.getHp() + heroItems.get(0).getStrength());
                            System.out.println("\nYou healed for " + heroItems.get(0).getStrength() + "hp.");
                        }
                        else if(heroItems.get(0).getName().equals("Butcher's Cleaver")){
                            villain.setHp2(villain.getHp2() - (hero.getStrength() + heroItems.get(0).getStrength()));
                            System.out.println("\nYou have used the Butcher's Cleaver");
                        }
                        heroItems.remove(0);
                        combatLength = heroItems.size();
                        break;
                    default:
                        fight(hero, villain);
                        break;
                }
            }
            else if (combatLength == 2) {
                System.out.println("\nIt is your turn to attack what will you do:" +
                        "\n(1) Attack" +
                        "\n(2) Check combat items details" +
                        "\n(3) Use " + heroItems.get(0).getName() +
                        "\n(4) Use " + heroItems.get(1).getName());
                choice = Integer.parseInt(myScan.nextLine());
                switch (choice) {
                    case 1:
                        villain.setHp2(villain.getHp2() - hero.getStrength());
                        System.out.println("\nYou attacked " + villain.getName());
                        break;
                    case 2:
                        for (int i = 0; i < heroItems.size(); i++) {
                            System.out.println("\n" + heroItems.get(i).getDetails() + "\n");
                        }
                        fight(hero, villain);
                        break;
                    case 3:
                        villain.setHp2(villain.getHp2() - (hero.getStrength() + heroItems.get(0).getStrength()));
                        System.out.println("\nYou have used the Butcher's Cleaver");
                        heroItems.remove(0);
                        combatLength = heroItems.size();
                        break;
                    case 4:
                        if(heroItems.get(1).getName().equals("OVER 9000!")){
                            villain.setHp2(villain.getHp2() - (hero.getStrength() * heroItems.get(1).getStrength()));
                            System.out.println("\nYou have used the syringe.");
                        }
                        else if(heroItems.get(1).getName().equals("FEELS BAD MAN")){
                            villain.setHp2(villain.getHp2() - heroItems.get(1).getStrength());
                            System.out.println("\nYou have used the syringe.");
                        }
                        else if(heroItems.get(1).getName().equals("DR.FEEL GOOD")){
                            hero.setHp(hero.getHp() + heroItems.get(1).getStrength());
                            System.out.println("\nYou healed for " + heroItems.get(1).getStrength() + "hp.");
                        }

                        heroItems.remove(1);
                        combatLength = heroItems.size();
                        break;
                    default:
                        fight(hero, villain);
                        break;
                }
            }
            else {
                System.out.println("\nIt is your turn to attack what will you do:" +
                        "\n(1) Attack");
                choice = Integer.parseInt(myScan.nextLine());
                switch (choice) {
                    case 1:
                        villain.setHp2(villain.getHp2() - hero.getStrength());
                        System.out.println("\nYou attacked " + villain.getName());
                        break;
                    default:
                        fight(hero, villain);
                        break;
                }
            }
            if(villain.getName().equals("The Doctor")){
                if((villainCounter % 4) == 0){
                    System.out.println("Hero's HP: " + hero.getHp() + "\tVillains HP: " + villain.getHp2() + "\n");
                    hero.setHp(hero.getHp() - (villain.getStrength() + villain.getCombat().get(0).getStrength()));
                    System.out.println(villain.getName() + " has attacked you with the pipe.");
                    System.out.println("Hero's HP: " + hero.getHp() + "\tVillains HP: " + villain.getHp2() + "\n");
                    villainCounter++;
                }
                else{
                    System.out.println("Hero's HP: " + hero.getHp() + "\tVillains HP: " + villain.getHp2() + "\n");
                    hero.setHp(hero.getHp() - villain.getStrength());
                    System.out.println(villain.getName() + " has attacked you.");
                    System.out.println("Hero's HP: " + hero.getHp() + "\tVillains HP: " + villain.getHp2() + "\n");
                    villainCounter++;
                }
            }
            else if(villain.getName().equals("The Captain")){
                if((villainCounter % 5) == 0){
                    System.out.println("Hero's HP: " + hero.getHp() + "\tVillains HP: " + villain.getHp2() + "\n");
                    hero.setHp(hero.getHp() - (villain.getStrength() + villain.getCombat().get(0).getStrength()));
                    System.out.println(villain.getName() + " has attacked you with the pipe.");
                    System.out.println("Hero's HP: " + hero.getHp() + "\tVillains HP: " + villain.getHp2() + "\n");
                    villainCounter++;
                }
                else{
                    System.out.println("Hero's HP: " + hero.getHp() + "\tVillains HP: " + villain.getHp2() + "\n");
                    hero.setHp(hero.getHp() - villain.getStrength());
                    System.out.println(villain.getName() + " has attacked you.");
                    System.out.println("Hero's HP: " + hero.getHp() + "\tVillains HP: " + villain.getHp2() + "\n");
                    villainCounter++;
                }
            }
            if(villain.getName().equals("The Space Marine")){
                if((villainCounter % 6) == 0){
                    System.out.println("Hero's HP: " + hero.getHp() + "\tVillains HP: " + villain.getHp2() + "\n");
                    hero.setHp(hero.getHp() - (villain.getStrength() + villain.getCombat().get(0).getStrength()));
                    System.out.println(villain.getName() + " has attacked you with the pipe.");
                    System.out.println("Hero's HP: " + hero.getHp() + "\tVillains HP: " + villain.getHp2() + "\n");
                    villainCounter++;
                }
                else{
                    if(villain.getHp2() > 0) {
                        System.out.println("Hero's HP: " + hero.getHp() + "\tVillains HP: " + villain.getHp2() + "\n");
                        hero.setHp(hero.getHp() - villain.getStrength());
                        System.out.println(villain.getName() + " has attacked you.");
                        System.out.println("Hero's HP: " + hero.getHp() + "\tVillains HP: " + villain.getHp2() + "\n");
                        villainCounter++;
                    }
                }
            }

        }
        if(villain.getHp2() > 0 && hero.getHp() <=0){
            deathMenu();
        }
        else if(hero.getHp() > 0 && villain.getHp2() <= 0){
            System.out.println("\nThat was a good fight. You wipe your brow of sweat and blood and move over to the escape pod.");
            endGame();
        }
    }

    public void endGame(){
        System.out.println("\nAs you step up to the control panel that opens the hatch you...\n" +
                "(1) Enter the code.\n" +
                "(2) Try to hulk smash the control panel.\n" +
                "(3) Go down with the ship. You love Helios 7 too much.");
        int choice = Integer.parseInt(myScan.nextLine());
        switch (choice) {
            //Enter the code
            case 1:
                accessCode();
                break;
            //Smash the control panel
            case 2:
                hulkSmash();
                break;
            //Go down with the ship
            case 3:
                System.out.println("\nYou slink down against the railing on the edge of the observation deck and gaze out into space\n" +
                        "while the Helios 7 slowly creaks and moans. Life support eventually gives out and it begins to get\n" +
                        "colder and colder while oxygen emergency broadcasts echos throughout the lifeless station.\n" +
                        "45% oxygen remaining...30%...20%...It's quiet here by yourself.\nYou close your eyes as the everything goes dark.\n" +
                        "\n\n\n\n\nThanks for playing!");
                break;
            default:
                System.out.println("\nLooks like you don't know how to enter a pre-school number so I'm going to press 1 for you.");
                accessCode();
                break;
        }
    }
    public void accessCode(){
        System.out.println("\nPlease enter the 5 digit code.");
        int answer = Integer.parseInt(myScan.nextLine());
        if(answer != 88351){
            System.out.println("An error message pops up in red saying,\n" +
                    "\"Incorrect access code.\"\n" +
                    "\"Please try again.\"\n" +
                    "Do you want to try again?\n" +
                    "(1) Yes.\n" +
                    "(2) No.\n" +
                    "(3) Check inventory for code.");
            int choice = Integer.parseInt(myScan.nextLine());
            switch (choice){
                case 1:
                    accessCode();
                    break;
                case 2:
                    endGame();
                    break;
                case 3:
                    if(hero.getList().contains(letter)) {
                        System.out.println("\nYou pull out the piece of paper you found from the control room and see the numbers 88351.\n" +
                                "You try to input the code again.");
                        accessCode();
                    }
                    else{
                        System.out.println("\nYou did not find any codes.");
                        endGame();
                    }
                    break;
                default:
                    System.out.println("\nLooks like you don't know how to enter a pre-school number so I'm going to press 1 for you.");
                    accessCode();
                    break;
            }
        }
        else{
            System.out.println("\nAccess granted.\n" +
                    "Congratulations, you made it to the escape pod successfully. A wave of relief washes over as you sit down in the pilots seat and initiate the ejection sequence.\\n\" +\n" +
                    "The pod blasts into space but you notice the auto pilot is not set on the correct path home.\n" +
                    "Where could this be taking you...\n\n\n\n\nThanks for playing!");
        }
    }
    public void hulkSmash(){
        System.out.println("\nYou grab the pipe that " + villain.getName() + " had and give it all the gusto you can manage. With\n" +
                "a loud crack the panel shifts off the wall and glass shatters all over the floor. It hangs by only a few wires\n" +
                "snapping with electricity. The hatch opens about half way. You suck in your gut with a fierce determination\n" +
                "and shimmy through the tiny opening. Once inside you kick the door a couple times and it slams shut.\n" +
                "A wave of relief washes over as you sit down in the pilots seat and initiate the ejection sequence.\n" +
                "The pod blasts into space but you notice the auto pilot is not set on the correct path home.\n" +
                "Where could this be taking you...\n\n\n\n\nThanks for playing!");
    }

    public void deathMenu() {
        System.out.println("  _____\n" +
                " /     \\\n" +
                "| () () |\n" +
                " \\  ^  /\n" +
                "  |||||\n" +
                "  |||||\n" +
                "\nQue spooky death music\n" +
                "(1) Start the game over.\n" +
                "(2) Load from start of this room.\n" +
                "(3) Exit the game.");
        int choice = Integer.parseInt(myScan.nextLine());
        switch (choice) {
            //Start the game over
            case 1:
                System.out.println("I'm not sure what the best way is to exit a program and restart it yet.\n" +
                        "Please reopen the program when it shuts down.\n" +
                        "Thanks and don't die next time.");
                System.exit(0);
                break;
            //Load from start of the room
            case 2:
                System.out.println("Loading...");
                //Need to empty the inventory to how it was at the start of the room.
                //Since you could only pick up the cleaver in room two we can just take it out.
                hero = edit.restore(care.getMementos());
                hero.setHp(roomHp);
                villain.setHp2(100);
                roomFive(hero, villain, care, edit);
                break;
            //Exit the game
            case 3:
                System.out.println("Womp Womp Womp.");
                System.exit(0);
                return;
            default:
                System.out.println("Looks like you don't know how to enter a pre-school number so I'm going to press 1 for you.");
                System.out.println("I'm not sure what the best way is to exit a program and restart it yet.\n" +
                        "Please reopen the program when it shuts down.\n" +
                        "Thanks and don't die next time.");
                System.exit(0);
                break;
        }
    }
}