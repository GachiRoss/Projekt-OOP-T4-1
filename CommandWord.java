public enum CommandWord
{
    GO("go"), QUIT("quit"), HELP("help"), HANDBOOK("handbook"), UNKNOWN("?"), PICKUP("pick up"), DROP("drop"),MOVEX("move");
    
    private String commandString;
    
    CommandWord(String commandString)
    {
        this.commandString = commandString;
    }
    
    public String toString()
    {
        return commandString;
    }
}
