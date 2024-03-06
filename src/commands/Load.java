package commands;

import exceptions.FailedBuildingException;
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
            CollectionManager.loadCollection(argument);
        }
        catch (JAXBException | IOException | FailedBuildingException e){
            System.out.println(e.getMessage());
        }
    }
}
