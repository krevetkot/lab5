package commands;

import managers.CollectionManager;
import objects.DragonType;
import objects.forms.DragonForm;

import java.util.Scanner;

public class Add extends Command {

    public Add(){
        super("add", "добавить новый элемент в коллекцию", 100);
    }
    @Override
    public void execute() {
        DragonForm newDragon = new DragonForm();
        CollectionManager.getCollection().add(newDragon.build());
        System.out.println("Спасибо, ваши данные приняты!");
    }
}
