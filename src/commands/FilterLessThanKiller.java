package commands;

import managers.CollectionManager;
import objects.Dragon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;

public class FilterLessThanKiller extends Command{
    public FilterLessThanKiller(){
        super("filter_less_than_killer", "вывести элементы, значение поля killer которых меньше заданного", true);
    }
    @Override
    public void execute(String argument) throws NumberFormatException, NoSuchElementException{
        if (CollectionManager.getCollection().isEmpty()){
            System.out.println("Коллекция пуста.");
        }
        else {
            Long killer = Long.parseLong(argument);

            if (killer<=0){
                throw new NoSuchElementException("Агрумент killer должен быть больше нуля.");
            }
            boolean flag = true;
            for (Dragon element: CollectionManager.getCollection()){
                if (element.getKiller().getCountKilledDragons()<killer){
                    System.out.println(element.toString());
                    flag = false;
                };
            }
            if (flag){System.out.println("Нет подходящих элементов.");}
        }
    }

}
