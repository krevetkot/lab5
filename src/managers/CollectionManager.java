package managers;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import objects.*;

import javax.xml.bind.*;

public class CollectionManager {
    private static ArrayList<Dragon> collectionOfDragons;
    private static String fileName;

    public static void loadCollection() throws FileNotFoundException, JAXBException {
        System.out.println("Пожалуйста, введите имя файла, из которого вы хотите загрузить коллекцию:");
        Scanner console = new Scanner(System.in);
        CollectionManager.setFileName(console.nextLine());
        //тут короче парсим данные из xml файлика. создаем объект дракона, засовываем туда данные
        //и добавляем этого дракона в общую коллекцию, перед этим проверив, что она существует и она одна


//        BufferedReader br = new BufferedReader(new FileReader(commandManagers.CollectionManager.fileName));
//        String body = br.lines().collect(Collectors.joining());
//        System.out.println(body);
//        StringReader reader = new StringReader(body);
//        JAXBContext context = JAXBContext.newInstance(Dragon.class);
//        Unmarshaller unmarshaller = context.createUnmarshaller();
//        Dragon dragon = (Dragon) unmarshaller.unmarshal(reader);
//        dragon.print();

        //у меня тут пока ниче не работает, так что пока без загрузки :) ну а че, пока с консоли фигачим




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
