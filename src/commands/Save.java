package commands;

import jakarta.xml.bind.JAXBException;
import managers.CollectionManager;

import java.io.IOException;

public class Save extends Command{
    public Save(){
        super("save", "сохранить коллекцию в файл", false);
    }
    @Override
    public void execute(String argument) {
        try {
            CollectionManager.saveCollection();
        }
        catch (JAXBException | IOException e2){
            System.out.println("Упс... Что-то пошло не так :(");
        }
    }
}
