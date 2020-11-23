public class Game {
    // Der erklæres to variabler
    private Parser parser;
    private static Room currentRoom;
    private Player player;
        
// constructor - kører metode CreateRooms og laver et nyt objekt
    public Game() 
    {
        parser = new Parser();
    }

// metode
    private void createRooms()
    {
        Room park, beach, street, conSite, foodTruck, home, reCenter;
        // rum dannes som objekter
        park = new Room("You're at an park");
        beach = new Room("You're on a beach");
        street = new Room("You're out on a big street");
        conSite = new Room("You're on a construction site");
        foodTruck = new Room("You're next to a food truck");
        home = new Room("You're in your apartment");
        reCenter = new RecyclingCenter("You're at the recycling center");

        //exits til rummene erklæres via metoden setExit
        home.setExit("south", foodTruck);

        foodTruck.setExit("north", home);
        foodTruck.setExit("east", conSite);
        foodTruck.setExit("west", street);

        conSite.setExit("west", foodTruck);

        street.setExit("east", foodTruck);
        street.setExit("west", beach);
        street.setExit("south", park);
        street.setExit("north", reCenter);

        beach.setExit("east", street);

        park.setExit("north", street);

        reCenter.setExit("south", street);

        currentRoom = home;
    }

    //ny metode
    public void play() {
        int finished = 1;
        while (finished == 1) {
            createRooms();
            printWelcome();
            player = new Player("Bob");
            finished = 0;
            while (finished == 0) {
                Command command = parser.getCommand();
                finished = processCommand(command);
            }
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to the World of TRASH!");
        System.out.println("World of TRASH is a new, incredibly cool trash collecting/sorting game");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    private int processCommand(Command command) {
        int wantToQuit = 0;

        CommandWord commandWord = command.getCommandWord();

        if (commandWord == CommandWord.UNKNOWN) {
            System.out.println("I don't know what you mean...");
            return 0;
        }

        if (commandWord == CommandWord.HELP) {
            printHelp();
        } else if (commandWord == CommandWord.GO) {
            goRoom(command);
        } else if (commandWord == commandWord.RESTART) {
            wantToQuit = restart(command);
        } else if (commandWord == CommandWord.QUIT) {
            wantToQuit = quit(command);
        }
        else if (commandWord == CommandWord.INSPECTITEM) {
            player.inspectItem(command);
        }
        else if (commandWord == CommandWord.PICKUP) {
            player.pickUp(command);
        }
        else if (commandWord == CommandWord.OPENINVENTORY) {
            player.openInventory(command);
        }
        else if (commandWord == CommandWord.SEARCH) {
            player.search();
        }
        else if (commandWord == CommandWord.DROP) {
            player.dropItem(command);
        }
        else if (commandWord == CommandWord.HANDBOOK) {
            handbook();
        }
        return wantToQuit;
    }

    private void printHelp() {
        System.out.println("You're a strong trendsetter, on a mission!");
        System.out.println("You're walking around the city you live in collecting TRASH!");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
        System.out.println("Important note: ");
        System.out.println("When referring to something in the room, use the name of the item.");
        System.out.println("However, if you're referring to something in your inventory, use the index of the slot it is stored in.");
    }

    private void goRoom(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        } else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }

    private int restart(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Restart what?");
            return 0;
        } else {
            return 1;
        }
    }

    private int quit(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Quit what?");
            return 0;
        } else {
            return 2;
        }
    }
    
    public static Room getCurrentRoom() {
        return currentRoom;
    }

    private void handbook (){
        if (currentRoom instanceof RecyclingCenter){
            System.out.println("Plastic---------------------------------------------------- ");
            System.out.println("Plastic trash is made out of plastic. Plastic trash could end up\n" +
                    "in landfills, it could get incinerated or get reused. \n" +
                    "Plastic trash examples:\n" +
                    "Plastic bottles, plastic cutlery, plastic toys etc.");
            System.out.println("Metal--------------------------------------------------");
            System.out.println("Trash containing Metal have to be disposed in the Metal Container.\n" +
                    "Even though a lot of energi is used to reuse metal, it still won't\n" +
                    "use as much energi as it takes to extract metal.\n" +
                    "Metal trash examples:\n" +
                    "Metal cans, metal bowls for animals, metal cutlery etc.");
            System.out.println("Harzardous Waste----------------------------------------------");
            System.out.println("Hazardous Waste can't be disposed alongside regular trash since it-\n" +
                    "might contain something harmful for either the environment or-\n" +
                    "the people handling the trash. If a product is labelled with:\n" +
                    "WARNING, CAUTION, FLAMMABLE, TOXIC, CORROSIVE or EXPLOSIVE it should\n" +
                    "be thrown out with Hazardous Waste.\n" +
                    "Hazardous Waste examples:\n" +
                    "porcelain plate , battery, deodorants, paint etc.");
            System.out.println("Residual Waste--------------------------------------------------");
            System.out.println("In Denmark Residual Waste gets burned to create electricity.\n" +
                    "Residual waste is the leftover trash after sorting out -\n" +
                    "reusable trash such as Plastic, Metal and sorting out-\n" +
                    "Hazardous Waste.\n" +
                    "Residual Waste examples:\n" +
                    "Pizzabox, diapers, vacuum bags, milk og juiceboxes etc.");
        }
        else {
            System.out.println("you're not at the Recycling Center, wait til you get there.");
        }
    }
}
