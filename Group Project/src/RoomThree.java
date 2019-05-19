/*
 *
 * Author: Derek Marks, Corey Collins, Jon Spencer, Alexandru Trefi
 * Date: 4/20/2018
 *
 * */
import java.util.Random;
import java.util.Scanner;
public class RoomThree{
    private CharacterInterface hero;
    private ItemInterface suit;
    public static int num;
    private Caretaker care;
    private Editor edit;
    private int roomHp;
    boolean meds = false;
    Scanner myScan = new Scanner(System.in);

    public void roomThree(CharacterInterface hero, ItemInterface suit, Caretaker care, Editor edit){
        this.hero = hero;
        this.suit = suit;
        this.care = care;
        this.edit = edit;
        this.roomHp = hero.getHp();
        edit.setHero(hero);
        care.addMemento(edit.save());

        System.out.println("*\n*\n*\n*\n*\nAs you journey further into the 5th circle of hell, wait wrong story, you come to the recreational room.\n" +
                "As you approach the hatch it is very cold to the touch. Curious, you move through. Weightlessness takes over and\n" +
                "you begin floating deep into the room wondering what is happening and why is everything iced over. As you spin towards\n" +
                "the wall you see a large hole about the size of basketball. Luckily the ship's shields are still active keeping the room\n" +
                "pressurized but there is no gravity and the life support system is straining keeping the temperature from killing you instantly.\n" +
                "You feel the cold penetrating your bones. Your options are...");
        if(!hero.getList().contains(suit)){
            hero.setHp(hero.getHp() -10);
            System.out.println("Since you thought you were too cool to wear the suit you are now loosing health due to the cold. Cheers!\n" +
                    "**-10HP**");
            System.out.println("Health Remaining: " + hero.getHp());
        }
        System.out.println("\n(1) Relax and go gentle into that good night.\n" +
                "(2) Find a way to fix the hole.\n" +
                "(3) This game sucks. Float off into space.\n");
        int choice = Integer.parseInt(myScan.nextLine());
        switch(choice) {
            //Relax and go gentle into that good night
            case 1:
                System.out.println("After some time, your joints slowly tighten and your body begins to freeze over. It's a peaceful way out.");
                deathMenu();
                break;
            //Find a way to fix the hole
            case 2:
                fixTheHole();
                break;
            //This game sucks
            case 3:
                System.out.println("You push yourself off the door towards the hole to drift off into the sweet bliss...You smack your head\n" +
                        "against the shield. Hah! Just because you don't like our game doesn't mean you can kill yourself. You know I\n" +
                        "don't like your attitude. You get stuck in between the shield and outside of the hull. You die a slow painful,\n" +
                        "freezing death.");
                deathMenu();
                break;
            default:
                System.out.println("Looks like you don't know how to enter a pre-school number so I'm going to press 1 for you.\n" +
                        "After some time, your joints slowly tighten and your body begins to freeze over. It's a peaceful way out.");
                deathMenu();
                break;
        }
        searchRoom();
    }
    public void searchRoom(){
        System.out.println("As you gather your strength you begin looking around the room. You notice a bench press, a random\n" +
                "assortment of workout equipment, and another door that leads to the infirmary.\n" +
                "(1) Squeeze in a quick set on the bench press.\n" +
                "(2) Leave to the infirmary.");
        int choice = Integer.parseInt(myScan.nextLine());
        switch(choice) {
            //Squeeze in a set of bench press
            case 1:
                benchPress(hero, suit);
                break;
            case 2:
                infirmary(hero);
                return;
            default:
                System.out.println("Looks like you don't know how to enter a pre-school number so I'm going to press 1 for you.\n");
                benchPress(hero, suit);
                break;
        }
    }
    public void benchPress(CharacterInterface hero, ItemInterface suit){
        //Soldier
        if (hero.getName().equals("The Space Marine")) {
            System.out.println("You can always get some reps in. Unless it's leg day. Ain't nobody got time for that.\n" +
                    "You sort some pre workout and lay down on the bench. How many reps do you wanna do?\n");
            int reps = Integer.parseInt(myScan.nextLine());
            while (reps <= 0) {
                System.out.println("Have to do at least one dum dum. Try again.");
                reps = Integer.parseInt(myScan.nextLine());
            }
            if (reps > 0 && reps < 6) {
                System.out.println("Pathetic. You can do more than that. Better luck next time.\n" +
                        "**Strength remains the same**");
            } else if (reps >= 6 && reps < 11) {
                System.out.println("Ok, average gym stud rep count. Not gonna get stronger that way.\n" +
                        "**Strength remains the same**");
            } else if (reps >= 11 && reps < 16) {
                System.out.println("I like where your head's at but that's an easy day for soldier boi.\n" +
                        "**Strength remains the same**");
            } else if (reps >= 16 && reps < 21) {
                System.out.println("That's what I'm talking about. Your feeling bigger, badder and stronger than ever.\n" +
                        "**Strength increased by 1**");
                hero.addStrength(1);
                System.out.println("Strength is now: " + hero.getStrength());
            } else if (reps >= 21) {
                System.out.println("Come on now, after all we have been through so far you are pushing it way to hard.\n" +
                        "You will be sore for the next week.\n" +
                        "**Strength decreased by 1**");
                hero.loseStrength(1);
                System.out.println("Strength is now: " + hero.getStrength());
            }
            System.out.println("Now that the random workout session is over, what now?\n" +
                    "(1) Leave to the infirmary.");
            int choice = Integer.parseInt(myScan.nextLine());
            switch (choice) {
                case 1:
                    infirmary(hero);
                    return;
                default:
                    System.out.println("Looks like you don't know how to enter a pre-school number so I'm going to press 1 for you.\n");
                    infirmary(hero);
                    break;
            }
        }
        //Captain
        else if (hero.getName().equals("The Captain")) {
            System.out.println("Does the Captain even work out? Rocking that dad bod, probably not.\n" +
                    "Well, how many reps do you wanna do?\n");
            int reps = Integer.parseInt(myScan.nextLine());
            while (reps <= 0) {
                System.out.println("Have to do at least one dum dum. Try again.");
                reps = Integer.parseInt(myScan.nextLine());
            }
            if (reps > 0 && reps < 6) {
                System.out.println("Yeah you could knock out a couple and it would probably do you some good.\n" +
                        "**Strength increased by 1**");
                hero.addStrength(1);
                System.out.println("Strength is now: " + hero.getStrength());
            } else if (reps >= 6 && reps < 16) {
                System.out.println("You try with everything you have but your shoulder pops painfully loud. You swear off weights forever.\n" +
                        "**Strength decreased by 1**");
                hero.loseStrength(1);
                System.out.println("Strength is now: " + hero.getStrength());
            } else if (reps >= 16) {
                System.out.println("You won't even humor the idea. Next. \n" +
                        "**Strength remains the same**");
            }
            System.out.println("Now that the random workout session is over, what now?\n" +
                    "(1) Leave to the infirmary.");
            int choice = Integer.parseInt(myScan.nextLine());
            switch (choice) {
                case 1:
                    infirmary(hero);
                    break;
                default:
                    System.out.println("Looks like you don't know how to enter a pre-school number so I'm going to press 1 for you.\n");
                    infirmary(hero);
                    return;
            }
        }
        //Doctor
        else {
            System.out.println("Doctor...in the gym. This should be good.\n" +
                    "Well, how many reps do you wanna do?\n");
            int reps = Integer.parseInt(myScan.nextLine());
            while (reps <= 0) {
                System.out.println("Have to do at least one dum dum. Try again.");
                reps = Integer.parseInt(myScan.nextLine());
            }
            if (reps > 0 && reps < 4) {
                System.out.println("You stand there for 30 mins thinking of the logistics on how to lift the weights.\n" +
                        "Finally you attempt and are able to almost get 1 full rep but we can count it.\n" +
                        "**Strength increased by 1**");
                hero.addStrength(1);
                System.out.println("Strength is now: " + hero.getStrength());
            }
            if (reps >= 5) {
                System.out.println("As soon as you lift the bar off the rack your arms turn to jello and you drop the weights\n" +
                        "on yourself. Luckily it hit the rack on the left side as it came down so it just hit you and continued\n" +
                        "off to the side instead of crushing your baby deer physique.\n" +
                        "**Strength remains the same**\n" +
                        "**-10 HP**\n" + "Remaining Health: " + hero.getHp());
            }
            System.out.println("Now that the random workout session is over, what now?\n" +
                    "(1) Leave to the infirmary.");
            int choice = Integer.parseInt(myScan.nextLine());
            switch (choice) {
                case 1:
                    infirmary(hero);
                    return;
                default:
                    System.out.println("Looks like you don't know how to enter a pre-school number so I'm going to press 1 for you.\n");
                    infirmary(hero);
                    return;
            }
        }
    }
    public void infirmary(CharacterInterface hero){
        if(meds == false) {
            meds = true;
            //Soldier
            if (hero.getName().equals("The Space Marine")) {
                wordScrambleSoldier();
            }
            //Captain
            else if (hero.getName().equals("The Captain")) {
                wordScrambleCaptain();
            }
            //Doctor
            else {
                wordScrambleDoctor();
            }
        }
        else{
            return;
        }
    }
    public void wordScrambleSoldier(){
        System.out.println("As soon as you step on the pad in front of the door a small electrical current shoots through your body\n" +
                "making you unable to move. A keypad emerges from a sliding panel on the door and you see some\n" +
                "letters written above the key pad with the instructions:\n\n" +
                "\t\"For every wrong answer you will be shocked and take damage\n" +
                "\tthis will continue until you are dead or the code is solved.\n" +
                "\twhat word is jumbled in the code below.....Enjoy! : )\"\n\n" +
                " ____ _____ ___ ___  ____ \n" +
                "| __ )_   _|_ _/ _ \\|  _ \\ \n" +
                "|  _ \\ | |  | | | | | |_) |\n" +
                "| |_) || |  | | |_| |  _ < \n" +
                "|____/ |_| |___\\___/|_| \\_|\n" +
                "                              \n");
        System.out.println("Enter your response:");
        String answer = myScan.nextLine();
        while (!answer.equalsIgnoreCase("orbit")) {
            System.out.println("A horrible screeching sound builds and builds getting louder util a jolt of electricity shoots up your legs and\n" +
                    "through your body. It feels like a horse has kicked you in the chest. Guess you got that wrong.\n" +
                    "Would you like to try again? Ha ha ha like you have a choice.\n**-10HP**\n");
            hero.setHp(hero.getHp() - 10);
            System.out.println("Health Remaining: " + hero.getHp());

            if (hero.getHp() <= 0) {
                System.out.println("Womp Womp Womp.\n" +
                        "Maybe you will get it next time. We will hold a nice funeral for you.");
                deathMenu();
            }
            answer = myScan.nextLine();
        }
        System.out.println("\nCONGRATULATIONS! Orbit was correct. The electricity fades from your legs, the door creaks open\n" +
                "and you hesitantly walk in wondering why in the world that kind of lock was on the infirmary's door.");
    }
    public void wordScrambleCaptain(){
        System.out.println("As soon as you step on the pad in front of the door a small electrical current shoots through your body\n" +
                "making you unable to move. A keypad emerges from a sliding panel on the door and you see some\n" +
                "letters written above the key pad with the instructions:\n\n" +
                "\t\"For every wrong answer you will be shocked and take damage\n" +
                "\tthis will continue until you are dead or the code is solved.\n" +
                "\twhat word is jumbled in the code below.....Enjoy! : )\"\n\n" +
                " _____ ___    _    ____  ___ ____ _____ ____ \n" +
                "| ____/ _ \\  / \\  |  _ \\|_ _/ ___|_   _|  _ \\ \n" +
                "|  _|| | | |/ _ \\ | |_) || |\\___ \\ | | | | | |\n" +
                "| |__| |_| / ___ \\|  _ < | | ___) || | | |_| |\n" +
                "|_____\\___/_/   \\_\\_| \\_\\___|____/ |_| |____/ \n" +
                "                                                     ");
        System.out.println("Enter your response:");
        String answer = myScan.nextLine();
        while (!answer.equalsIgnoreCase("asteroid")) {
            System.out.println("A horrible screeching sound builds and builds getting louder util a jolt of electricity shoots up your legs and\n" +
                    "through your body. It feels like a horse has kicked you in the chest. Guess you got that wrong.\n" +
                    "Would you like to try again? Ha ha ha like you have a choice. \n**-10HP**\n");
            hero.setHp(hero.getHp() - 10);
            System.out.println("Health Remaining: " + hero.getHp());

            if (hero.getHp() <= 0) {
                System.out.println("Womp Womp Womp.\n" +
                        "Maybe you will get it next time. We will hold a nice funeral for you.");
                deathMenu();
            }
            answer = myScan.nextLine();
        }
        System.out.println("\nCONGRATULATIONS! Asteroid was correct. The electricity fades from your legs, the door creaks open\n" +
                "and you hesitantly walk in wondering why in the world that kind of lock was on the infirmary's door.");
    }
    public void wordScrambleDoctor(){
        System.out.println("As soon as you step on the pad in front of the door a small electrical current shoots through your body\n" +
                "making you unable to move. A keypad emerges from a sliding panel on the door and you see some\n" +
                "letters written above the key pad with the instructions:\n\n" +
                "\t\"For every wrong answer you will be shocked and take damage\n" +
                "\tthis will continue until you are dead or the code is solved.\n" +
                "\twhat word is jumbled in the code below.....Enjoy! : )\"\n\n" +
                " __   ______   ___  __  __    _  _____ ____  _   _  ___           \n" +
                " \\ \\ / /  _ \\ / _ \\|  \\/  |  / \\|_   _/ ___|| \\ | |/ _ \\ \n" +
                "  \\ V /| |_) | | | | |\\/| | / _ \\ | | \\___ \\|  \\| | | | |\n" +
                "   | | |  _ <| |_| | |  | |/ ___ \\| |  ___) | |\\  | |_| |\n" +
                "   |_| |_| \\_\\\\___/|_|  |_/_/   \\_\\_| |____/|_| \\_|\\___/ \n" +
                "                                                                    ");
        System.out.println("Enter your response:");
        String answer = myScan.nextLine();
        while (!answer.equalsIgnoreCase("astronomy")) {
            System.out.println("A horrible screeching sound builds and builds getting louder util a jolt of electricity shoots up your legs and\n" +
                    "through your body. It feels like a horse has kicked you in the chest. Guess you got that wrong.\n" +
                    "Would you like to try again? Ha ha ha like you have a choice. \n**-10HP**\n");
            hero.setHp(hero.getHp() - 10);
            System.out.println("Health Remaining: " + hero.getHp());

            if (hero.getHp() <= 0) {
                System.out.println("Womp Womp Womp.\n" +
                        "Maybe you will get it next time. We will hold a nice funeral for you.");
                deathMenu();
            }
            answer = myScan.nextLine();
        }
        System.out.println("\nCONGRATULATIONS! Astronomy was correct. The electricity fades from your legs, the door creaks open\n" +
                "and you hesitantly walk in wondering why in the world that kind of lock was on the infirmary's door.");
    }
    public void fixTheHole(){
        System.out.println("You quickly scan the room to see what you could do before you freeze.\n" +
                "(1) Cover the hole with a poster you see on the wall. It has a kitten hanging onto a branch that says, \"Hang in there\".\n" +
                "(2) There is some bubble gum on the squat rack...gross. Maybe you could stretch it to cover the hole.\n" +
                "(3) There is an exercise ball maybe you could squeeze it into the hole.\n");
        int choice = Integer.parseInt(myScan.nextLine());
        switch(choice) {
            //Use the poster
            case 1:
                System.out.println("Clearly a paper poster of a kitten isn't going to help. You apply the poster and it doesn't \n" +
                        "help at all. You freeze and die. Sorry.");
                deathMenu();
                break;
            //Bubble gum
            case 2:
                System.out.println("You begin chewing all the gum you see while wondering who is sticking gum on all the workout equipment. We can \n" +
                        "deal with that later, focus. The gum is getting harder and harder to chew so you stick it to each to the wall and \n" +
                        "begin pulling it across the gap. Once it's in place you notice the gum getting very hard. Ohhhh it's bazooka joe brand.\n" +
                        "That stuff gets hard so fast when you chew it. It is forming a solid cover to the hole, I can't believe that worked!\n" +
                        "The support systems seem to be working at almost full power again. The temperature and gravity is restored and\n" +
                        "you regain your strength.\n");
                break;
            //Exercise ball
            case 3:
                System.out.println("This should work right? These exercise balls don't pop...from what you remember. It warps and contorts as\n" +
                        "you push it into the hole and it stops just short of halfway. This seems to be working well. The support systems\n" +
                        "seem to be working at almost full power again. The temperature and gravity is restored.\n");
                break;
            default:
                System.out.println("Looks like you don't know how to enter a pre-school number so I'm going to press 1 for you.\n" +
                        "Clearly a paper poster of a kitten isn't going to help. You apply the poster and it doesn't \n" +
                        "help at all. You freeze and die. Sorry.");
                deathMenu();
                break;
        }
    }
    public void deathMenu(){
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
                roomThree(hero, suit, care, edit);
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