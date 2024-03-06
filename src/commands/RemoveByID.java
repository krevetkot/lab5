package commands;

import managers.CollectionManager;
import objects.Dragon;
import objects.forms.DragonForm;

import java.util.NoSuchElementException;

public class RemoveByID extends Command{
    public RemoveByID(){
        super("remove_by_id", "удалить элемент из коллекции по его id", true);}

    @Override
    public void execute(String argument) throws NoSuchElementException, NumberFormatException{
        if (CollectionManager.getCollection().isEmpty()){
            throw new NoSuchElementException("Коллекция пока что пуста");
        }

        Long id = Long.parseLong(argument);
        Dragon oldDragon = CollectionManager.getById(id);

        if (oldDragon==null){
            throw new NoSuchElementException("Нет элемента с таким ID.");
        }

        if (CollectionManager.getCollection().remove(oldDragon)){
            System.out.println("Элемент с ID " + id + " удален");
        }
        else {
            System.out.println("Элемент с ID " + id + " не удален");
        }

    }

}
