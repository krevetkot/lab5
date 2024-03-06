package commands;

public class Reorder extends Command{
    public Reorder(){
        super("reorder", "отсортировать коллекцию в порядке, обратном нынешнему", false);
    }

    @Override
    public void execute(String argument) {
        System.out.println("Пока что эта программа ничего не делает :)");
    }


}
