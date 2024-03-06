package commands;

import managers.CollectionManager;
import objects.Dragon;

import java.util.ArrayList;
import java.util.Collections;

public class PrintFieldDescendingAge extends Command{
    public PrintFieldDescendingAge(){
        super("print_field_descending_age", "вывести значения поля age всех элементов в порядке убывания", false);}
    @Override
    public void execute(String argument) {
        if (CollectionManager.getCollection().isEmpty()){
            System.out.println("Коллекция пуста.");
        }
        else {
            ArrayList<Long> ages = new ArrayList<>();
            for (Dragon element: CollectionManager.getCollection()){
                ages.add(element.getAge());
            }
            ages.sort(Collections.reverseOrder());
            System.out.println("Возраста всех драконов в порядке убывания:");
            for (Long age: ages){
                System.out.print(age + " ");
            }
        }
    }
}
