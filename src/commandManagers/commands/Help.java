package commandManagers.commands;

import commandManagers.Command;
import commandManagers.CommandManager;

import java.util.Collection;

public class Help extends Command {

    public Help(){
        super("help", "вывести справку по доступным командам", 0);
    }

    @Override
    public void execute() {
        CommandManager commandManager = new CommandManager();
        //Мне дико не нравится, что тут нужно создавать новый менеджер. дичайше. как обойти не знаю
        Collection<Command> commands = commandManager.getCommandMap().values();
            System.out.println("Доступны команды:");
            for (Command command : commands) {
                System.out.println(command.getName() + ": " + command.getDescription());
            }
    }
}
