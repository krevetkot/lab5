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

        boolean flag = true;
        while (flag) {
            String str = scanner.nextLine();
            for (Enum value : values) {
                if (value.toString().equals(str)) {
                    flag = false;
                    return value;
                } else if (str.isEmpty()) {
                    flag = false;
                    return null;
                }
            }
            if (flag) {
                System.out.print("Такого значения нет, попробуйте еще раз.");
            }
        }
        return null;
    }
    //есть опасноть, что зациклится нафиг
}
