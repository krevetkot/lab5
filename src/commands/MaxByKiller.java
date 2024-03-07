package commands;

import managers.CollectionManager;
import objects.Dragon;

import java.util.ArrayList;
import java.util.Collections;

public class MaxByKiller extends Command{
    public MaxByKiller(){
        super("max_by_killer", "вывести любой объект из коллекции, значение поля killer которого является максимальным", false);
    }

    @Override
    public void execute(String argument) {
        if (CollectionManager.getCollection().isEmpty()){
            System.out.println("Коллекция пуста.");
        }
        else {
            ArrayList<Dragon> dragons = CollectionManager.getCollection();
            Collections.sort(dragons);
            System.out.println(dragons.getLast().toString());
        }
    }
}
