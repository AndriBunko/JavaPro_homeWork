package leson1.task3;

import com.sun.corba.se.impl.orbutil.ObjectWriter;

import java.io.*;


/**
 * Created by Andrew on 14.08.2017.
 */
public final class IOWriterReader {

    public static void writeToFile(String path, String text) throws FileNotFoundException{
        PrintWriter out = new PrintWriter(path);
        out.println(text);
        out.close();
        }

    public static String readFromFile(String path) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(path));
        String str  = in.readLine();
        in.close();
        return str;
    }
}
