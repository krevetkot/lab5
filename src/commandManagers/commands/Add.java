package commandManagers.commands;

import commandManagers.Command;

import java.util.Scanner;

public class Add extends Command {

    public Add(){
        super("add", "добавить новый элемент в коллекцию", 100);
    }
    @Override
    public void execute() {
        Scanner console = new Scanner(System.in);
        System.out.println("Введите имя дракона: ");
        do {String name = console.nextLine();}
        while (name.isEmpty());

        System.out.println("Введите координату x: ");
        String x = console.nextLine();
        System.out.println("Введите координату y: ");
        String y = console.nextLine();

    }
}
