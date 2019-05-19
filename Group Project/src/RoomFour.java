/*
 *
 * Author: Derek Marks, Corey Collins, Jon Spencer, Alexandru Trefi
 * Date: 4/20/2018
 *
 * */
import java.util.Scanner;
public class RoomFour {
    Scanner myScan = new Scanner(System.in);
    private CharacterInterface hero;
    private ItemInterface redSyringe;
    private ItemInterface blueSyringe;
    private ItemInterface greenSyringe;
    int healthCheckpoint = 0;
    private Caretaker care;
    private Editor edit;
    private int roomHp;

    public void roomFour(CharacterInterface hero, ItemInterface redSyringe, ItemInterface blueSyringe, ItemInterface greenSyringe, Caretaker care, Editor edit) {
        this.hero = hero;
        this.redSyringe = redSyringe;
        this.blueSyringe = blueSyringe;
        this.greenSyringe = greenSyringe;
        this.care = care;
        this.edit = edit;
        this.roomHp = hero.getHp();

        edit.setHero(hero);
        care.addMemento(edit.save());
        System.out.println("*\n*\n*\n*\n*\nWhen you walk into this room you hear a friendly, \"Welcome\", you have been here many times\n" +
                "This is the infirmary, you garbage sick call ranger...Geez, this voice has army jokes. Upon further\n" +
                "inspection of the room you see that this room is untouched and appears to be safe.\n" +
                "(1) Search the room further.\n" +
                "(2) Take a nap on a cot.\n" +
                "(3) Leave the room");
        int choice1 = Integer.parseInt(myScan.nextLine());
        switch(choice1) {
            //Search the room
            case 1:
                searchRoom();
                break;
            //NAP TIME!!!
            case 2:
                napTime();
                break;
            //Next Room
            case 3:
                return;
            default:
                System.out.println("Looks like you don't know how to enter a pre-school number so I'm going to press 1 for you.");
                searchRoom();
                break;
        }
    }
    public void searchRoom(){
        Scanner myScan = new Scanner(System.in);
        System.out.println("As you start searching the room you see all kinds of medical supplies.\n"
                + "Unfortunately most of them are locked up, however; on the counter you notice\n"
                + "three syringes, one red, one blue, and one green.\n"
                + "(1) Look at the red syringe.\n"
                + "(2) Look at the blue syringe.\n"
                + "(3) Look at the green syringe.\n"
                + "(4) Ignore your chance at super powers and go to the medical supplies.\n");
        int choice = Integer.parseInt(myScan.nextLine());
        switch (choice) {
            //Red POWER
            case 1:
                redSyringe();
                break;
            //Blue Health
            case 2:
                blueSyringe();
                break;
            //Green Poison
            case 3:
                greenSyringe();
                break;
            //Do nothing
            case 4:
                medicalStuff();
                break;
            default:
                System.out.println("Looks like you don't know how to enter a pre-school number so I'm going to press 1 for you.");
                redSyringe();
                break;
        }
    }
    public void medicalStuff() {
        System.out.println("As you walk around looking through the medical supplies you notice a reagent pack for the bot that heals autonomously.\n"
                + "It is very obvious where to install the pack and upon installation the screen lights up with what is clearly\n"
                + "another crazy security measure the doctor added.\n"
                + "\t\tI don't allow just anyone to use my equipment. You must be at least this tall and this intelligent\n"
                + "\t\tto be successful in healing yourself. For every question correctly answered you will receive 5 HP in healing.\n"
                + "\t\tDon't worry, there is no penalty for wrong answers. It just proves that you are not skilled enough.\n"
                + "\t\tLets begin.\n"
                + "What is broken, every time it's spoken ?");
        String input = myScan.nextLine().toLowerCase();
        if(input.equals("silence")) {
            //heal for 5
            System.out.println("Correct! You will gain an additional 5 HP\n");
            hero.setHp(hero.getHp() + 5);
        }
        else {
            //does not heal
            System.out.println("Input is not correct.\n");

        }
        System.out.println("What demands an answer, but asks no questions?\n");
        String input2 = myScan.nextLine().toLowerCase();
        if(input2.equals("phone")) {
            //heal for 5
            System.out.println("Correct! You will gain an additional 5 HP\n");
            hero.setHp(hero.getHp() + 5);
        }
        else {
            //Does not heal.
            System.out.println("Input is not correct.\n");

        }
        System.out.println("What is the shortest complete sentence in the English language?\n");
        String input3 = myScan.nextLine().toLowerCase();
        if(input3.equals("go.")) {
            //heal for 5
            System.out.println("Correct! You will gain an additional 5 HP\n");
            hero.setHp(hero.getHp() + 5);
        }
        else {
            //Does not heal.
            System.out.println("Input is not correct.\n");
        }
        System.out.println("What work can one never finish ?\n");
        String input4 = myScan.nextLine().toLowerCase();
        if(input4.equals("autobiography")) {
            //heal for 5
            System.out.println("Correct! You will gain an additional 5 HP\n");
            hero.setHp(hero.getHp() + 5);
        }
        else {
            //Does not heal.
            System.out.println("Input is not correct.\n" +
                    "The machine boots you out of the seat and pushes you out the door and into the next room.\n" +
                    "You now have " + hero.getHp() + " health remaining.");
            return;
        }
    }
    public void redSyringe(){
        if(hero.getName().equals("The Doctor")){
            System.out.println("When you pick up the red syringe it glows like the inside of a lava lamp. This looks awesome!\n"
                    + "However, as the doctor you know what this colored goo actually does.\n");
            System.out.println(redSyringe.getDetails());
            System.out.println("\n(1) Put red syringe in your inventory.\n"
                    + "(2) Look at the blue syringe instead.\n"
                    + "(3) Look at the green syringe instead.\n"
                    + "(4) Check out medical supplies.\n"
                    + "(5) Leave the room.");
            int choice = Integer.parseInt(myScan.nextLine());
            switch(choice) {
                //add red syringe to inventory
                case 1:
                    hero.getList().add(redSyringe);
                    System.out.println("Red Syringe has been added to your inventory.\n" +
                            "What do you do next?\n" +
                            "(1) Check out medical supplies.\n" +
                            "(2) Leave the room.");
                    int choice2 = Integer.parseInt(myScan.nextLine());
                    switch(choice2) {
                        //Check out medical supplies
                        case 1:
                            medicalStuff();
                            break;
                        //Leave the room
                        case 2:
                            return;
                    }
                    break;
                //Check out blue syringe
                case 2:
                    blueSyringe();
                    break;
                //check out green syringe
                case 3:
                    greenSyringe();
                    break;
                //Check out medical supplies.
                case 4:
                    medicalStuff();
                    break;
                //Leave the room
                case 5:
                    return;
                default:
                    System.out.println("Looks like you don't know how to enter a pre-school number so I'm going to press 1 for you.");
                    hero.getList().add(redSyringe);
                    System.out.println("Red Syringe has been added to your inventory.\n");
                    break;
            }
        }
        else{
            System.out.println("When you pick up the red syringe it glows like the inside of a lava lamp. This looks awesome!\n"
                    + "However, not the kind of awesome that would feel good pumping through your body.\n"
                    + "(1) Put red syringe in your inventory.\n"
                    + "(2) Look at the blue syringe instead.\n"
                    + "(3) Look at the green syringe instead.\n"
                    + "(4) Check out medical supplies.\n"
                    + "(5) Leave the room.");
            int choice = Integer.parseInt(myScan.nextLine());
            switch(choice) {
                //add red syringe to inventory
                case 1:
                    hero.getList().add(redSyringe);
                    System.out.println("Red Syringe has been added to your inventory.\n" +
                            "What do you do next?\n" +
                            "(1) Check out medical supplies.\n" +
                            "(2) Leave the room.");
                    int choice2 = Integer.parseInt(myScan.nextLine());
                    switch(choice2) {
                        //Check out medical supplies
                        case 1:
                            medicalStuff();
                            break;
                        //Leave the room
                        case 2:
                            return;
                    }
                    break;
                //Check out blue syringe
                case 2:
                    blueSyringe();
                    break;
                //check out green syringe
                case 3:
                    greenSyringe();
                    break;
                //Check out medical supplies.
                case 4:
                    medicalStuff();
                    break;
                //Leave the room
                case 5:
                    return;
                default:
                    System.out.println("Looks like you don't know how to enter a pre-school number so I'm going to press 1 for you.");
                    hero.getList().add(redSyringe);
                    System.out.println("Red Syringe has been added to your inventory. I wonder what it does.\n");
                    break;
            }
        }
    }
    public void blueSyringe(){
        if(hero.getName().equals("The Doctor")){
            System.out.println("When you pick up the blue syringe it glows but is perfectly clear like an Alaskan river. This looks awesome!\n"
                    + "However, as the doctor you know what this colored goo actually does.\n");
            System.out.println(blueSyringe.getDetails());
            System.out.println("\n(1) Put blue syringe in your inventory.\n"
                    + "(2) Look at the red syringe instead.\n"
                    + "(3) Look at the green syringe instead.\n"
                    + "(4) Check out medical supplies.\n"
                    + "(5) Leave the room.");
            int choice = Integer.parseInt(myScan.nextLine());
            switch(choice) {
                //add blue syringe to inventory
                case 1:
                    hero.getList().add(blueSyringe);
                    System.out.println("Blue Syringe has been added to your inventory.\n" +
                            "What do you do next?\n" +
                            "(1) Check out medical supplies.\n" +
                            "(2) Leave the room.");
                    int choice2 = Integer.parseInt(myScan.nextLine());
                    switch(choice2) {
                        //Check out medical supplies
                        case 1:
                            medicalStuff();
                            break;
                        //Leave the room
                        case 2:
                            return;
                    }
                    break;
                //Check out red syringe
                case 2:
                    redSyringe();
                    break;
                //check out green syringe
                case 3:
                    greenSyringe();
                    break;
                //Check out medical supplies.
                case 4:
                    medicalStuff();
                    break;
                //Leave the room
                case 5:
                    return;
                default:
                    System.out.println("Looks like you don't know how to enter a pre-school number so I'm going to press 1 for you.");
                    hero.getList().add(blueSyringe);
                    System.out.println("Blue Syringe has been added to your inventory.\n");
                    break;
            }
        }
        else{
            System.out.println("When you pick up the blue syringe it glows but is perfectly clear like an Alaskan river. This looks awesome!\n"
                    + "However, not the kind of awesome that would feel good pumping through your body.\n"
                    + "(1) Put blue syringe in your inventory.\n"
                    + "(2) Look at the red syringe instead.\n"
                    + "(3) Look at the green syringe instead.\n"
                    + "(4) Check out medical supplies.\n"
                    + "(5) Leave the room.");
            int choice = Integer.parseInt(myScan.nextLine());
            switch(choice) {
                //add blue syringe to inventory
                case 1:
                    hero.getList().add(blueSyringe);
                    System.out.println("Blue Syringe has been added to your inventory.\n" +
                            "What do you do next?\n" +
                            "(1) Check out medical supplies.\n" +
                            "(2) Leave the room.");
                    int choice2 = Integer.parseInt(myScan.nextLine());
                    switch(choice2) {
                        //Check out medical supplies
                        case 1:
                            medicalStuff();
                            break;
                        //Leave the room
                        case 2:
                            return;
                    }
                    break;
                //Check out red syringe
                case 2:
                    redSyringe();
                    break;
                //check out green syringe
                case 3:
                    greenSyringe();
                    break;
                //Check out medical supplies.
                case 4:
                    medicalStuff();
                    break;
                //Leave the room
                case 5:
                    return;
                default:
                    System.out.println("Looks like you don't know how to enter a pre-school number so I'm going to press 1 for you.");
                    hero.getList().add(blueSyringe);
                    System.out.println("Blue Syringe has been added to your inventory. I wonder what it does.\n");
                    break;
            }
        }
    }
    public void greenSyringe(){
        if(hero.getName().equals("The Doctor")) {
            System.out.println("When you pick up the green syringe it does not glow like the other syringes this one slowly pulsates.\n"
                    + "Think of a nuclear reactor, totally screams crazy power...maybe like the Hulk???\n"
                    + "However, as the doctor you know what this colored goo actually does.\n");
            System.out.println(greenSyringe.getDetails());
            System.out.println("\n(1) Put green syringe in your inventory.\n"
                    + "(2) Look at the red syringe instead.\n"
                    + "(3) Look at the blue syringe instead.\n"
                    + "(4) Check out medical supplies.\n"
                    + "(5) Leave the room.");
            int choice = Integer.parseInt(myScan.nextLine());
            switch (choice) {
                //add green syringe to inventory
                case 1:
                    hero.getList().add(greenSyringe);
                    System.out.println("Green Syringe has been added to your inventory.\n" +
                            "What do you do next?\n" +
                            "(1) Check out medical supplies.\n" +
                            "(2) Leave the room.");
                    int choice2 = Integer.parseInt(myScan.nextLine());
                    switch(choice2) {
                        //Check out medical supplies
                        case 1:
                            medicalStuff();
                            break;
                        //Leave the room
                        case 2:
                            return;
                    }
                    break;
                //Check out red syringe
                case 2:
                    redSyringe();
                    break;
                //check out blue syringe
                case 3:
                    blueSyringe();
                    break;
                //Check out medical supplies.
                case 4:
                    medicalStuff();
                    break;
                //Leave the room
                case 5:
                    return;
                default:
                    System.out.println("Looks like you don't know how to enter a pre-school number so I'm going to press 1 for you.");
                    hero.getList().add(greenSyringe);
                    System.out.println("Green Syringe has been added to your inventory.\n");
                    break;
            }
        }
        else{
            System.out.println("When you pick up the green syringe it does not glow like the other syringes this one slowly pulsates.\n"
                    + "Think of a nuclear reactor, totally screams crazy power...maybe like the Hulk???\n"
                    + "(1) Put green syringe in your inventory.\n"
                    + "(2) Look at the red syringe instead.\n"
                    + "(3) Look at the blue syringe instead.\n"
                    + "(4) Check out medical supplies.\n"
                    + "(5) Leave the room.");
            int choice = Integer.parseInt(myScan.nextLine());
            switch(choice) {
                //add green syringe to inventory
                case 1:
                    hero.getList().add(greenSyringe);
                    System.out.println("Green Syringe has been added to your inventory.\n" +
                            "What do you do next?\n" +
                            "(1) Check out medical supplies.\n" +
                            "(2) Leave the room.");
                    int choice2 = Integer.parseInt(myScan.nextLine());
                    switch(choice2) {
                        //Check out medical supplies
                        case 1:
                            medicalStuff();
                            break;
                        //Leave the room
                        case 2:
                            return;
                    }
                    break;
                //Check out red syringe
                case 2:
                    redSyringe();
                    break;
                //check out blue syringe
                case 3:
                    blueSyringe();
                    break;
                //Check out medical supplies.
                case 4:
                    medicalStuff();
                    break;
                //Leave the room
                case 5:
                    return;
                default:
                    System.out.println("Looks like you don't know how to enter a pre-school number so I'm going to press 1 for you.");
                    hero.getList().add(greenSyringe);
                    System.out.println("Green Syringe has been added to your inventory. I wonder what it does.\n");
                    break;
            }
        }
    }
    public void napTime() {
        System.out.println("Really...there is someone on the ship who tried to kill you and you want to take a nap...\n"
                + "You know what? You deserve to die... The bad guy comes in while you are sleeping and kills you.\n"
                + "Game over :( do not pass go, do not collect $200\n"
                + "(1) =(\n"
                + "(2) :(\n"
                + "(3) :*(\n");
        deathMenu();
    }
    public void deathMenu(){
        System.out.println("  _____\n" +
                " /     \\\n" +
                "| () () |\n" +
                " \\  ^  /\n" +
                "  |||||\n" +
                "  |||||\n" +
                "Que spooky death music\n" +
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
                hero = edit.restore(care.getMementos());
                hero.setHp(roomHp);
                roomFour(hero, redSyringe, blueSyringe, greenSyringe, care, edit);
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