package commands;

import managers.CollectionManager;

public class Clear extends Command{
    public Clear(){
        super("clear", "очистить коллекцию", false);}
    @Override
    public void execute(String argument) {
        if (CollectionManager.getCollection().isEmpty()){
            System.out.println("Коллекция и так пуста.");
        }
        else {
            CollectionManager.getCollection().clear();
            System.out.println("Коллекция очищена.");
        }
    }
}
