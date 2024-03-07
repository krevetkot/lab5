package commands;

import managers.CollectionManager;
import objects.forms.DragonForm;

import java.util.NoSuchElementException;

public class InsertAt extends Command{
    public InsertAt(){
        super("insert_at", "добавить новый элемент в заданную позицию", true);
    }
    @Override
    public void execute(String argument) throws NoSuchElementException, NumberFormatException{

        if (CollectionManager.getCollection().isEmpty()){
            throw new NoSuchElementException("Коллекция пока что пуста");
        }

        int index = Integer.parseInt(argument);

        if (index>CollectionManager.getCollection().size()){
            throw new NoSuchElementException("Индекс должен быть меньше или равен размеру коллекции. Размер = "
                    + CollectionManager.getCollection().size());
        }

        if (index<0){
            throw new NoSuchElementException("Агрумент index должен быть больше или равен нулю.");
        }

        DragonForm newDragon = new DragonForm();
        CollectionManager.getCollection().add(index, newDragon.build());
        System.out.println("Спасибо, ваши данные приняты!");
    }
}
