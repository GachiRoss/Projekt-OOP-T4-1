import java.util.ArrayList;

public class RecyclingCenter extends Room {

    public RecyclingCenter(String description) {
        super(description);
    }

    private Container metalContainer = new Container("Metal Container", TrashType.METAL);
    private Container hazardousContainer = new Container("Hazardous Container", TrashType.HAZARDOUSWASTE);
    private Container residualContainer = new Container("Residual Container", TrashType.RESIUALWASTE);
    private Container plasticContainer = new Container("Plastic Container", TrashType.PLASTIC);
    private Container[] containers = {metalContainer, hazardousContainer, residualContainer, plasticContainer};

    public Container[] getContainers() {
        return containers;
    }

}
