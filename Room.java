import java.util.ArrayList;
import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;


public class Room
{
    private String description;

    // Trash instance variable:
    private String name;
    public ArrayList<Trash> trash = new ArrayList<Trash>(5); // creates an ArrayList
    private HashMap<String, Room> exits; //?

    private Trash can = new Trash("Metal", "Can", 1);
    private Trash battery = new Trash("Hazardous waste", "Battery", 2);
    private Trash pizzaBox = new Trash("Residual waste", "Pizza box", 3);
    private Trash plasticBag = new Trash("Plastic", "Plastic bag", 4);
    private Trash porcelainPlate = new Trash("Hazardous waste", "Porcelain plate", 2);

    // Constructor: adds trash objects of Trash to ArrayList trash


    public Room(String description, String name)
    {
        this.description = description;
        this.name = name;
        exits = new HashMap<String, Room>();

        trash.add(battery);
        trash.add(can);
        trash.add(pizzaBox);
        trash.add(plasticBag);
        trash.add(porcelainPlate);

    }

    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    public String getShortDescription()
    {
        return description;
    }

    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString();
    }

    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }

    public String getName() {
        return name;
    }

    public Container[] getContainers() {
        return null;
    }


}

