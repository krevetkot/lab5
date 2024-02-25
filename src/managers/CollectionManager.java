package managers;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

import objects.*;

import jakarta.xml.bind.*;

public class CollectionManager {
    private static ArrayList<Dragon> collectionOfDragons;
    private static String fileName;

    public static void loadCollection() throws FileNotFoundException, JAXBException {
        System.out.println("Пожалуйста, введите имя файла, из которого вы хотите загрузить коллекцию:");
        Scanner console = new Scanner(System.in);
        CollectionManager.setFileName(console.nextLine());
        //тут короче парсим данные из xml файлика. создаем объект дракона, засовываем туда данные
        //и добавляем этого дракона в общую коллекцию, перед этим проверив, что она существует и она одна

        BufferedReader br = new BufferedReader(new FileReader(CollectionManager.fileName));
        String body = br.lines().collect(Collectors.joining());
        StringReader reader = new StringReader(body);
        JAXBContext context = JAXBContext.newInstance(Dragon.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Dragon dragon = (Dragon) unmarshaller.unmarshal(reader);
        System.out.println(dragon.toString());

    }

    public static void saveCollection() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Dragon.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        Coordinates coord = new Coordinates(1L, 2);
        Person killer = new Person("Petya", "3294sdjas", Color.RED, Color.BLACK, Country.CHINA);
        Dragon dragon = new Dragon(1, "Vasya", coord, LocalDate.now(), 1L, 2L, true, DragonType.WATER, killer);
        File file = new File("collection.xml");
        marshaller.marshal(dragon, file);
    }

    public static void setFileName(String fileName) {
        CollectionManager.fileName = fileName;
    }

    public static ArrayList<Dragon> getCollection(){
        if (collectionOfDragons==null){
            collectionOfDragons = new ArrayList<Dragon>();
        }
        return collectionOfDragons;
    }

    public static void addElementToCollection(Dragon value){
        getCollection().add(value);
    }
}
