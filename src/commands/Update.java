package commands;

import managers.CollectionManager;
import objects.Dragon;
import objects.forms.DragonForm;

import java.util.NoSuchElementException;

public class Update extends Command{
    public Update(){
        super("update", "обновить значение элемента коллекции, id которого равен заданному", true);
    }

    @Override
    public void execute(String argument) throws NumberFormatException{
        if (CollectionManager.getCollection().isEmpty()){
            throw new NoSuchElementException("Коллекция пока что пуста");
        }

        Long id = Long.parseLong(argument);

        Dragon oldDragon = CollectionManager.getById(id);

        if (oldDragon==null){
            throw new NoSuchElementException("Нет элемента с таким ID.");
        }

        int index = CollectionManager.getCollection().indexOf(oldDragon);
        int oldID = oldDragon.getId();
        Dragon changedDragon = new DragonForm().build();
        changedDragon.setId(oldID);
        CollectionManager.getCollection().set(index, changedDragon);

        System.out.println("Элемент с ID " + id + " обновлен");
    }
}
