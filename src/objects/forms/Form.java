package objects.forms;

import objects.DragonType;

import java.util.Scanner;

public abstract class Form<T> {
    protected static final Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    public abstract T build();

    public static Enum askEnum(Enum[] values, String enumName){
        System.out.print("Введите " + enumName + ". Возможные варианты: ");
        for (Enum value: values){
            System.out.print(value + " ");
        }
        System.out.println();

        while (true) {
            String str = scanner.nextLine();
            for (Enum value : values) {
                if (value.toString().equals(str)) {
                    return value;
                } else if (str.isEmpty()) {
                    return null;
                }
            }
                System.out.println("Такого значения нет, попробуйте еще раз.");
        }
    }
    //есть опасноть, что зациклится нафиг
}
