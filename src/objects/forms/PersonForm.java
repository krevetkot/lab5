package objects.forms;

import managers.IDManager;
import objects.Color;
import objects.Country;
import objects.Person;

public class PersonForm extends Form<Person>{

    @Override
    public Person build(){
        System.out.println("Введите данные об убийце дракона.");
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

        System.out.println("Введите паспортные данные: ");
        String passportID = null;
        while(true){
            passportID = scanner.nextLine().trim();
            if (IDManager.passportIDisUnique(passportID)){
                break;
            }
            else{
                System.out.println("Кажется, убийца драконов с такими паспортными данными уже есть в коллекции. Пожалуйста, введите их заново.");
            }
        }

        Color eyeColor = (Color)askEnum(Color.values(), "цвет глаз", false);
        Color hairColor = (Color)askEnum(Color.values(), "цвет волос", true);
        Country nationality = (Country)askEnum(Country.values(), "национальность", false);

        long countKilledDragons = askLong("количество убитых драконов", true);

        return new Person(name, passportID, eyeColor, hairColor, nationality, countKilledDragons);
    }
}
