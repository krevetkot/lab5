package collection;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Person {
    @XmlElement(name="name")
    private String name; //Поле не может быть null, Строка не может быть пустой
    @XmlElement(name="passportID")
    private String passportID; //Значение этого поля должно быть уникальным, Поле может быть null
    @XmlElement(name="eyeColor")
    private Color eyeColor; //Поле не может быть null
    @XmlElement(name="hairColor")
    private Color hairColor; //Поле может быть null
    @XmlElement(name="nationality")
    private Country nationality; //Поле не может быть null

    @Override
    public String toString(){
        return this.getClass().getName() + '{'
                + ", name= \'" + this.name + '\''
                + ", pasport id=" + this.passportID
                + ", eye color=" + this.eyeColor
                + ", hair color=" + this.hairColor
                + ", nationality=" + this.nationality
                + '}';
    }
}
