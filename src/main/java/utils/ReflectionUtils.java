package utils;

import java.lang.reflect.Method;

public class ReflectionUtils {

    public static void inspectClass(Class<?> clazz) {
        System.out.println("Class: " + clazz.getName());

        for (Method method : clazz.getDeclaredMethods()) {
            System.out.println("Method: " + method.getName());
        }
    }
}
