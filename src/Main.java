import commands.Command;
import managers.CollectionManager;
import managers.CommandManager;
import managers.GeneratorID;
import managers.RuntimeManager;
import objects.DragonType;

import jakarta.xml.bind.JAXBException;
import java.io.FileNotFoundException;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {
            CollectionManager.loadCollection();
        }
        catch (JAXBException e1){
            System.out.println(e1.getCause());
        }
        catch (FileNotFoundException e2){
            System.out.println("222222");
        }

//        RuntimeManager.launch();


        //весь блок выше должен лежать в экзекьюторе

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
