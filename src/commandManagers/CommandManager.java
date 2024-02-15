package commandManagers;

import commandManagers.commands.Help;

import java.util.LinkedHashMap;
import java.util.Map;

public class CommandManager {

    private LinkedHashMap<String, Command> commandMap;

    public CommandManager(){
        commandMap = new LinkedHashMap<>();

        commandMap.put("help", new Help());
    }

    public LinkedHashMap<String, Command> getCommandMap(){
        return commandMap;
    }
}
