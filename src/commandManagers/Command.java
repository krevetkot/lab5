package commandManagers;

public abstract class Command {
    protected String name = ""; //название команды
    protected String description = ""; //описание команды
    protected int countArg; //колво аргументов

    public Command(String name, String description, int countArg){
        this.name = name;
        this.description = description;
        this.countArg = countArg;
    }

    public Command(){

    }

    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }

    public abstract void execute();
}
