package ua.konstantynov.hw21.objects;

import lombok.ToString;
import ua.konstantynov.hw21.annotations.AutoCreate;
import ua.konstantynov.hw21.annotations.Init;
import ua.konstantynov.hw21.annotations.Multiplier;

@ToString
@AutoCreate
public class Trunk {
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