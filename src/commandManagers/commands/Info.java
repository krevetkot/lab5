package commandManagers.commands;

import collection.Dragon;
import commandManagers.*;


import java.util.ArrayList;
import java.util.Collection;

public class Info extends Command {

    public Info(){
        super("info", "вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)", 0);
    }

    @Override
    public void execute() {
        if (CollectionManager.getCollection().isEmpty()){
            System.out.println("Коллекция пока что пуста. Тип коллекции: Dragon. Количество элементов: 0");
        }
        else {
            System.out.println("Тип коллекции: Dragon. Количество элементов" + CollectionManager.getCollection().size() + " дата инициализации: " + CollectionManager.getCollection().getFirst().getCreationDate());
        }
    }
}
