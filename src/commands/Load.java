package commands;

import jakarta.xml.bind.JAXBException;
import managers.CollectionManager;

import java.io.FileNotFoundException;
import java.util.Collection;

public class Load extends Command{

    public Load(){
        super("load", "загрузить коллекцию из файла", 0);
    }
    @Override
    public void execute() {
        try {
            CollectionManager.loadCollection();
        }
        catch (FileNotFoundException e1){
            System.out.println("Такой файл не найден. Попробуйте еще раз.");
        }
        catch (JAXBException e2){
            System.out.println("Упс... Что-то пошло не так :(");
        }
        System.out.println("Коллекция загружена.");
    }
}
