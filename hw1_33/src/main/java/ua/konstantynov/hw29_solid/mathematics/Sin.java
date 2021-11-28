package ua.konstantynov.hw29_solid.mathematics;

public class Sin implements Mathematics {
    @Override
    public double calculate(double value) {
        return Math.sin(value);
    }
}
