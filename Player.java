import java.util.ArrayList;

public class Player {

    // The player:
    private String name;
    private int points;


    // The inventory made as an ArrayList with capacity 21
    public ArrayList <Trash> inventoryList = new ArrayList<Trash> (21);

    // Constructor:
    Player(String name, int points){
        this.name = name;
        this.points = points;
    }

    // Getters and setters for player:
    private String getName(){ return name; }
    private int getPoints() { return points; }
    private void setName() { this.name = name; }
    private void setPoints() { this.points = points; } // is this needed??

    //Methods
    public void addTrashToInv (Trash trash ){
        inventoryList.add(trash);
    }

    public void openInventory (){
        for (int i=0; i<inventoryList.size(); i++){
            // Prints out a description of the inventory list
            System.out.println("Slot "+ (i+1) + ": " + inventoryList.get(i).name);
        }
        System.out.println();
    }

    public void inspectTrash (){

    }

    public void removeTrash (Trash trash) {



    }

    public void pickUpTrash (Trash trash){
          // to pick up this method needs to play between removing a placed item from room and adding that item to player

          
    }

    public void dropItem(){

    }
}
