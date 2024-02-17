package collection;
import jdk.jfr.DataAmount;

import javax.xml.bind.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Dragon")
@XmlAccessorType(XmlAccessType.FIELD)
public class Dragon {
    @XmlElement(name="id")
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    @XmlElement(name="name")
    private String name; //Поле не может быть null, Строка не может быть пустой
    @XmlElement(name="coordinates")
    private Coordinates coordinates; //Поле не может быть null
    @XmlElement(name="creationDate")
    private java.time.LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    @XmlElement(name="age")
    private Long age; //Значение поля должно быть больше 0, Поле не может быть null
    @XmlElement(name="weight")
    private Long weight; //Значение поля должно быть больше 0, Поле не может быть null
    @XmlElement(name="speaking")
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

    //щас будет метод для отладки
    public void print(){
        System.out.println(this.id + this.name);
    }
}

//ура мы сделали конструктор, мы такие молодцы