// Please implement an application which is able to calculate
// trigonometric functions (sin, cos, tan, ctg, arcsin, arccos) using SOLID.
package ua.konstantynov.hw29_solid;

import ua.konstantynov.hw29_solid.service.Function;
import ua.konstantynov.hw29_solid.service.Help;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("<<< Trigonometric functions calculator >>>");
        System.out.println("Type 'help' for help\nType 'exit' for exit\n");
        while (true) {
            System.out.println("Enter function:");
            String input = new Scanner(System.in).nextLine().toLowerCase().trim()
                    .replaceAll("[^ .,0-9a-zA-Z]", " ")
                    .replaceAll(",", ".")
                    .replaceAll(" +", " ");
            if (input.trim().equals("exit")) {
                break;
            }
            if (input.trim().equals("help")) {
                Help.run();
                continue;
            }
            if (!input.contains(" ")) {
                System.out.println("!!!!! Error: no value !!!!!");
                continue;
            }
            String className = input.split(" ")[0];
            String valueAsString = input.split(" ")[1];
            double value;
            try {
                value = input.endsWith("deg") ?
                        Math.toRadians(Double.parseDouble(valueAsString)) : Double.parseDouble(valueAsString);
            } catch (NumberFormatException e) {
                System.out.println("!!!!! Error: Incorrect value !!!!!");
                continue;
            }
            Double result = Function.calculate(value, className);
            System.out.printf("%.9f\n", result);
        }
    }
}