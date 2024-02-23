package objects.forms;

import objects.Color;
import objects.Country;
import objects.Person;

public class PersonForm extends Form<Person>{

    @Override
    public Person build(){
        System.out.println("Введите данные об убийце дракона.");
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        System.out.println("Введите паспортные данные: ");
        String passportID = scanner.nextLine();
        //проверка на уникальность, если нет пшел нах заново
        Color eyeColor = (Color)askEnum(Color.values(), "цвет глаз");
        Color hairColor = (Color)askEnum(Color.values(), "цвет волос");
        Country nationality = (Country)askEnum(Country.values(), "национальность");
        return new Person(name, passportID, eyeColor, hairColor, nationality);
    }
}
