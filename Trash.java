public class Trash {
    // Attributter:
    private String material;
    private String name;
    private TrashType trashType;
    /*
    ID = material
    1 = metal
    2 = Hazardous waste
    3 = Residual waste
    4 = Plastic
     */

    // Constructor: objects (trash) are made here
    Trash (String material, String name, TrashType trashType){
        this.material = material;
        this.name = name;
        this.trashType = trashType;
        // without constructor here we can't create trash objects in Room
    }

    public String getName()
    {
        return name;
    }

    public TrashType getTrashType(){
        return trashType;
    }

    public String getMaterial() {
        return material;
    }






}
