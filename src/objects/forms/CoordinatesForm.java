package objects.forms;

import objects.Coordinates;

public class CoordinatesForm extends Form<Coordinates>{

    @Override
    public Coordinates build() {
        System.out.println("Введите координату X: ");
        Long x;
        while (true){
            x = Long.parseLong(scanner.nextLine());
            if (x==null ){
                System.out.println("Координата Х не может быть null! Попробуйте снова.");
            }
            else {
                break;
            }
        }

        System.out.println("Введите координату Y: ");
        float y = Integer.parseInt(scanner.nextLine());
        return new Coordinates(x, y);
    }

}
