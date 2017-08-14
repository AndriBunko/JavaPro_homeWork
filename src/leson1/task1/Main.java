package leson1.task1;

import java.lang.reflect.Method;

/**
 * Created by Andrew on 10.08.2017.
 */
public class Main {
    public static void main(String[] args) {
        try {
            Task task = new Task();
            Class<?> cls = Task.class;

            Method [] methods = cls.getDeclaredMethods();
            for (Method m : methods) {
                if (m.isAnnotationPresent(Test.class)) {
                    Test an = m.getAnnotation(Test.class);
                      m.invoke(task, an.a(), an.b());
                }
            }
        }catch (Exception e){
                e.printStackTrace();
        }

    }
}
