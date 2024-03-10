package managers;

import commands.Command;
import exceptions.IllegalValueException;

import java.util.Arrays;
import java.util.Scanner;

public class RuntimeManager {
    private static CommandManager commandManager;

    public static void launch() {
        System.out.println("Приветствуем Вас в приложении по управлению коллекцией! Введите \'help\' для вывода доступных команд.");
        commandManager = new CommandManager();

        while (true) {
            Scanner scanner = new Scanner(System.in);
            String request = scanner.nextLine();
            request = request.trim();
            String[] listRequest = request.split(" ");
            //здесь начинается обработка команды

            try {
                commandProcessing(listRequest, false, scanner);
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static void commandProcessing(String[] listRequest, boolean fileMode, Scanner scanner) throws IllegalValueException {
        if (commandManager.getCommandMap().containsKey(listRequest[0])) {
            Command command = commandManager.getCommandMap().get(listRequest[0]);
            if (command.isArgs() && listRequest.length>2){
                Console.print("У команды " + listRequest[0] + " должен быть только один аргумент.", false);
            }
            else if (command.isArgs()){
                try {
                    String argument = listRequest[1];
                    command.execute(argument, fileMode, scanner);
                    Console.print("-- Команда " + listRequest[0] + " выполнена --", !fileMode);
                }
                catch (ArrayIndexOutOfBoundsException e){
                    Console.print("У команды " + listRequest[0] + " должен быть аргумент.", fileMode);
                    if (fileMode) throw new ArrayIndexOutOfBoundsException("У команды " + listRequest[0] + " должен быть аргумент.");
                }
                catch (NumberFormatException e){
                    Console.print("Аргумент команды " + listRequest[0] + " должен быть числом.", fileMode);
                    if (fileMode) throw new NumberFormatException("Аргумент команды " + listRequest[0] + " должен быть числом.");
                }
                catch (Exception e){
                    Console.print(e.getMessage(), fileMode);
                    if (fileMode) throw e;
                }
            }
            else if (listRequest.length>1){
                Console.print("У команды " + listRequest[0] + " не должно быть аргументов.", fileMode);
                if (fileMode) throw new IllegalValueException("У команды " + listRequest[0] + " не должно быть аргументов.", Arrays.toString(listRequest));
            }
            else{
                try {
                    command.execute(null, fileMode, scanner);
                    Console.print("-- Команда " + listRequest[0] + " выполнена --", !fileMode);
                } catch (IllegalValueException e){
                    System.out.println(e.getMessage());
                }
            }
        }
        else {
            Console.print("Команда " + listRequest[0] + " не найдена.", fileMode);
            if (fileMode) throw new IllegalValueException("Команда " + listRequest[0] + " не найдена.", Arrays.toString(listRequest));
        }
    }
}
