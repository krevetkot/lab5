package collection;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Coordinates {
    @XmlElement(name="x")
    private Long x; //Поле не может быть null
    @XmlElement(name="y")
    private float y;
}
