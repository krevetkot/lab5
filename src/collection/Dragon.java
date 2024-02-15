package collection;

public class Dragon {
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Long age; //Значение поля должно быть больше 0, Поле не может быть null
    private Long weight; //Значение поля должно быть больше 0, Поле не может быть null
    private boolean speaking;
    private DragonType type; //Поле может быть null
    private Person killer; //Поле может быть null

    public Dragon(int id, String name, Coordinates coordinates, java.time.LocalDate creationDate, Long age, Long weight, boolean speaking, DragonType type, Person killer){
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.age = age;
        this.weight = weight;
        this.speaking = speaking;
        this.type = type;
        this.killer = killer;
    }
}

//ура мы сделали конструктор, мы такие молодцы