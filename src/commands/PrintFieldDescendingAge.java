package commands;

import managers.CollectionManager;

public class PrintFieldDescendingAge extends Command{
    public PrintFieldDescendingAge(){
        super("print_field_descending_age", "вывести значения поля age всех элементов в порядке убывания", false);}
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
