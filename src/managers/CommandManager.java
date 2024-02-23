package managers;

import commands.*;

import java.util.LinkedHashMap;

public class CommandManager {

    private LinkedHashMap<String, Command> commandMap;

    public CommandManager(){
        commandMap = new LinkedHashMap<>();

        commandMap.put("help", new Help(this));
        commandMap.put("info", new Info());
        commandMap.put("add", new Add());
        commandMap.put("show", new Show());
        //переделать, чтобы чел сам узнавал, какие у нас есть команды йоу йоу
        //интересно это можно сделать так: узнать все названия классов в пакете коммандс ?
    }

    public LinkedHashMap<String, Command> getCommandMap(){
        return commandMap;
    }


}
