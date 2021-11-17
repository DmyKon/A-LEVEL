package ua.konstantynov.hw29_solid.service;

import org.reflections.Reflections;
import ua.konstantynov.hw29_solid.mathematics.Mathematics;

import java.util.Set;

public class Help {
    public static void run() {
        Reflections reflections = new Reflections(Mathematics.class.getPackage().getName());
        Set<Class<? extends Mathematics>> classes = reflections.getSubTypesOf(Mathematics.class);
        System.out.println("--------help--------");
        System.out.println("Available functions:");
        for (Class<? extends Mathematics> cls : classes) {
            System.out.print("'" + cls.getSimpleName().toLowerCase() + "' ");
        }
        System.out.println("\n\nIf your value is in degrees, type 'deg' in the end\n" +
                "e.g. 'sin 30 deg' 'cos(60) deg' 'tan 10,5' 'sec(40.25)'");
        System.out.println("--------/help--------\n");
    }
}
