import commandManagers.Command;
import commandManagers.CommandManager;
import commandManagers.commands.Help;


import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) { //убрать нафиг эти эксепшоны, сделать нормально
        CommandManager commandManager = new CommandManager();
        try {
            CollectionManager.loadCollection();
        } catch (Exception e){
            System.out.println("AAAAAAAAAAAAAAAA");
        }
        exit(0);



        while (true){
            Scanner console = new Scanner(System.in);
            String request = console.nextLine();
            request = request.trim();
            String[] listRequest = request.split(" ");
            if (commandManager.getCommandMap().containsKey(listRequest[0])){
                Command command = commandManager.getCommandMap().get(listRequest[0]);
                command.execute();
            }

            //мы должны сначала проверять, есть ли такая команда в мапе, потом узнать, сколько у нее аргументов (0, 1, много)
            //потом мы берем массив листРеквест, копируем его без первого элемента в какой-нибудь другой листЛистРеквест
            //берем из листЛистРеквест аргументы, проверяем их на валидность и только после этого ЗАПУСКАЕМ

            //коллекцию мы берем из файла xml. отдельным считывателем мы ее считываем и загружаем коллекцией
            //чето прочла про синглтон, сделать штоле тоже
            //а куда блять коллекцию то деть я не пон. ща буду разбираться

//            BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
//                String line;
//                while ((line = reader.readLine()) != null) {
//                    System.out.println(line + "\n");
//                }
        }
    }
}