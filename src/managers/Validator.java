package managers;

import objects.Coordinates;
import objects.Dragon;
import objects.Person;

public class Validator {
    public static boolean dragonValidation(Dragon dragon){
        return !dragon.getName().isBlank() && dragon.getCoordinates() != null
                && dragon.getAge() != null
                && dragon.getWeight() != null;
    }

    public static boolean personValidation(Person person){
        return !person.getName().isBlank() && person.getEyeColor() != null
                && person.getNationality() != null;
    }

    public static boolean coordValidation(Coordinates coords){
        return coords.getX() != null;
    }


}
