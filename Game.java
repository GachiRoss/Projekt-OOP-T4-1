//test test test
/*
hmmmmmmm
 */
public class Game
{
    // Der erklæres to variabler
    private Parser parser;
    private Room currentRoom;
        
// constructor - kører metode CreateRooms og laver et nyt objekt
    public Game() 
    {
        createRooms();
        parser = new Parser();
    }

// metode
    private void createRooms()
    {
        Room park, beach, street, conSite, foodTruck, home;
        // rum dannes som objekter
        park = new Room("outside in a nice ass park");
        beach = new Room("outside on a cool beach");
        street = new Room("out on the streets, take a knife with you >:)");
        conSite = new Room("on a wack ass construction site >:(");
        foodTruck = new Room("next to a dope ass food truck... mmmm it do be smelling good");
        home = new Room("in your nasty as hell apartment... wait was that a rat!?");

        //exits til rummene erklæres via metoden setExit
        home.setExit("south", foodTruck);

        foodTruck.setExit("north", home);
        foodTruck.setExit("east", conSite);
        foodTruck.setExit("west", street);

        conSite.setExit("west", foodTruck);

        street.setExit("east", foodTruck);
        street.setExit("west", beach);
        street.setExit("south", park);

        beach.setExit("east", street);

        park.setExit("north", street);

        currentRoom = home;
    }
//ny metode
    public void play() 
    {            
        printWelcome();

                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        if(commandWord == CommandWord.UNKNOWN) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        if (commandWord == CommandWord.HELP) {
            printHelp();
        }
        else if (commandWord == CommandWord.GO) {
            goRoom(command);
        }
        else if (commandWord == CommandWord.QUIT) {
            wantToQuit = quit(command);
        }
        return wantToQuit;
    }

    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }

    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;
        }
    }
    //handbook. Should print out text describing the game and the basic trashsorting function
    private void handbook() {
        System.out.println("The game operates with four kinds of trash: Metal, plastic, residual waste and dangerous waste");
        System.out.println("You'll get more points if you sort the trash correctly");
        System.out.println("Incorrect sorting will result in a loss of points");
        System.out.println("Metallic trash generally consists of things like cans and other metal objects");
        System.out.println("Plastic trash is a very common type of trash. Plastic bottles, bags, lids and many types of toys (Without the mechanical parts of course)");
        System.out.println("Residual waste is everything that cannot be reused. Things like kitchen waste is one of the most common types of residual waste");
        System.out.println("Dangerous waste is classified as trash dangerous to humans or nature. This includes hospital waste, ceramics, chemicals and cleaning reagents");
        parser.showCommands();
    }
}
