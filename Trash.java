public class Trash {
    // Attributter:
    public String material;
    private String name;
    private int ID;

    // Constructor: objects (trash) are made here
    Trash (String material, String name, int trashID){
        this.material = material;
        this.name = name;
        this.ID = trashID;
        // without constructor here we can't create trash objects in Room
    }

    public String getName()
    {
        return name;
    }

    public int getID(){
        return ID;
    }






}
