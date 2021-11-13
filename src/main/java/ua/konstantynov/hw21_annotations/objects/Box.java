package ua.konstantynov.hw21_annotations.objects;

import lombok.ToString;
import ua.konstantynov.hw21_annotations.annotations.AutoCreate;
import ua.konstantynov.hw21_annotations.annotations.Init;
import ua.konstantynov.hw21_annotations.annotations.Multiplier;

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