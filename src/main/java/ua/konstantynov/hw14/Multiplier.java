package ua.konstantynov.hw14;

interface Multiplier {
    <V extends Number> Number[] doubleValueIn(V[] array);
}