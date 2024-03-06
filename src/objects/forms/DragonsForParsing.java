package objects.forms;

import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import objects.Dragon;

import java.util.ArrayList;

@Getter
@XmlRootElement(name = "dragons")
@XmlAccessorType(XmlAccessType.FIELD)
public class DragonsForParsing {
    @XmlElement(name="dragon", type = Dragon.class)
    private ArrayList<Dragon> collectionOfDragons;

}
