package leson1.task3;

import java.lang.reflect.Field;

/**
 * Created by Andrew on 14.08.2017.
 */
public  class IOWriter <E>{
    private final E e;

    public IOWriter(E e) {
        this.e = e;
    }

    public void writeToFile(String path){
        Class<?> clk  = e.getClass();
        Field [] fields = clk.getFields();
        for (Field f : fields){
            if (f.isAnnotationPresent(Save.class)){
                
            }
        }
    }
}
