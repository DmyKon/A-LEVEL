package ua.konstantynov.hw21_annotations.objects;

import lombok.ToString;
import ua.konstantynov.hw21_annotations.annotations.AutoCreate;
import ua.konstantynov.hw21_annotations.annotations.Init;
import ua.konstantynov.hw21_annotations.annotations.Multiplier;

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