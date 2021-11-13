package ua.konstantynov.hw21_annotations.objects;

import lombok.ToString;
import ua.konstantynov.hw21_annotations.annotations.AutoCreate;
import ua.konstantynov.hw21_annotations.annotations.Init;
import ua.konstantynov.hw21_annotations.annotations.Multiplier;

@ToString
@AutoCreate
public class Case {
    @Multiplier(MathOperations.ADDITION)
    private float caseSize = 500;
    int casePrice = 10000;
    @Multiplier
    String name = "case";

    @Init
    private void caseMethod() {
        System.out.println("caseMethod");
    }
}