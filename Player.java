import java.awt.Container;
import java.util.ArrayList;
import java.util.Scanner;

public class Player {

    // The player:
    private String name;
    public int points = 0;


    // The inventory made as an ArrayList with capacity 21
    public ArrayList<Trash> inventoryList = new ArrayList<Trash>(21);

    // Constructor:
    Player(String name, int points) {
        this.name = name;
        this.points = points;

    }

    // Getters and setters for player:
    private String getName(){ return name; }
    public int getPoints() { return points; }
    private void setName() { this.name = name; }
    public void setPoints() { this.points = points; } // is this needed??


    //Methods
    public void addTrashToInv(Trash trash) {
        inventoryList.add(trash);
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
        //Room house = new Room("At home", )
    }

    public void pickUpTrash(Trash trash) {
        // to pick up this method needs to play between removing a placed item from room and adding that item to player


    }

    public Trash dropItem() {
        if (!command.hasSecondWord()) {
            System.out.println("Drop what?");
            return null;
        }
        else {
            int index = command.getSecondWord();
            index--;
            if (index > inventoryList.size() || index < 0) {
                System.out.println("You do not have an item there");
                return null;
            }
            Trash trash = inventoryList.get(index);
            inventoryList.remove(index);
            return trash;
            }
        }

        public int givePoints(Containers point) {
            if (Containers.checkRecycling() == 1) {
                return points+1;
            } else {
                return points-1;
            }


        }

    }


