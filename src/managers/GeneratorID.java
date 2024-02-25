package managers;

import objects.Dragon;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

public abstract class GeneratorID {

    public static int generateID(){
        ArrayList<Dragon> collection = CollectionManager.getCollection();
        boolean flag = true;

        while (true) {
            int res = (int) (Math.random() * 89999999 + 10000000);
            for (Dragon element : collection) {
                if (element.getId() == res) {
                    flag = false;
                }
            }
            if (flag) {
                return res;
            }
        }

    }

//    public static String generatePassportID(){
//        return UUID.randomUUID().toString();
//    }
}
