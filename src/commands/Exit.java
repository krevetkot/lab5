package commands;

public class Exit extends Command{
    public Exit(){
        super("exit", "завершить программу (без сохранения в файл)", false);}

    @Override
    public void execute(String argument) {
        System.exit(0);
    }
}
