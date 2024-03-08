package managers;

import commands.Command;
import exceptions.IllegalValueException;

import java.util.Scanner;

public class RuntimeManager {
    private static CommandManager commandManager;

    public static void launch() {
        System.out.println("Приветствуем Вас в приложении по управлению коллекцией! Введите \'help\' для вывода доступных команд.");
        commandManager = new CommandManager();

        while (true) {
            Scanner console = new Scanner(System.in);
            String request = console.nextLine();
            request = request.trim();
            String[] listRequest = request.split(" ");
            //здесь начинается обработка команды
            if (commandManager.getCommandMap().containsKey(listRequest[0])) {
                Command command = commandManager.getCommandMap().get(listRequest[0]);

                if (command.isArgs() && listRequest.length>2){
                    System.out.println("У этой команды должен быть только один аргумент.");
                }
                else if (command.isArgs()){
                    try {
                        String argument = listRequest[1];
                        command.execute(argument, false, console);
                    }
                    catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("Вы не ввели аргумент команды.");
                    }
                    catch (NumberFormatException e){
                        System.out.println("Аргумент должен быть числом.");
                    }
                    catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }
                else if (listRequest.length>1){
                    System.out.println("У этой команды не должно быть аргументов.");
                }
                else{
                    try {
                        command.execute(null, false, console);
                    } catch (IllegalValueException e){
                        System.out.println(e.getMessage());
                    }
                }
            }
            else {
                System.out.println("Такой команды нет!");
            }
        }
    }

    public static void commandProcessing(String[] listRequest, boolean fileMode, Console console){
        if (commandManager.getCommandMap().containsKey(listRequest[0])) {
            Command command = commandManager.getCommandMap().get(listRequest[0]);

            if (command.isArgs() && listRequest.length>2){
                System.out.println("У этой команды должен быть только один аргумент.");
            }
            else if (command.isArgs()){
                try {
                    String argument = listRequest[1];
                    command.execute(argument, fileMode, console);
                }
                catch (ArrayIndexOutOfBoundsException e){
                    System.out.println("Вы не ввели аргумент команды.");
                }
                catch (NumberFormatException e){
                    System.out.println("Аргумент должен быть числом.");
                }
                catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
            else if (listRequest.length>1){
                System.out.println("У этой команды не должно быть аргументов.");
            }
            else{
                try {
                    command.execute(null, fileMode, console);
                } catch (IllegalValueException e){
                    System.out.println(e.getMessage());
                }
            }
        }
        else {
            System.out.println("Такой команды нет!");
        }
    }
}
