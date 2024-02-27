import managers.RuntimeManager;

public class Main {
    public static void main(String[] args) {

//        try {
//            CollectionManager.loadCollection();
//        }
//        catch (JAXBException e1){
//            System.out.println(e1.getCause());
//        }
//        catch (FileNotFoundException e2){
//            System.out.println("222222");
//        }

        RuntimeManager.launch();


        //весь блок выше должен лежать в экзекьюторе

        //мы должны сначала проверять, есть ли такая команда в мапе, потом узнать, сколько у нее аргументов (0, 1, много)
        //потом мы берем массив листРеквест, копируем его без первого элемента в какой-нибудь другой листЛистРеквест
        //берем из листЛистРеквест аргументы, проверяем их на валидность и только после этого ЗАПУСКАЕМ

    }
}
