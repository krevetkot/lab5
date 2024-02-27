package objects.forms;

import objects.Coordinates;

public class CoordinatesForm extends Form<Coordinates>{

    @Override
    public Coordinates build() {
        System.out.println("Введите координату X: ");

        Long x = askLong("координату х", false);
        float y = askFloat("координату y");

        return new Coordinates(x, y);
    }

}
