package leson1.task2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Andrew on 14.08.2017.
 */
@Target(value= ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Save {
}
