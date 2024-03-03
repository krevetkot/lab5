package commands;

import managers.CommandManager;
import managers.ScriptManager;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExecuteFile extends Command{
    private CommandManager commandManager;
    public ExecuteFile(CommandManager commandManager){
        super("execute_file", "считать и исполнить скрипт из указанного файла", true);
        this.commandManager = commandManager;
    }
    @Override
    public void execute(String argument) {
        try {
            ScriptManager.addFile(argument);

            BufferedReader br = ScriptManager.getBufferedReaders().getLast();
            String line;
            while((line = br.readLine()) != null){
                String[] command = line.split(" ");
                if (commandManager.getCommandMap().get(command[0]).isArgs()) {
                    commandManager.getCommandMap().get(command[0]).execute(command[1]);
                }
                else {
                    commandManager.getCommandMap().get(command[0]).execute(null);
                }
            }
            br.close();

        }
        catch(IOException e){
            System.out.println("Что-то пошло не так");
        }

    }
}
