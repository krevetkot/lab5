import exceptions.FailedBuildingException;
import jakarta.xml.bind.JAXBException;
import managers.CollectionManager;
import managers.RuntimeManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        if (args.length == 0){
            System.out.println("Вы не указали имя файла. Запуск невозможен.");
            System.exit(1);
        }
        String filename = args[0];

        try {
            CollectionManager.loadCollection(filename);
        }
        catch (IOException | JAXBException | FailedBuildingException e){
            System.out.println(e.getMessage());
        }

        RuntimeManager.launch();

    }
}
