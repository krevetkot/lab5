import java.io.FileNotFoundException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.stream.Collectors;

import collection.*;

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


        BufferedReader br = new BufferedReader(new FileReader(CollectionManager.fileName));
        String body = br.lines().collect(Collectors.joining());
        System.out.println(body);
        StringReader reader = new StringReader(body);
        JAXBContext context = JAXBContext.newInstance(Dragon.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Dragon dragon = (Dragon) unmarshaller.unmarshal(reader);
        dragon.print();


    }

    public static void setFileName(String fileName) {
        CollectionManager.fileName = fileName;
    }
}
