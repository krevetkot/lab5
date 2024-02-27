package commands;

import jakarta.xml.bind.JAXBException;
import managers.CollectionManager;

import java.io.FileNotFoundException;

public class Save extends Command{
    public Save(){
        super("save", "сохранить коллекцию в файл", 0);
    }
    @Override
    public void execute() {
        try {
            CollectionManager.saveCollection();
        }
        catch (JAXBException e2){
            System.out.println("Упс... Что-то пошло не так :(");
        }
    }
}
