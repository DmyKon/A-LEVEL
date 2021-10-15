package ua.konstantynov.hw21.service;

import org.reflections.Reflections;
import ua.konstantynov.hw21.Main;
import ua.konstantynov.hw21.annotations.AutoCreate;
import ua.konstantynov.hw21.annotations.Multiplier;
import ua.konstantynov.hw21.objects.MathOperations;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AutoCreateService {
    public static Map<String, Object> search() {
        Map<String, Object> map = new HashMap<>();
        Reflections reflections = new Reflections(Main.class.getPackage().getName());
        Set<Class<?>> classes = reflections.getTypesAnnotatedWith(AutoCreate.class);
        for (Class<?> cls : classes) {
            Object object = null;
            try {
                object = cls.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
            Field[] field = cls.getDeclaredFields();
            for (Field fld : field) {
                if (fld.isAnnotationPresent(Multiplier.class)) {
                    try {
                        fld.setAccessible(true);
                        if (fld.get(object) instanceof Number) {
                            if (fld.getAnnotation(Multiplier.class).value().equals(MathOperations.ADDITION)) {
                                System.out.println(fld.getName() + " = " + fld.get(object));
                                fld.set(object, ((Number) fld.get(object)).intValue() +
                                        ((Number) fld.get(object)).intValue());
                                System.out.println(fld.getName() + "*2 = " + fld.get(object));
                            } else {
                                System.out.println(fld.getName() + " = " + fld.get(object));
                                fld.set(object, ((Number) fld.get(object)).intValue() *
                                        ((Number) fld.get(object)).intValue());
                                System.out.println(fld.getName() + "^2 = " + fld.get(object));
                            }
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
            map.put(cls.getCanonicalName(), object);
        }
        return map;
    }
}