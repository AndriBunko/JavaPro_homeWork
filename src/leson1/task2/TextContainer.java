package leson1.task2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Andrew on 14.08.2017.
 */
@SaveTo(path = "src\\leson1\\task2\\file")
public class TextContainer {
    private String str;

    public TextContainer(String str) {
        this.str = str;
    }

    @Save
    public  void saveToFile(String path) throws IOException {
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path)));
        out.println(this.getStr());
        out.close();
    }

    public String getStr() {
        return str;
    }

    @Override
    public String toString() {
        return "TextContainer{" +
                "str='" + str + '\'' +
                '}';
    }
}


