package commandManagers;

import commandManagers.commands.*;

import java.util.LinkedHashMap;
import java.util.Map;

public class CommandManager {

    private LinkedHashMap<String, Command> commandMap;

    public CommandManager(){
        commandMap = new LinkedHashMap<>();

        commandMap.put("help", new Help());
        commandMap.put("info", new Info());
        //переделать, чтобы сел сам узнавал, какие у нас есть команды йоу йоу
        //интересно это можно сделать так: узнать все названия классов в пакете коммандс ?
    }

    public LinkedHashMap<String, Command> getCommandMap(){
        return commandMap;
    }
}
