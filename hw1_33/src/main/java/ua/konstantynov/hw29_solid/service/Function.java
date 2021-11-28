package ua.konstantynov.hw29_solid.service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Function {
    public static Double calculate(double value, String className) {
        try {
            Class<?> cls;
            Method method;
            className = className.substring(0, 1).toUpperCase() + className.substring(1);
            cls = Class.forName("ua.konstantynov.hw29_solid.mathematics." + className);
            method = cls.getDeclaredMethod("calculate", double.class);
            return (double) method.invoke(cls.newInstance(), value);
        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException |
                InstantiationException | IllegalAccessException e) {
            System.out.println("!!!!! Error: Incorrect function !!!!!");
            return null;
        }
    }
}
