package ua.konstantynov.hw21.objects;

import lombok.ToString;
import ua.konstantynov.hw21.annotations.AutoCreate;
import ua.konstantynov.hw21.annotations.Init;
import ua.konstantynov.hw21.annotations.Multiplier;

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