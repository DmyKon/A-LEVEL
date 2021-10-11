package ua.konstantynov.hw21;

import lombok.ToString;

@ToString
@AutoCreate
class Case {
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