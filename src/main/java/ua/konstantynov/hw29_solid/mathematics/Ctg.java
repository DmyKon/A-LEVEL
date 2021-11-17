package ua.konstantynov.hw29_solid.mathematics;

public class Ctg implements Mathematics {
    @Override
    public double calculate(double value) {
        return 1 / Math.tan(value);
    }
}
