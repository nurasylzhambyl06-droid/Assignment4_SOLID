package utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionUtils {

    public static void inspectClass(Class<?> clazz) {
        System.out.println("Class: " + clazz.getName());

        for (Field field : clazz.getDeclaredFields()) {
            System.out.println("Field: " + field.getName());
        }

        for (Method method : clazz.getDeclaredMethods()) {
            System.out.println("Method: " + method.getName());
        }

        for (Field field : clazz.getDeclaredFields()) {
            System.out.println("Field: " + field.getName());
        }

        Class<?> parent = clazz.getSuperclass();
        if (parent != null) {
            for (Field field : parent.getDeclaredFields()) {
                System.out.println("Field (inherited): " + field.getName());
            }
        }

    }
}
