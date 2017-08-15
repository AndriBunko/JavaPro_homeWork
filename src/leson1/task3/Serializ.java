package leson1.task3;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.security.InvalidParameterException;

/**
 * Created by Anrew on 14.08.2017.
 */
public final class Serializ {

    private Serializ() {
    }

    public static String serializeFild(Object o) throws IllegalAccessException, FileNotFoundException {
        Class<?> c = o.getClass();
        StringBuilder sb = new StringBuilder();

        Field[] fields = c.getDeclaredFields();
        for (Field f : fields) {
            if (f.isAnnotationPresent(Save.class)) {
                if (Modifier.isPrivate(f.getModifiers()))
                    f.setAccessible(true);

                sb = sb.append(f.getName() + "=");

                if (f.getType() == String.class) {
                    sb.append(f.get(o));
                } else if (f.getType() == int.class) {
                    sb.append(f.getInt(o));
                } else if (f.getType() == long.class) {
                    sb.append(f.getLong(o));
                } else if (f.getType() == float.class) {
                    sb.append(f.getFloat(o));
                } else if (f.getType() == short.class) {
                    sb.append(f.getShort(o));
                } else if (f.getType() == byte.class) {
                    sb.append(f.getByte(o));
                } else if (f.getType() == char.class) {
                    sb.append(f.getChar(o));
                } else if (f.getType() == boolean.class) {
                    sb.append(f.getBoolean(o));
                } else {
                    sb.append((f.get(o)));
                }
                sb.append(";");
            }
        }
        return sb.toString();
    }

    public static  <T> T deserialize(Class<T> c, String str) throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        T obj = c.newInstance();
        String[] strs = str.split(";");

        for (String s : strs) {
            String[] pairs = s.split("=");
            if (pairs.length != 2)
                throw new InvalidParameterException();

            String name = pairs[0];
            String value = pairs[1];
            Field f = c.getDeclaredField(name);
            if (Modifier.isPrivate(f.getModifiers()))
                f.setAccessible(true);

            if (f.isAnnotationPresent(Save.class)) {
                if (f.getType() == String.class) {
                    f.set(obj, value);
                } else if (f.getType() == int.class) {
                    f.set(obj, Integer.parseInt(value));
                } else if (f.getType() == long.class) {
                    f.set(obj, Long.parseLong(value));
                } else if (f.getType() == float.class) {
                    f.set(obj, Float.parseFloat(value));
                } else if (f.getType() == short.class) {
                    f.set(obj, Short.parseShort(value));
                } else if (f.getType() == byte.class) {
                    f.set(obj, Byte.parseByte(value));
                } else if (f.getType() == char.class) {
                    f.set(obj, value);
                } else if (f.getType() == boolean.class) {
                    f.set(obj, Boolean.valueOf(value));
                }
            }
        }
        return obj;
    }

}
