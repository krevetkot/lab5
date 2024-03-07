package commands;

import managers.CollectionManager;

import java.util.Collection;
import java.util.Collections;

public class Reorder extends Command{
    public Reorder(){
        super("reorder", "отсортировать коллекцию в порядке, обратном нынешнему", false);
    }

    @Override
    public void execute(String argument) {
        Collections.reverse(CollectionManager.getCollection());
        System.out.println("Коллекция отсортирована в обратном порядке.");
    }


}
