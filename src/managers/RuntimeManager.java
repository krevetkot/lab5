package managers;

import commands.Command;
import jakarta.xml.bind.JAXBException;
import java.io.FileNotFoundException;
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
                command.execute();
            }
        }
    }
}
