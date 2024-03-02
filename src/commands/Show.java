package commands;

import objects.Dragon;
import managers.CollectionManager;

import java.util.ArrayList;

public class Show extends Command {
    public Show(){
        super("show", "вывести в стандартный поток вывода все элементы коллекции в строковом представлении", false);
    }

    @Override
    public void execute(String argument) {
        ArrayList<Dragon> collection = CollectionManager.getCollection();
        if (collection.isEmpty()){
            System.out.println("Коллекция пуста.");
        }
        for (Dragon element: collection){
            try {
                System.out.println(element.toString());
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
