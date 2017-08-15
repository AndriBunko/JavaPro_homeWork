package leson1.task3;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Andrew on 15.08.2017.
 */
public class Runner {
    public static void main(String[] args) throws IOException, IllegalAccessException, NoSuchFieldException, InstantiationException {
        SimpleClass simpleClass = new SimpleClass(1, "name" ,true);
        String str = Serializ.serializeFild(simpleClass);
        IOWriterReader.writeToFile("src\\leson1\\task3\\io", str);
        String str2 = IOWriterReader.readFromFile("src\\leson1\\task3\\io");
        SimpleClass simpleClass1 = Serializ.deserialize(SimpleClass.class, str2);
        System.out.println(simpleClass1);
    }
}
