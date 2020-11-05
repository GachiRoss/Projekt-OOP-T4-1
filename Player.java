import java.util.ArrayList;
import java.util.Scanner;

public class Player {

    // The player:
    private String name;
    private int points = 0;
    private Game game = new Game();
    private Scanner scanner = new Scanner(System.in);
    private int whatContain;
    private Trash trash;


    // The inventory made as an ArrayList with capacity 21
    public ArrayList<Trash> inventoryList = new ArrayList<Trash>(21);

    // Constructor:
    Player(String name) {
        this.name = name;
        points = 0;

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

        String trash = command.getSecondWord();
        trash.toLowerCase();
        int trashIndex = -1;
        for (int i = 0; i < Game.getCurrentRoom().trash.size(); i++) {
            if (Game.getCurrentRoom().trash.get(i).getName().equals(trash)) {
                trashIndex = i;
            }
        }
        if (trashIndex < 0) {
            System.out.println("That piece of trash is not here!!");
        }
        else {
            Trash newTrash = Game.getCurrentRoom().trash.get(trashIndex);     // An object of trash is created temporarily called newTrash
            inventoryList.add(newTrash);
            Game.getCurrentRoom().trash.remove(trashIndex);             // Missing removeTrash method
            System.out.println(trash + "has been added to inventory!");
        }
    }

    public void openInventory(Command command) {

        if (command.hasSecondWord() == true){
            System.out.println("Check what inventory?!");
        }

        for (int i = 0; i < inventoryList.size(); i++) {
            // Prints out a description of the inventory list
            System.out.println("Slot " + (i + 1) + ": " + inventoryList.get(i).getName());
        }
        System.out.println();
    }

    public void inspectItem(Command command) {
        if (command.hasSecondWord() == true){
            int index = Integer.parseInt(command.getSecondWord());
            Trash trash = inventoryList.get(index);
            System.out.println("The name of the trash is " + trash.getName() + " which means it should be sorted with " + trash.getMaterial());
        }
        else {
            System.out.println("Check what inventory?!");
        }
    }

    public void pickUpTrash(Trash trash) {
        // to pick up this method needs to play between removing a placed item from room and adding that item to player


    }

    public void dropItem(Command command) {
        if (!Game.getCurrentRoom().equals("reCenter")) {
            System.out.println("Go to the Recycling Center to do this");
        }
        else {
            if (!command.hasSecondWord()) {
                System.out.println("Drop what?");
            } else {
                int index = Integer.parseInt(command.getSecondWord());
                index--;
                if (index > inventoryList.size() || index < 0) {
                    System.out.println("You do not have an item there");
                }
                else {
                    System.out.println("What Container do you want to drop it in?");
                    System.out.println("1: metal, 2: Hazardous waste, 3: Residual waste, 4: Plastic");
                    System.out.print("> ");
                    whatContain = scanner.nextInt();
                    Trash trash = inventoryList.get(index);
                    inventoryList.remove(index);
                    this.trash = trash;
                }
            }
        }
    }

    public void givePoints() {
        if (Game.getCurrentRoom().getName().equals("reCenter")) {
            points += Game.getCurrentRoom().getContainers()[whatContain].checkRecycling(trash);
            whatContain = 0;
        }

    }

    public void search() {
        for (int i = 0; i < Game.getCurrentRoom().trash.size(); i++) {
            System.out.println(Game.getCurrentRoom().trash.get(i).getName());
        }
    }
}
