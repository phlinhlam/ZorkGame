import java.util.Random;
import java.util.Scanner;

public class Zork {

    //public variables to store user inputs for return
    public static String userInput="";
    public static int count=0; //count number of rooms entered
    public static boolean key=true;//if door is opened

    public static void main(String[] args) {
        Scanner kd = new Scanner(System.in);
        foyer();
        while(!userInput.equalsIgnoreCase("stop")) {
            switch (userInput) {
                case "foyer":
                    foyer();
                    break;
                case "front room":
                    frontRoom();
                    break;
                case "library":
                    library();
                    break;
                case "kitchen":
                    kitchen();
                    break;
                case "dining room":
                    diningRoom();
                    break;
                case "vault":
                    vaultRoom();
                    break;
                case "parlor":
                    parlorRoom();
                    break;
                case "secret room":
                    secretRoom();
                    break;
                case "quit":
                    quit();
                    break;
            }

        }

    }
    public static String foyer(){
        Scanner kd = new Scanner(System.in);
        count+=1;
        System.out.println("You are in room 1, foyer room");
        System.out.println("Dead scorpion");
        System.out.println("Do you want to go north or quit?");
        String answer= kd.next();
        if(answer.equalsIgnoreCase("north")){
            userInput="front room";
        }else{
            userInput="quit";
        }
        return userInput;
    }

    public static String frontRoom(){
        Scanner kd = new Scanner(System.in);
        count+=1;
        System.out.println("You are in room 2, front room");
        System.out.println("Piano");
        System.out.println("Do you want to go south, west, east or quit?");
        String answer= kd.next();
        switch (answer) {
            case "south":
                userInput="foyer";
                break;
            case "west":
                userInput="library";
                break;
            case "east":
                userInput="kitchen";
                break;
            case "quit":
                userInput="quit";
                break;

        }

        return userInput;
    }

    public static String library(){
        Scanner kd = new Scanner(System.in);
        count+=1;
        System.out.println("You are in room 3, library");
        System.out.println("Spiders");
        System.out.println("Do you want to go north, east or quit?");
        String answer= kd.next();
        switch (answer) {
            case "north":
                userInput="dining room";
                break;

            case "east":
                userInput="front room";
                break;
            case "quit":
                userInput="quit";
                break;
        }
        return userInput;
    }
    public static String kitchen(){
        Scanner kd = new Scanner(System.in);
        count+=1;
        System.out.println("You are in room 4, kitchen");
        System.out.println("Bats");
        System.out.println("Do you want to go west, north or quit?");
        String answer= kd.next();
        switch (answer) {
            case "north":
                userInput="parlor";
                break;
            case "west":
                userInput="front room";
                break;

            case "quit":
                userInput="quit";
                break;

        }

        return userInput;
    }
    public static String diningRoom(){
        Scanner kd = new Scanner(System.in);
        count+=1;
        System.out.println("You are in room 5, dining room");
        System.out.println("Dust and empty box");
        System.out.println("Do you want to go south or quit?");
        String answer= kd.next();
        switch (answer) {
            case "south":
                userInput="library";
                break;

            case "quit":
                userInput="quit";
                break;

        }

        return userInput;
    }

    public static String vaultRoom() {
        Scanner kd = new Scanner(System.in);
        count += 1;


        System.out.println("You are in room 6, the vault");
        System.out.println("3 walking skeletons");
        if (key) {
            System.out.println("Do you want to go east?");
            String answer = kd.nextLine();
            Random random = new Random();
            int nextInt = random.nextInt(4);
            if (answer.equalsIgnoreCase("east")) {

                if (nextInt == 0) {
                    userInput = "secret room";
                    key = false;
                } else {
                    userInput = "parlor";
                }

            } else if (answer.equalsIgnoreCase("quit")) {
                userInput = "quit";
            }
        } else {

            System.out.println("Do you want to go to parlor or secret room?");
            String answer = kd.nextLine();

            if (answer.equalsIgnoreCase("secret")) {
                userInput = "secret room";

            } else if (answer.equalsIgnoreCase("parlor")) {
                userInput = "parlor";
            } else {
                userInput = "quit";

            }

        }
        return userInput;
    }
    public static String parlorRoom()
    {
        Scanner kd = new Scanner(System.in);
        count+=1;
        System.out.println("You are in room 7 - Parlor");
        System.out.println("Treasure chest");
        System.out.println("Do you want to go west, south, or quit?");
        String answer = kd.nextLine();
        switch (answer) {
            case "west":
                userInput="vault";
                break;
            case "south":
                userInput="kitchen";
                break;
            case "quit":
                userInput="quit";
                break;
        }//end switch
        return userInput;
    }
    public static String secretRoom() {
        Scanner kd = new Scanner(System.in);
        count+=1;
        System.out.println("You are in room 8, Secret room");
        System.out.println("Pile if gold");
        System.out.println("Do you want to go west or quit?");
        String answer = kd.nextLine();
        switch (answer) {
            case "west":
                userInput="vault";
                break;

            case "quit":
                userInput="quit";
                break;
        }
        return userInput;
    }

    public static String quit() {
        Random random=new Random();
        int nextInt = random.nextInt(4);
        if (nextInt == 0) {
            System.out.println("A ghost is following you");
        }
        else
        {
            System.out.println("You have safely escaped the castle. No ghost");
        }
        System.out.println("You have visited " + count + " rooms while you were in the castle");
        userInput="stop";
        return userInput;
    }


}