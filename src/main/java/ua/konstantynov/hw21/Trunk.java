package ua.konstantynov.hw21;

import lombok.ToString;

@ToString
@AutoCreate
class Trunk {
    @Multiplier
    private double trunkSize = 16;
    int trunkPrice = 1000;
    @Multiplier
    String name = "trunk";

    @Init
    private void trunkMethod() {
        System.out.println("trunkMethod");
    }
}