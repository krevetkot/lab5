package commandManagers.commands;

import collection.Dragon;
import commandManagers.CollectionManager;
import commandManagers.Command;

import java.util.ArrayList;

public class Show extends Command {
    public Show(){
        super("show", "вывести в стандартный поток вывода все элементы коллекции в строковом представлении", 0);
    }

    @Override
    public void execute() {
        ArrayList<Dragon> collection = CollectionManager.getCollection();
        if (collection.isEmpty()){
            System.out.println("Коллекция пуста.");
        }
        for (Dragon element: collection){
            System.out.println(element.toString());
        }
    }
}
