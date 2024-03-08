package commands;

import exceptions.IllegalValueException;
import managers.CommandManager;
import managers.Console;
import managers.ScriptManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class ExecuteFile extends Command{
    private CommandManager commandManager;
    public ExecuteFile(CommandManager commandManager){
        super("execute_file", "считать и исполнить скрипт из указанного файла", true);
        this.commandManager = commandManager;
    }


    @Override
    public void execute(String argument, boolean fileMode, Scanner scanner) throws IllegalValueException {
        try {
            ScriptManager.addFile(argument);

            BufferedReader br = ScriptManager.getBufferedReaders().getLast();
            Scanner fileScanner = new Scanner(br);
            String line;

            while( (line = fileScanner.nextLine()) != null){
                String[] command = line.split(" ");
                if (commandManager.getCommandMap().containsKey(command[0])) {
                    if (commandManager.getCommandMap().get(command[0]).isArgs()) {
                        try {
                            commandManager.getCommandMap().get(command[0]).execute(command[1], true, fileScanner);
                            System.out.println("Команда " + command[0] + " выполнена.");
                        } catch (IllegalValueException e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        try {
                            commandManager.getCommandMap().get(command[0]).execute(null, true, fileScanner);
                            System.out.println("Команда " + command[0] + " выполнена.");
                        } catch (IllegalValueException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }
                else {
                    System.out.println("Команда " + command[0] + " не найдена.");
                    break;
                }
            }

            br.close();

        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        System.out.println("Выполнение скрипта завершено.");
    }
}
