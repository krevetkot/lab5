package objects.forms;

import managers.IDManager;
import managers.Validator;
import objects.Coordinates;
import objects.Dragon;
import objects.DragonType;
import objects.Person;

import java.time.LocalDate;

public class DragonForm extends Form<Dragon> {
    private static Dragon dragon;

    @Override
    public Dragon build() {
        System.out.println("Введите данные о драконе.");
        System.out.println("Введите имя: ");
        String name = null;
        while(true){
            name = scanner.nextLine().trim();
            if (name.isBlank()){
                System.out.println("Строка не может быть пустой! Попробуйте еще раз.");
            }
            else {
                break;
            }
        }
        //бесит меня, выделить в отдельный метод

        CoordinatesForm coordinatesForm = new CoordinatesForm();
        Coordinates coords = coordinatesForm.build();

        Long age = askLong("возраст", true);
        Long weight = askLong("вес", true);
        boolean speaking = askBoolean("умеет ли говорить дракон (true/false)");
        DragonType type = (DragonType) askEnum(DragonType.values(), "тип дракона", true);

        boolean hasKiller = askBoolean("есть ли у дракона убийца (true/false)");
        Person killer = null;
        if (hasKiller){PersonForm personForm = new PersonForm();
            killer = personForm.build();
        }

        return new Dragon(IDManager.generateID(), name, coords, LocalDate.now(), age, weight, speaking, type, killer);
    }
}
