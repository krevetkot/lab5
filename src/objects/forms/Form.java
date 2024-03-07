package objects.forms;

import objects.DragonType;

import java.util.Scanner;
import java.util.function.Predicate;

public abstract class Form<T> {
    protected static final Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    public abstract T build();

    public static Enum askEnum(Enum[] values, String enumName, boolean canBeNull){
        System.out.print("Введите " + enumName + ". Возможные варианты: ");
        for (Enum value: values){
            System.out.print(value + " ");
        }
        if (canBeNull){System.out.print("null(пустая строка)");}
        System.out.println();

        while (true) {
            String str = scanner.nextLine().trim();
            for (Enum value : values) {
                if (value.toString().equals(str)) {
                    return value;
                } else if (str.isEmpty()&&canBeNull) {
                    return null;
                }
            }
            System.out.println("Такого значения нет, попробуйте еще раз.");
        }
    }

    //параметр greaterthanzero означает, нужна ли нам проверка, что число больше нуля, или не нужна
    public static Long askLong(String name, Boolean greaterThanZero){
        System.out.println("Введите " + name + ":");
        Long res = null;
        while (true) {
            String str = scanner.nextLine().trim();
            try {
                res = Long.parseLong(str);
                if (greaterThanZero){
                    if (res > 0) {
                        return res;
                    }
                    System.out.println("Значение должно быть больше нуля! Попробуйте еще раз.");
                }
                else {
                    return res;
                }
//                break;
            } catch (NumberFormatException e) {
                System.out.println("Значение должно быть числом типа Long! Попробуйте еще раз.");
            }
        }

//        return res;
    }

    public static Boolean askBoolean(String name){
        System.out.println("Введите " + name + ":");
        String str = null;
        while (true) {
            str = scanner.nextLine().trim();
            if (str.equals("true") || str.equals("false")){
                return Boolean.parseBoolean(str);
            }
            System.out.println("Можно ввести только true или false! Попробуйте еще раз.");
        }
    }

    public static float askFloat(String name){
        System.out.println("Введите " + name + ":");
        while (true) {
            String str = scanner.nextLine().trim();
            float res;
            try {
                res = Float.parseFloat(str);
                return res;
            } catch (NumberFormatException e) {
                System.out.println("Значение должно быть числом типа float! Попробуйте еще раз.");
            }
        }
    }

}
