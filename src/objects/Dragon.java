package objects;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Dragon {
    @XmlElement(name="id")
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    @XmlElement(name="name")
    private String name; //Поле не может быть null, Строка не может быть пустой
    @XmlElement(name="coordinates")
    private Coordinates coordinates; //Поле не может быть null

    private java.time.LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически

    @XmlElement(name="creationDate")
    private String creationDateS;
    @XmlElement(name="age")
    private Long age; //Значение поля должно быть больше 0, Поле не может быть null
    @XmlElement(name="weight")
    private Long weight; //Значение поля должно быть больше 0, Поле не может быть null
    @XmlElement(name="speking")
    private boolean speaking;
    @XmlElement(name="type")
    private DragonType type; //Поле может быть null
    @XmlElement(name="killer")
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

    public Dragon(){}

    public java.time.LocalDate getCreationDate(){
        return creationDate;
    }

    @Override
    public String toString(){
        return this.getClass().getName() + '{'
                + "id= " + this.id
                + ", name= \'" + this.name + '\''
                + ", coordinates=" + this.coordinates
                + ", creation date=" + this.creationDate
                + ", age=" + this.age
                + ", weight=" + this.weight
                + ", speaking=" + this.speaking
                + ", type=" + this.type
                + ", killer=" + this.killer.toString()
                + '}';
    }

    public int getId(){
        return this.id;
    }
}