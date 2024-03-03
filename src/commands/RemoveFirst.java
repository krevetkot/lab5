package commands;

import managers.CollectionManager;

public class RemoveFirst extends Command{
    public RemoveFirst(){
        super("remove_first", "удалить первый элемент из коллекции", false);}
    @Override
    public void execute(String argument) {
        if (CollectionManager.getCollection().isEmpty()){
            System.out.println("Коллекция пуста.");
        }
        else {
            CollectionManager.getCollection().removeFirst();
            System.out.println("Первый элемент в коллекции удален.");
        }
    }
}
