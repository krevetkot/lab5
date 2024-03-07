package managers;

import java.io.*;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;

import exceptions.FailedBuildingException;
import objects.*;

import jakarta.xml.bind.*;
import objects.forms.DragonsForParsing;


public class CollectionManager {
    private static ArrayList<Dragon> collectionOfDragons;
    private static String fileName;

    public static void loadCollection(String filename) throws IOException, JAXBException, FailedBuildingException {
        CollectionManager.setFileName(filename);

        //ПРОВЕРИТЬ, ЧТО ДРАКОН УНИКАЛЕН!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        BufferedReader br = new BufferedReader(new FileReader(CollectionManager.fileName));
        String body = br.lines().collect(Collectors.joining());
        StringReader reader = new StringReader(body);
        JAXBContext context = JAXBContext.newInstance(DragonsForParsing.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        DragonsForParsing dragons = (DragonsForParsing) unmarshaller.unmarshal(reader);

        boolean flag = true;
        for (Dragon dragon: dragons.getCollectionOfDragons()){
            if (!Validator.dragonValidation(dragon)){
                flag = false;
                break;
            }
        }
        if (flag){
            collectionOfDragons = dragons.getCollectionOfDragons();
            System.out.println("Коллекция загружена.");
        }
        else {
            throw new FailedBuildingException("Данные в коллекции не валидны", Dragon.class);
        }

        br.close();

    }

    public static void saveCollection() throws JAXBException, IOException {
        DragonsForParsing dragons = new DragonsForParsing();
        dragons.setCollectionOfDragons(collectionOfDragons);

        JAXBContext jaxbContext = JAXBContext.newInstance(DragonsForParsing.class);
//        JAXBContext jaxbContext = JAXBContext.newInstance(Dragon.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

//        Coordinates coord = new Coordinates(1L, 2);
//        Person killer = new Person("Petya", "3294sdjas", Color.RED, Color.BLACK, Country.CHINA, 1L);
//        Dragon dragon = new Dragon(1, "Vasya", coord, LocalDate.now(), 1L, 2L, true, DragonType.WATER, killer);
        File file = new File(fileName);

        marshaller.marshal(dragons, new OutputStreamWriter(Files.newOutputStream(file.toPath())));

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
