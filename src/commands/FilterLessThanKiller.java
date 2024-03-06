package commands;

public class FilterLessThanKiller extends Command{
    public FilterLessThanKiller(){
        super("filter_less_than_killer", "вывести элементы, значение поля killer которых меньше заданного", true);
    }
    @Override
    public void execute(String argument) {
        System.out.println("Пока что эта программа ничего не делает :)");
    }

}
