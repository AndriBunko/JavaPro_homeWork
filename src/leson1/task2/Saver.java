package leson1.task2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Andrew on 14.08.2017.
 */
public class Saver {
    public static void main(String[] args) {
        TextContainer tc = new TextContainer("Java!!!");
        Class<?> cls = TextContainer.class;
        if (cls.isAnnotationPresent(SaveTo.class)){
            SaveTo an  = cls.getAnnotation(SaveTo.class);

            Method[] methods = cls.getMethods();
            for (Method m : methods) {
                if (m.isAnnotationPresent(Save.class)) {
                    try {
                        m.invoke(tc, an.path());
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
