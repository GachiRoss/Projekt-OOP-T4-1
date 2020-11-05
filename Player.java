import java.util.ArrayList;
import java.util.Scanner;

public class Player {

    // The player:
    private String name;
    private int points = 0;
    private Game game = new Game();
    private Scanner scanner = new Scanner(System.in);
    private int whatContain;


    // The inventory made as an ArrayList with capacity 21
    public ArrayList<Trash> inventoryList = new ArrayList<Trash>(21);

    // Constructor:
    Player(String name, int points) {
        this.name = name;
        this.points = points;

    }

    // Getters and setters for player:
    private String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    private void setName() {
        this.name = name;
    }


    //Methods
    public void pickUp (Command command) {
        // check if there is a second word in command
        if (!command.hasSecondWord()){
            System.out.println("Missing second word...");
        }

        String trash = command.getSecondWord();     // ???

        Trash newTrash = currentRoom.pickUp(trash);     // An object of trash is created temporarily called newTrash

        if (newTrash == null){                          // checks if newTrash exists in the room?? ikke sikker
            System.out.println("That piece of trash is not here!!");

        }
        else {
            inventoryList.add(newTrash);
            currentRoom.removeTrash(trash);             // Missing removeTrash method
            System.out.println(trash + "has been added to the inventory!");
        }
    }

    public void openInventory(Command command) {

        if (command.hasSecondWord() == true){
            System.out.println("Check what inventory?!");
        }

    public void openInventory() {
        for (int i = 0; i < inventoryList.size(); i++) {
            // Prints out a description of the inventory list
            System.out.println("Slot " + (i + 1) + ": " + inventoryList.get(i).name);
        }
        System.out.println();
    }

    public void inspectTrash() {

    }

    public void removeTrash (Trash trash) {



    }

    public void pickUpTrash(Trash trash) {
        // to pick up this method needs to play between removing a placed item from room and adding that item to player


    }

    public Trash dropItem() {
        if (!Game.getCurrentRoom().equals("reCenter")) {
            return null;
        }
        else {
            if (!command.hasSecondWord()) {
                System.out.println("Drop what?");
                return null;
            } else {
                int index = command.getSecondWord();
                index--;
                if (index > inventoryList.size() || index < 0) {
                    System.out.println("You do not have an item there");
                    return null;
                }
                else {
                    System.out.println("What Container do you want to drop it in?");
                    System.out.println("1: metal, 2: Hazardous waste, 3: Residual waste, 4: Plastic");
                    System.out.println("> ");
                    whatContain = scanner.nextInt();
                    Trash trash = inventoryList.get(index);
                    inventoryList.remove(index);
                    return trash;
                }
            }
        }
    }

    public void givePoints() {
        if (Game.getCurrentRoom().getName().equals("reCenter")) {
            points += Game.getCurrentRoom().getContainers()[whatContain].checkRecycling(dropItem());
            whatContain = 0;
        }

    }
}