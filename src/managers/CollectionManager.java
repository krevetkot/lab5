package managers;

import java.io.*;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Collectors;

import objects.*;

import jakarta.xml.bind.*;

public class CollectionManager {
    private static ArrayList<Dragon> collectionOfDragons;
    private static String fileName;

    public static void loadCollection() throws IOException, JAXBException {
        System.out.println("Пожалуйста, введите имя файла, из которого вы хотите загрузить коллекцию:");
        Scanner console = new Scanner(System.in);
        CollectionManager.setFileName(console.nextLine());

        //ПРОВЕРИТЬ, ЧТО ДРАКОН УНИКАЛЕН!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        BufferedReader br = new BufferedReader(new FileReader(CollectionManager.fileName));
        String body = br.lines().collect(Collectors.joining());
        StringReader reader = new StringReader(body);
        JAXBContext context = JAXBContext.newInstance(Dragon.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Dragon dragon = (Dragon) unmarshaller.unmarshal(reader);

        addElementToCollection(dragon);

        System.out.println("Коллекция загружена.");

        br.close();

    }

    public static void saveCollection() throws JAXBException, IOException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Dragon.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        Coordinates coord = new Coordinates(1L, 2);
        Person killer = new Person("Petya", "3294sdjas", Color.RED, Color.BLACK, Country.CHINA);
        Dragon dragon = new Dragon(1, "Vasya", coord, LocalDate.now(), 1L, 2L, true, DragonType.WATER, killer);
        File file = new File("collection.xml");
//        marshaller.marshal(dragon, new OutputStreamWriter(Files.newOutputStream(file.toPath())));

        marshaller.marshal(dragon, file);

        System.out.println("Коллекция сохранена.");

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

    public static Dragon getById(long id){
        return collectionOfDragons.stream().filter(x -> x.getId() == id).findAny().orElse(null);
    }

}
