package commands;

import jakarta.xml.bind.JAXBException;
import managers.CollectionManager;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Load extends Command{

    public Load(){
        super("load", "загрузить коллекцию из файла", false);
    }
    @Override
    public void execute(String argument) {
        try {
            CollectionManager.loadCollection();
        }
        catch (FileNotFoundException e1){
            System.out.println("Такой файл не найден.");
        }
        catch (JAXBException | IOException e2){
            System.out.println("Упс... Что-то пошло не так :(");
        }
    }
}
