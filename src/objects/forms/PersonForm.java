package objects.forms;

import exceptions.IllegalValueException;
import managers.Console;
import managers.IDManager;
import objects.Color;
import objects.Country;
import objects.Person;

import java.util.Scanner;

public class PersonForm extends Form<Person>{

    //fileMode true, когда мы работаем с консольным вводом
    //fileMode false, когда мы работаем с файловым вводом
    @Override
    public Person build(Scanner scanner, boolean fileMode) throws IllegalValueException {
        Console.print("Введите данные об убийце дракона.", fileMode);

        String name = askString(scanner, fileMode, "имя", false);
        
        String passportID = null;
        while(true){
            passportID = askString(scanner, fileMode, "паспортные данные", true);
            if (IDManager.passportIDisUnique(passportID)){
                break;
            }
            else{
                if (fileMode){
                    throw new IllegalValueException("Введено недопустимое значение.", passportID);
                }
                Console.print("Кажется, убийца драконов с такими паспортными данными уже есть в коллекции. " +
                        "Пожалуйста, введите их заново.", fileMode);
            }
        }
        
        Color eyeColor = (Color)askEnum(scanner, fileMode, Color.values(), "цвет глаз", false);
        Color hairColor = (Color)askEnum(scanner, fileMode, Color.values(), "цвет волос", true);
        Country nationality = (Country)askEnum(scanner, fileMode, Country.values(), "национальность", false);

        long countKilledDragons = askLong(scanner, fileMode,"количество убитых драконов", true);

        return new Person(name, passportID, eyeColor, hairColor, nationality, countKilledDragons);
    }
}
