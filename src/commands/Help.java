package commands;

import managers.CommandManager;

import java.util.Collection;

public class Help extends Command {
    private CommandManager commandManager;

    public Help(CommandManager commandManager){
        super("help", "вывести справку по доступным командам", 0);
        this.commandManager = commandManager;
    }

    @Override
    public void execute() {
        Collection<Command> commands = commandManager.getCommandMap().values();
            System.out.println("Доступны команды:");
            for (Command command : commands) {
                System.out.println(command.getName() + ": " + command.getDescription());
            }
    }
}
