package ua.konstantynov.hw14_generics;

interface Multiplier {
    <V extends Number> Number[] doubleValueIn(V[] array);
}