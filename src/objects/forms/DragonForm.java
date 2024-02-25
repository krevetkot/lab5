package objects.forms;

import managers.GeneratorID;
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
        String name;
        while (true){
            name = scanner.nextLine();
            if (name.isBlank()){
                System.out.println("Строка не может быть null или пустой! Попробуйте снова.");
            }
            else {
                break;
            }
        }

        CoordinatesForm coordinatesForm = new CoordinatesForm();
        Coordinates coords = coordinatesForm.build();
        System.out.println("Введите возраст: ");

        Long age;
        while (true){
            age = Long.parseLong(scanner.nextLine());
            if (age==null){
                System.out.println("Возраст не может быть null! Попробуйте снова.");
            }
            else if (age<=0){
                System.out.println("Возраст должен быть больше 0! Попробуйте снова.");
            }
            else {
                break;
            }
        }

        //добавить проверку, что введено больше 0 и не нулл
        System.out.println("Введите вес: ");
        Long weight = Long.parseLong(scanner.nextLine());
        System.out.println("Введите, умеет ли говорить дракон (true/false): ");
        boolean speaking = Boolean.parseBoolean(scanner.nextLine());
        DragonType type = (DragonType)askEnum(DragonType.values(), "тип дракона");
        PersonForm personForm = new PersonForm();
        Person killer = personForm.build();
        return new Dragon(GeneratorID.generateID(), name, coords, LocalDate.now(), age, weight, speaking, type, killer);
    }
}
