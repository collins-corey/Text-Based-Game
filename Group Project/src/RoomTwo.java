/*
 *
 * Author: Derek Marks, Corey Collins, Jon Spencer, Alexandru Trefi
 * Date: 4/20/2018
 *
 * */
import java.util.Scanner;

public class RoomTwo {
    private CharacterInterface hero;
    private ItemInterface suit;
    private ItemInterface knife;
    private Caretaker care;
    private Editor edit;
    private int roomHp;
    boolean fire = false;
    boolean gas = false;
    boolean food = false;
    boolean cleaver = false;
    Scanner myScan = new Scanner(System.in);

    public void roomTwo(CharacterInterface hero, ItemInterface suit, ItemInterface knife, Caretaker care, Editor edit){
        this.hero = hero;
        this.suit = suit;
        this.knife = knife;
        this.care = care;
        this.edit = edit;
        this.roomHp = hero.getHp();

        edit.setHero(hero);
        care.addMemento(edit.save());
        System.out.println("*\n*\n*\n*\n*\nYou walk through a short hallway and come to the galley. Whats a galley you ask? It's the kitchen...duh!\n" +
                "The room shows slight evidence the explosion effected the galley. There are cracks along some of the walls, \n" +
                "pots, pans and utensils scattered all over the floor, and a few small fires burning.");
        //Check to see if hero has the suit on
        if(!hero.getList().contains(suit)){
            hero.setHp(hero.getHp() -10);
            System.out.println("After a few moments you begin feeling nauseous and throwing up.\n" +
                    "**Your health starts slowly decreasing: -10 HP**\n" +
                    "You notice the potent gas smell. The gas line must have been knocked loose from the explosion. ");
            System.out.println("Health Remaining: " + hero.getHp());
        }
        else{
            System.out.println("Almost as soon as you step into the room your suit speaks up,\n" +
                    "\t\t\"There is a dangerous gas in the air. It must have been a result \n" +
                    "\t\tof the explosion knocking the gas line loose. Don't worry, this suit will \n" +
                    "\t\tprotect you from the gas...unless it explodes of course.\"");
        }
        //check what hero is being played
        if(hero.getName().equals("The Space Marine")){
            soldierChoice(hero, suit, knife);
        }
        else if(hero.getName().equals("The Captain")){
            captainChoice(hero, suit, knife);
        }
        else{
            doctorChoice(hero, suit, knife);
        }
    }
    public void searchRoom(CharacterInterface hero,ItemInterface suit, ItemInterface knife){
        System.out.println("You examine the area to find a some knives, some misc ingredients, and some frozen, dehydrated food. Nasty.\n" +
                "(1) Pick up a knife.\n" +
                "(2) Eat some frozen, dehydrated food.\n" +
                "(3) Go to the next room.");
        int choice = Integer.parseInt(myScan.nextLine());
        switch(choice) {
            //Find a butcher's cleaver
            case 1:
                pickUpKnife(hero, suit, knife);
                break;
            //Eat food
            case 2:
                eatFood(hero, suit, knife);
                break;
            //Go to the next room
            case 3:
                return;
            default:
                System.out.println("Looks like you don't know how to enter a pre-school number so I'm going to press 1 for you.");
                pickUpKnife(hero, suit, knife);
                break;
        }
    }
    public void eatFood(CharacterInterface hero,ItemInterface suit, ItemInterface knife){
        food = true;
        //Already picked up the cleaver
        if(cleaver == true) {
            hero.setHp(hero.getHp() - 10);
            System.out.println("I can't believe you just ate some frozen, dehydrated food! That stuff can kill you. \n" +
                    "Since its not ready to eat yet it didn't kill you but it did hurt. \n" +
                    "**-10 HP**\n" + " Remaining Health: " + hero.getHp() + "\n" +
                    "(1) Go to the next room.");
            int choice = Integer.parseInt(myScan.nextLine());
            switch (choice) {
                //Go to the next room
                case 1:
                    System.out.println("You stagger to the next room while your stomach makes that uncomfortable gurgle.");
                    return;
                default:
                    System.out.println("Looks like you don't know how to enter a pre-school number so I'm going to press 1 for you.\n" +
                            "Your going to the next room. Bye Jena.");
                    break;
            }
        }
        //Haven't picked up the cleaver yet
        else{
            hero.setHp(hero.getHp() - 10);
            System.out.println("I can't believe you just ate some frozen, dehydrated food! That stuff can kill you. \n" +
                    "Since its not ready to eat yet it didn't kill you but it did hurt. \n" +
                    "**-10 HP**\n" + " Remaining Health: " + hero.getHp() + "\n" +
                    "(1) Pick up a knife.\n" +
                    "(2) Go to the next room.");
            int choice = Integer.parseInt(myScan.nextLine());
            switch (choice) {
                //Pick up a knife
                case 1:
                    pickUpKnife(hero, suit, knife);
                    break;

                //Go to the next room
                case 2:
                    return;
                default:
                    System.out.println("Looks like you don't know how to enter a pre-school number so I'm going to press 1 for you.");
                    pickUpKnife(hero, suit, knife);
                    break;
            }
        }
    }
    public void pickUpKnife(CharacterInterface hero,ItemInterface suit, ItemInterface knife){
        //Already ate the bad food
        if(food == true) {
            System.out.println("Among the slew of knives you pick up a butcher's cleaver...sweet.\n");
            System.out.println(knife.getDetails());
            System.out.println("\nWould you like to equip it?\n" +
                    "(1) Heck yeah! I've always wanted my own cleaver.\n" +
                    "(2) Psh, I don't need a weapon.\n");
            int choiceTwo = Integer.parseInt(myScan.nextLine());
            switch (choiceTwo) {
                //Yes
                case 1:
                    cleaver = true;
                    hero.getList().add(knife);
                    System.out.println("Armed and ready to roll you move onto the next room.");
                    return;
                //No
                case 2:
                    System.out.println("Your so brave sticking with those mitts of yours. Good luck in the next room.");
                    return;
                default:
                    System.out.println("Looks like you don't know how to enter a pre-school number so I'm going to press 1 for you.\n" +
                            "Your gonna take the cleaver and your gonna like it.");
                    cleaver = true;
                    hero.getList().add(knife);
                    return;
            }
        }
        //Did not eat the bad food yet
        else{
            System.out.println("Among the slew of knives you pick up a butcher's cleaver...sweet.\n");
            System.out.println(knife.getDetails());
            System.out.println("\nWould you like to equip it?\n" +
                    "(1) Heck yeah! I've always wanted my own cleaver.\n" +
                    "(2) Psh, I don't need a weapon.\n");
            int choiceTwo = Integer.parseInt(myScan.nextLine());
            switch (choiceTwo) {
                //Yes
                case 1:
                    cleaver = true;
                    hero.getList().add(knife);
                    System.out.println("Armed and ready to roll you decide to.\n" +
                            "(1) Rethink that frozen, dehydrated food. You need to eat right?\n" +
                            "(2) Go to the next room.");
                    int choiceThree = Integer.parseInt(myScan.nextLine());
                    switch (choiceThree) {
                        //Eat the food
                        case 1:
                            eatFood(hero, suit, knife);
                            break;
                        //Go to the next room
                        case 2:
                            return;
                        default:
                            System.out.println("Looks like you don't know how to enter a pre-school number so I'm going to press 1 for you.\n" +
                                    "Your gonna eat that frozen, dehydrated food and your gonna like it.");
                            eatFood(hero, suit, knife);
                            break;
                    }
                    break;
                //No
                case 2:
                    System.out.println("Your so brave sticking with those mitts of yours. With your beaming confidence you...\n" +
                            "(1) Rethink that frozen, dehydrated food. You need to eat right?\n" +
                            "(2) Go to the next room.");
                    int choiceFour = Integer.parseInt(myScan.nextLine());
                    switch (choiceFour) {
                        //Eat the food
                        case 1:
                            eatFood(hero, suit, knife);
                            break;
                        //Go to the next room
                        case 2:
                            return;
                        default:
                            System.out.println("Looks like you don't know how to enter a pre-school number so I'm going to press 1 for you.\n" +
                                    "Your gonna eat that frozen, dehydrated food and your gonna like it.");
                            eatFood(hero, suit, knife);
                            break;
                    }
                    break;
                default:
                    System.out.println("Looks like you don't know how to enter a pre-school number so I'm going to press 1 for you.\n" +
                            "Your gonna take the cleaver and your gonna like it.");
                    hero.getList().add(knife);
                    return;
            }
        }
    }
    public void putOutFire(CharacterInterface hero,ItemInterface suit, ItemInterface knife){
        //If the gas has been turned off already
        if(gas == true) {
            System.out.println("\nYou notice there is a large pot in the corner of the room by the door. You're able to make make it to the sink, \n" +
                    "fill it with water and pour it over the flames. Well done champ! Fire problem solved. Now you:\n" +
                    "(1) Search the room.\n" +
                    "(2) Go to the next room.\n");
            int choice = Integer.parseInt(myScan.nextLine());
            switch (choice) {
                //Search the room
                case 1:
                    searchRoom(hero, suit, knife);
                    break;
                //Go to the next room
                case 2:
                    return;
                default:
                    System.out.println("Looks like you don't know how to enter a pre-school number so I'm going to press 1 for you.");
                    searchRoom(hero, suit, knife);
                    break;
            }
        }
        //If the gas hasn't been turned off
        else{
            System.out.println("\nYou notice there is a large pot in the corner of the room by the door. You're able to make make it to the sink, \n" +
                    "fill it with water and pour it over the flames. Well done champ! Fire problem solved. Lets just hope the gas won't \n" +
                    "cause any problems later. Now you:\n" +
                    "(1) Search the room.\n" +
                    "(2) Try to stop the gas leak.\n" +
                    "(3) Go to the next room.\n");
            int choice = Integer.parseInt(myScan.nextLine());
            switch (choice) {
                //Search the room
                case 1:
                    searchRoom(hero, suit, knife);
                    break;
                //Stop the gas leak
                case 2:
                    //check what hero is being played
                    //Soldier
                    if (hero.getName().equals("The Space Marine")) {
                        soldierStopGas(hero, suit, knife);
                    }
                    //Captain
                    else if (hero.getName().equals("The Captain")) {
                        captainStopGas();
                    }
                    //Doctor
                    else {
                        doctorStopGas(hero, suit, knife);
                    }
                    break;
                //Go to the next room
                case 3:
                    return;
                default:
                    System.out.println("Looks like you don't know how to enter a pre-school number so I'm going to press 1 for you.");
                    searchRoom(hero, suit, knife);
                    break;
            }
        }
    }
    public void soldierIgnoreGas(CharacterInterface hero, ItemInterface suit, ItemInterface knife){
        System.out.println("Psh, you have gas all the time and it smells worse than this. You continue to push on.\n" +
                "(1) Search the room.\n" +
                "(2) Go to the next room.\n");
        int choice = Integer.parseInt(myScan.nextLine());
        switch(choice) {
            //False sense of security. You dead
            case 1:
                System.out.println("While looking around the room...SKADOOSH! Ignoring the gas wasn't the smartest decision. \n" +
                        "The gas reached the small flames and exploded. You have died.");
                deathMenu(hero, suit, knife);
                break;
            //False sense of security. You dead
            case 2:
                System.out.println("Walking towards the door and SKADOOSH! Ignoring the gas wasn't the smartest decision. \n" +
                        "The gas reached the small flames and exploded. You have died.");
                deathMenu(hero, suit, knife);
                break;
            default:
                System.out.println("Looks like you don't know how to enter a pre-school number so I'm going to press 1 for you.");
                System.out.println("While looking around the room...SKADOOSH! Ignoring the gas wasn't the smartest decision. \n" +
                        "The gas reached the small flames and exploded. You have died.");
                deathMenu(hero, suit, knife);
                break;
        }
    }
    public void soldierStopGas(CharacterInterface hero,ItemInterface suit, ItemInterface knife){
        //Fire has been put out already
        if(fire == true) {
            System.out.println("\nExamining the room you see the exposed pipe where the gas is coming from. Standing there starring at it \n" +
                    "you don't see the valve that would close the pipe. Instead you grit your teeth, grab the metal pipe, let out \n" +
                    "a caveman-like grunt bending the pipe right in half. That'll do pig.\n" +
                    "With the situation under control you decided to:\n" +
                    "(1) Search the room.\n" +
                    "(2) Go to the next room.\n");
            int choice = Integer.parseInt(myScan.nextLine());
            switch (choice) {
                //Search the room
                case 1:
                    searchRoom(hero, suit, knife);
                    break;
                //Go to the next room
                case 2:
                    return;
                default:
                    System.out.println("Looks like you don't know how to enter a pre-school number so I'm going to press 1 for you.");
                    searchRoom(hero, suit, knife);
                    break;
            }
        }
        //Fire hasn't been put out yet
        else{
            System.out.println("\nExamining the room you see the exposed pipe where the gas is coming from. Standing there starring at it \n" +
                    "you don't see the valve that would close the pipe. Instead you grit your teeth, grab the metal pipe, let out \n" +
                    "a caveman-like grunt bending the pipe right in half. That'll do pig.\n" +
                    "With the situation under control you decided to:\n" +
                    "(1) Search the room.\n" +
                    "(2) Try to put out the small fires.\n" +
                    "(3) Go to the next room.\n");
            int choice = Integer.parseInt(myScan.nextLine());
            switch (choice) {
                //Search the room
                case 1:
                    searchRoom(hero, suit, knife);
                    break;
                //Try to put out the small fires
                case 2:
                    putOutFire(hero, suit, knife);
                    break;
                //Go to the next room
                case 3:
                    return;
                default:
                    System.out.println("Looks like you don't know how to enter a pre-school number so I'm going to press 1 for you.");
                    searchRoom(hero, suit, knife);
                    break;
            }
        }
    }
    public void captainIgnoreGas(){
        System.out.println("This smell is almost as bad as the soldier's gas. You stop to reconsider.\n" +
                "(1) You continue to push on.\n" +
                "(2) Try to put out the small fires.\n" +
                "(3) Try to stop the gas leak.\n");
        int choice = Integer.parseInt(myScan.nextLine());
        switch(choice) {
            //Push on
            case 1:
                System.out.println("Captain knows best right? Keep going.\n" +
                        "(1) Search the room.\n" +
                        "(2) Go to the next room.\n");
                int choiceTwo = Integer.parseInt(myScan.nextLine());
                switch(choiceTwo) {
                    //False sense of security. You dead
                    case 1:
                        System.out.println("While looking around the room...SKADOOSH! Ignoring the gas wasn't the smartest decision. \n" +
                                "The gas reached the small flames and exploded. You have died.");
                        deathMenu(hero, suit, knife);
                        break;
                    //False sense of security. You dead
                    case 2:
                        System.out.println("Walking towards the door and SKADOOSH! Ignoring the gas wasn't the smartest decision. \n" +
                                "The gas reached the small flames and exploded. You have died.");
                        deathMenu(hero, suit, knife);
                        break;
                    default:
                        System.out.println("Looks like you don't know how to enter a pre-school number so I'm going to press 1 for you.");
                        System.out.println("While looking around the room...SKADOOSH! Ignoring the gas wasn't the smartest decision. \n" +
                                "The gas reached the small flames and exploded. You have died.");
                        deathMenu(hero, suit, knife);
                        break;
                }
                break;
            //Put out the small fires
            case 2:
                fire = true;
                //Check to see if hero has the suit on
                if(!hero.getList().contains(suit)){
                    hero.setHp(hero.getHp() -10);
                    System.out.println("\nStill sucking in that sweet sweet gas you health trickles down a little more. \n**-10 hp**\n" +
                            "It's of no concern to you, the fearless leader. Its time to put out some fires.\n" +
                            "Health Remaining: " + hero.getHp());
                }
                else{
                    System.out.println("\nAs you look for a way to put out the fires your suit informs you the room is filling with \n" +
                            "dangerously high levels of gas.");
                }
                putOutFire(hero, suit, knife);
                break;
            //Stop the gas leak
            case 3:
                gas = true;
                captainStopGas();
                break;
            default:
                System.out.println("Looks like you don't know how to enter a pre-school number so I'm going to press 1 for you.");
                captainIgnoreGas();
                break;
        }
    }
    public void captainStopGas(){
        //Fire has been put out already
        if(fire == true) {
            System.out.println("\nExamining the room you see the exposed pipe where the gas is coming from. Standing there starring at it \n" +
                    "you don't see the valve that would close the pipe because your distracted about how your hair looks after \n" +
                    "getting hit in the head earlier. You look at your reflection in the fridge and whip out your emergency can of hair gel. \n" +
                    "This stuff thick and smells like peppermint. Hey, you realize you can use the hair gel to clog the gas leak. \n" +
                    "Reluctantly, you load up the pipe with that peppermint goodness and stop the gas leak. Moving on you,\n" +
                    "(1) Search the room.\n" +
                    "(2) Go to the next room.\n");
            int choiceThree = Integer.parseInt(myScan.nextLine());
            switch (choiceThree) {
                //Search the room
                case 1:
                    searchRoom(hero, suit, knife);
                    break;
                //Go to the next room
                case 2:
                    return;
                default:
                    System.out.println("Looks like you don't know how to enter a pre-school number so I'm going to press 1 for you.");
                    searchRoom(hero, suit, knife);
                    break;
            }
        }
        //Fire has not been put out yet
        else{
            System.out.println("\nExamining the room you see the exposed pipe where the gas is coming from. Standing there starring at it \n" +
                    "you don't see the valve that would close the pipe because your distracted about how your hair looks after \n" +
                    "getting hit in the head earlier. You look at your reflection in the fridge and whip out your emergency can of hair gel. \n" +
                    "This stuff thick and smells like peppermint. Hey, you realize you can use the hair gel to clog the gas leak. \n" +
                    "Reluctantly, you load up the pipe with that peppermint goodness and stop the gas leak. Moving on you,\n" +
                    "(1) Search the room.\n" +
                    "(2) Try to put out the small fires.\n" +
                    "(3) Go to the next room.\n");
            int choiceThree = Integer.parseInt(myScan.nextLine());
            switch (choiceThree) {
                //Search the room
                case 1:
                    searchRoom(hero, suit, knife);
                    break;
                //Try to put out the small fires
                case 2:
                    putOutFire(hero, suit, knife);
                    break;
                //Go to the next room
                case 3:
                    return;
                default:
                    System.out.println("Looks like you don't know how to enter a pre-school number so I'm going to press 1 for you.");
                    searchRoom(hero, suit, knife);
                    break;
            }
        }
    }
    public void doctorIgnoreGas(CharacterInterface hero,ItemInterface suit, ItemInterface knife){
        System.out.println("\nEven if you think it's a good idea to ignore the gas the doctor is smart enough not to. \n" +
                "Using your high level of intelligence you opt to pick something else.\n" +
                "(1) Try to put out the small fires.\n" +
                "(2) Try to stop the gas leak.\n");
        int choice = Integer.parseInt(myScan.nextLine());
        switch(choice) {
            //Put out the small fires.
            case 1:
                putOutFire(hero, suit, knife);
                break;
            //Stop the gas leak
            case 2:
                doctorStopGas(hero, suit, knife);
                break;
            default:
                System.out.println("Looks like you don't know how to enter a pre-school number so I'm going to press 1 for you.");
                putOutFire(hero, suit, knife);
                break;
        }
    }
    public void doctorStopGas(CharacterInterface hero,ItemInterface suit, ItemInterface knife){
        //The fire has already been put out
        if(fire == true) {
            System.out.println("\nExamining the room you see the exposed pipe where the gas is coming from. Standing there starring at it \n" +
                    "you see the valve that would close the pipe....so you close the valve. That seemed easy.\n" +
                    "(1) Search the room.\n" +
                    "(2) Go to the next room.\n");
            int choiceThree = Integer.parseInt(myScan.nextLine());
            switch (choiceThree) {
                //Search the room
                case 1:
                    searchRoom(hero, suit, knife);
                    break;
                //Go to the next room
                case 3:
                    return;
                default:
                    System.out.println("Looks like you don't know how to enter a pre-school number so I'm going to press 1 for you.");
                    searchRoom(hero, suit, knife);
                    break;
            }
        }
        //The fire hasn't been put out yet
        else{
            System.out.println("\nExamining the room you see the exposed pipe where the gas is coming from. Standing there starring at it \n" +
                    "you see the valve that would close the pipe....so you close the valve. That seemed easy.\n" +
                    "(1) Search the room.\n" +
                    "(2) Try to put out the small fires.\n" +
                    "(3) Go to the next room.\n");
            int choiceThree = Integer.parseInt(myScan.nextLine());
            switch (choiceThree) {
                //Search the room
                case 1:
                    searchRoom(hero, suit, knife);
                    break;
                //Try to put out the small fires
                case 2:
                    putOutFire(hero, suit, knife);
                    break;
                //Go to the next room
                case 3:
                    return;
                default:
                    System.out.println("Looks like you don't know how to enter a pre-school number so I'm going to press 1 for you.");
                    searchRoom(hero, suit, knife);
                    break;
            }
        }
    }
    //Figure out a script or another way to close the program and reopen it with a fresh start for the player.
    public void deathMenu(CharacterInterface hero,ItemInterface suit, ItemInterface knife){
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
        switch(choice) {
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
                roomTwo(hero, suit, knife, care, edit);
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
    public void soldierChoice(CharacterInterface hero, ItemInterface suit, ItemInterface knife){
        System.out.println("\nYou think about what to do here...\n" +
                "(1) Ignore the gas.\n" +
                "(2) Try to put out the small fires.\n" +
                "(3) Try to stop the gas leak.\n");
        int choice = Integer.parseInt(myScan.nextLine());
        switch(choice) {
            //Ignore the gas
            case 1:
                soldierIgnoreGas(hero, suit, knife);
                break;
            //Put out the small fires
            case 2:
                //Check to see if hero has the suit on
                if(!hero.getList().contains(suit)){
                    hero.setHp(hero.getHp() -10);
                    System.out.println("\nYou blow with all your might and start to get woozy. You strong though, power on! \n" +
                            "Moments later you black out. Waking up, you feel weaker than before since your still breathing in \n" +
                            "the gas. **-10 hp**\nHealth Remaining: \"" + hero.getHp());
                }
                else{
                    System.out.println("\nYou blow with all your might and start to get woozy. You strong though, power on! \n" +
                            "Moments later you black out. Waking up, you realize you have your suit on and have just been blowing \n" +
                            "against the lens of your helmet. ");
                }
                System.out.println("\nWell that wasn't the smartest. Round two:\n" +
                        "(1) Ignore the gas.\n" +
                        "(2) Put out the small fires.\n" +
                        "(3) Try to stop the gas leak.\n");
                int choiceTwo = Integer.parseInt(myScan.nextLine());
                switch(choiceTwo) {
                    //Ignore the gas
                    case 1:
                        soldierIgnoreGas(hero, suit, knife);
                        break;
                    //Put out the fire
                    case 2:
                        fire = true;
                        putOutFire(hero, suit, knife);
                        break;
                    //Try to stop the gas leak
                    case 3:
                        gas = true;
                        soldierStopGas(hero, suit, knife);
                        break;
                    default:
                        System.out.println("Looks like you don't know how to enter a pre-school number so I'm going to press 1 for you.");
                        soldierIgnoreGas(hero, suit, knife);
                        break;
                }
                break;
            //Stop the gas leak
            case 3:
                gas = true;
                soldierStopGas(hero, suit, knife);
                break;
            default:
                System.out.println("Looks like you don't know how to enter a pre-school number so I'm going to press 1 for you.");
                soldierIgnoreGas(hero, suit, knife);
                break;
        }
    }
    public void captainChoice(CharacterInterface hero, ItemInterface suit, ItemInterface knife){
        System.out.println("\nYou think about what to do here...\n" +
                "(1) Ignore the gas.\n" +
                "(2) Try to put out the small fires.\n" +
                "(3) Try to stop the gas leak.\n");
        int choice = Integer.parseInt(myScan.nextLine());
        switch(choice) {
            //Ignore the gas
            case 1:
                captainIgnoreGas();
                break;
            //Put out the small fires
            case 2:
                fire = true;
                //Check to see if hero has the suit on
                if(!hero.getList().contains(suit)){
                    hero.setHp(hero.getHp() -10);
                    System.out.println("\nStill sucking in that sweet sweet gas you health trickles down a little more. \n**-10 hp**\n" +
                            "It's of no concern to you, the fearless leader. Its time to put out some fires.\n" +
                            "\"Health Remaining: \"" + hero.getHp());
                }
                else{
                    System.out.println("\nAs you look for a way to put out the fires your suit informs you the room is filling with \n" +
                            "dangerously high levels of gas.");
                }
                putOutFire(hero, suit, knife);
                break;
            //Stop the gas leak
            case 3:
                gas = true;
                captainStopGas();
                break;
            default:
                System.out.println("Looks like you don't know how to enter a pre-school number so I'm going to press 1 for you.");
                captainIgnoreGas();
                break;
        }
    }
    public void doctorChoice(CharacterInterface hero, ItemInterface suit,   ItemInterface knife){
        System.out.println("\nYou think about what to do here...\n" +
                "(1) Ignore the gas.\n" +
                "(2) Try to put out the small fires.\n" +
                "(3) Try to stop the gas leak.\n");
        int choice = Integer.parseInt(myScan.nextLine());
        switch(choice) {
            //Ignore the gas
            case 1:
                doctorIgnoreGas(hero, suit, knife);
                break;
            //Put out the small fires
            case 2:
                fire = true;
                //Check to see if hero has the suit on
                if(!hero.getList().contains(suit)){
                    hero.setHp(hero.getHp() -10);
                    System.out.println("\nYou think to yourself, the result of continued inhalation of the gas can cause various symptoms such as: \n" +
                            "Dull headache.\n" +
                            "Weakness.\n" +
                            "Dizziness.\n" +
                            "Nausea or vomiting.\n" +
                            "Shortness of breath.\n" +
                            "Confusion.\n" +
                            "Blurred vision.\n" +
                            "Loss of consciousness. \n" +
                            "-10 HP. \n" +
                            "So far its just the -10 HP so we are doing ok but it's time to put out some fires.\n" +
                            "Health Remaining: " + hero.getHp());
                }
                else{
                    System.out.println("\nAs you look for a way to put out the fires your suit informs you the room is filling with \n" +
                            "dangerously high levels of gas.");
                }
                putOutFire(hero, suit, knife);
                break;
            //Stop the gas leak
            case 3:
                gas = true;
                doctorStopGas(hero, suit, knife);
                break;
            default:
                System.out.println("Looks like you don't know how to enter a pre-school number so I'm going to press 1 for you.");
                doctorIgnoreGas(hero, suit, knife);
                break;
        }
    }
}