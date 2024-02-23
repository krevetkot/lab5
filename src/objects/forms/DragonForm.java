package objects.forms;

import objects.Coordinates;
import objects.Dragon;
import objects.DragonType;
import objects.Person;

import java.time.LocalDate;

public class DragonForm extends Form<Dragon>{
    private static Dragon dragon;

    @Override
    public Dragon build(){
        System.out.println("Введите данные о драконе.");
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        CoordinatesForm coordinatesForm = new CoordinatesForm();
        Coordinates coords = coordinatesForm.build();
        System.out.println("Введите возраст: ");
        Long age = Long.parseLong(scanner.nextLine());
        //добавить проверку, что введено больше 0 и не нулл
        System.out.println("Введите вес: ");
        Long weight = Long.parseLong(scanner.nextLine());
        System.out.println("Введите, умеет ли говорить дракон (1 - умеет, 0 - не умеет): ");
        boolean speaking = Boolean.parseBoolean(scanner.nextLine());
        DragonType type = (DragonType)askEnum(DragonType.values(), "тип дракона");
        PersonForm personForm = new PersonForm();
        Person killer = personForm.build();
        return new Dragon(1111, name, coords, LocalDate.now(), age, weight, speaking, type, killer);
        //генератор айди тут должен хуярить
    }
}
