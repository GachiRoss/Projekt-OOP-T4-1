public class Container {

    public int ID;
    public String name;

    public Container(String containerName, int containerID) {
        ID = containerID;
        name = containerName;
    }
    public int checkRecycling(Trash trash) {
        if (trash != null) {
            if (ID == trash.getID()) {
                return 1;
            } else {
                return -1;
            }
        }
        return 0;

    }
}
