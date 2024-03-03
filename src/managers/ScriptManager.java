package managers;


import lombok.Getter;

import java.io.*;
import java.util.ArrayDeque;

public class ScriptManager {

    private static final ArrayDeque<String> pathQueue = new ArrayDeque<>();

    @Getter
    private static final ArrayDeque<BufferedReader> bufferedReaders = new ArrayDeque<>();

    public static void addFile(String fileName) throws FileNotFoundException {
        pathQueue.add(new File(fileName).getAbsolutePath());
        bufferedReaders.add(new BufferedReader(new FileReader(fileName)));
    }

//добавить проверку на рекурсивность


}