package objects.forms;

import exceptions.IllegalValueException;
import objects.Coordinates;

import java.util.Scanner;

public class CoordinatesForm extends Form<Coordinates>{

    @Override
    public Coordinates build(Scanner scanner, boolean fileMode) throws IllegalValueException {
        Long x = askLong(scanner, fileMode, "координату х", false);
        float y = askFloat(scanner, fileMode, "координату y");

        return new Coordinates(x, y);
    }

}
