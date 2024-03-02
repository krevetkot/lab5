package commands;

import managers.CollectionManager;
import objects.forms.DragonForm;

public class Add extends Command {

    public Add(){
        super("add", "добавить новый элемент в коллекцию", false);
    }
    @Override
    public void execute(String argument) {
        DragonForm newDragon = new DragonForm();
        CollectionManager.getCollection().add(newDragon.build());
        System.out.println("Спасибо, ваши данные приняты!");
    }
}
