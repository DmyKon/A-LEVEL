package ua.konstantynov.hw21.objects;

import lombok.ToString;
import ua.konstantynov.hw21.annotations.AutoCreate;
import ua.konstantynov.hw21.annotations.Init;
import ua.konstantynov.hw21.annotations.Multiplier;

@ToString
@AutoCreate
public class Box {
    @Multiplier
    private int boxSize = 8;
    int boxPrice = 100;
    @Multiplier
    String name = "box";

    @Init
    void firstBoxMethod() {
        System.out.println("firstBoxMethod");
    }

    @Init
    void secondBoxMethod() {
        System.out.println("secondBoxMethod");
    }
}