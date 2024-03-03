package managers;

import commands.Command;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class RuntimeManager {
    private static CommandManager commandManager;

    public static void launch() {
        System.out.println("Приветствуем Вас в приложении по управлению коллекцией! Введите \'help\' для вывода доступных команд.");
        commandManager = new CommandManager();

//        try {
//            CollectionManager.loadCollection();
//        }
//        catch (JAXBException e1){
//            System.out.println("1111111");
//        }
//        catch (FileNotFoundException e2){
//            System.out.println("222222");
//        }
        //поменять тут на нормальные трай кэтчи


        while (true) {
            Scanner console = new Scanner(System.in);
            String request = console.nextLine();
            request = request.trim();
            String[] listRequest = request.split(" ");
            if (commandManager.getCommandMap().containsKey(listRequest[0])) {
                Command command = commandManager.getCommandMap().get(listRequest[0]);

                if (command.isArgs()){
                    try {
                        String argument = listRequest[1];
                        command.execute(argument);
                    }
                    catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("Вы не ввели аргумент команды. Попробуйте еще раз.");
                    }
                    catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }
                else{
                    command.execute(null);
                }
            }
            else {
                System.out.println("Такой команды нет! Попробуйте снова.");
            }
        }
    }

    //выделить метод для экзекьюта в рантаймменеджере
}
