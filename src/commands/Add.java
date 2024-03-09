package commands;

import exceptions.IllegalValueException;
import managers.CollectionManager;
import managers.Console;
import objects.forms.DragonForm;

import java.util.Collections;
import java.util.Scanner;

public class Add extends Command {

    public Add(){
        super("add", "добавить новый элемент в коллекцию", false);
    }
    @Override
    public void execute(String argument, boolean fileMode, Scanner scanner) throws IllegalValueException {
        DragonForm newDragon = new DragonForm();
        CollectionManager.getCollection().add(newDragon.build(scanner, fileMode));
        Collections.sort(CollectionManager.getCollection());
        Console.print("Спасибо, ваши данные приняты!", fileMode);
    }
}
