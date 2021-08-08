//2. Создать метод и вызвать его в main():
//Заданы плоские декартовы координаты треугольника.
//Найти площадь треугольника.
package ua.konstantynov.hw2;

public class Task2 {
    public static void main(String[] args) {
        double aX = 1, aY = 1;
        double bX = -2, bY = 4;
        double cX = -2, cY = -2;
        System.out.println(squareTriangle(aX, aY, bX, bY, cX, cY));
    }

    public static double squareTriangle(double aX, double aY, double bX, double bY, double cX, double cY) {
        double ab = Math.sqrt(Math.pow(aX - bX, 2) + Math.pow(aY - bY, 2));
        double bc = Math.sqrt(Math.pow(bX - cX, 2) + Math.pow(bY - cY, 2));
        double ca = Math.sqrt(Math.pow(cX - aX, 2) + Math.pow(cY - aY, 2));
        double p = (ab + bc + ca) / 2;
        return (double) Math.round(1000000 * Math.sqrt(p * (p - ab) * (p - bc) * (p - ca))) / 1000000;
    }
}
