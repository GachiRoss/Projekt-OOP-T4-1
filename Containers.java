public class Containers {

    public String containerName;
    public int containerID;

    public int checkRecycling(Trash trash) {
        if (trash != null) {
            if (containerID == trash.getID()) {
                return 1;
            } else {
                return -1;
            }
        }
        return 0;

    }
}
