import java.util.ArrayList;

public class Player {
    public ArrayList <Trash> inventoryList = new ArrayList<Trash> ();


    //Methods
    public void openInventory (){
        for (int i=0; i<inventoryList.size(); i++){
            // Prints out a description of the inventory list
            System.out.println("Slot "+ (i+1) + ": " + inventoryList.get(i).name);
        }
        System.out.println();
    }

    public void inspectTrash (){

    }
    public void pickUp (Trash trash){

    }

    public void dropItem(){

    }
}
