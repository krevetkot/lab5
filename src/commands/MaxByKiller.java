package commands;

public class MaxByKiller extends Command{
    public MaxByKiller(){
        super("max_by_killer", "вывести любой объект из коллекции, значение поля killer которого является максимальным", false);
    }

    @Override
    public void execute(String argument) {
        System.out.println("Пока что эта программа ничего не делает :)");
    }
}
