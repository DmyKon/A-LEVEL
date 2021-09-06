// Исходные данные: задача 2 (ход коня по шахматной доске) из модуля 1.
// Добавить класс который будет конвертировать шахматные координаты в индексы
// Добавить класс конвертер в основной класс и использовать его
// Добавить 2 конструктора в основной класс (по умолчанию - без параметров, с классом конвертером в параметре) -
// можно использовать генерацию из идеи: right-click -> Generate.. -> Constructor
// Написать тесты на основной метод (который вызывается в методе main) основного класса, замокать класс конвертер

package ua.konstantynov.hw11.task2;

public class Knight {
    private int[] coordinate;

    public static void main(String[] args) {
        Coordinate coordinate2 = new Coordinate("B3", "D3");
        Knight knight1 = new Knight();
        knight1.setCoordinate(new int[]{1, 1, 2, 3});
        Knight knight2 = new Knight(coordinate2);
        System.out.println(knight1.knightCanMove());
        System.out.println(knight2.knightCanMove());
    }

    public void setCoordinate(int[] coordinate) {
        this.coordinate = coordinate;
    }

    public Knight() {
    }

    public Knight(Coordinate coordinate) {
        this.coordinate = coordinate.convertCoordinate();
    }

    public boolean knightCanMove() {
        if (coordinate == null) {
            return false;
        }
        int difNum = Math.abs(coordinate[1] - coordinate[3]);
        int difLet = Math.abs(coordinate[0] - coordinate[2]);
        return (difNum == 1 && difLet == 2 || difNum == 2 && difLet == 1) &&
                coordinate[3] >= 1 && coordinate[1] >= 1 && coordinate[2] >= 1 && coordinate[0] >= 1 &&
                coordinate[3] <= 8 && coordinate[1] <= 8 && coordinate[2] <= 8 && coordinate[0] <= 8;
    }

}