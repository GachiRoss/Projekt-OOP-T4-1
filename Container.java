public class Container {

    public int ID;
    public String name;

    public Container(String containerName, int containerID) {
        ID = containerID;
        name = containerName;   //there might be a problem with the name variable here and the one in the trash class i think.
        // Fairly sure there are two variables called "name"
    }

    //trashID is a placeholder name. It might change if Flora and Emma decide to use another name in their classes
    public boolean checkRecycling(int trashID, int containerID) {
        if (trashID == containerID)
            return true;
        else {
            return false;
        }
    }
}
