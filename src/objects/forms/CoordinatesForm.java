package objects.forms;

import objects.Coordinates;

public class CoordinatesForm extends Form<Coordinates>{

    @Override
    public Coordinates build() {
        System.out.println("Введите координату X: ");
        Long x = Long.parseLong(scanner.nextLine());
        //не нулл
        System.out.println("Введите координату Y: ");
        float y = Integer.parseInt(scanner.nextLine());
        return new Coordinates(x, y);
    }

}
