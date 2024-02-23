package objects;

public enum DragonType {
    WATER("WATER"),
    UNDERGROUND("UNDERGROUND"),
    AIR("AIR"),
    FIRE("FIRE");

    private final String name;

    DragonType(String name){
        this.name = name;
    }
    @Override
    public String toString(){
        return this.name;
    }
}
