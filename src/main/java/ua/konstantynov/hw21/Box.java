package ua.konstantynov.hw21;

import lombok.ToString;

@ToString
@AutoCreate
class Box {
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