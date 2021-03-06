// Task3 (4 балла)
// Создайте класс, который описывает вектор (в трёхмерном пространстве).
// У него должны быть:
// а) конструктор с параметрами в виде списка координат x, y, z
// б) метод, вычисляющий длину вектора. Корень можно посчитать с помощью Math.sqrt():
// в) метод, вычисляющий векторное произведение с другим вектором
// г) метод, вычисляющий косинус угла между векторами:
// косинус угла между векторами равен скалярному произведению векторов,
// деленному на произведение модулей (длин) векторов:
// д) методы для суммы и разности векторов
// е) статический метод, который принимает целое число N, и возвращает массив случайных векторов размером N.
// *Если метод возвращает вектор, то он должен возвращать новый объект, а не менять базовый
package ua.konstantynov.hw7_inheritance.task3;

public class Task3 {
    public static void main(String[] args) {
        Vector vector1 = new Vector(3, -2, -1, 2, 5, 6);
        Vector vector2 = new Vector(2, 3, 4);
        Vector vector3 = Vector.random();
        System.out.println("vector1 length = " + vector1.length());
        System.out.println("vector2 length = " + vector2.length());
        System.out.println("vector3 length = " + vector3.length());
        System.out.println("vector1 x vector2 = " + vector1.crossProduct(vector2));
        System.out.println("vector1 + vector2 = " + vector1.addVectors(vector2));
        System.out.println("vector1 - vector2 = " + vector1.divideVectors(vector2));
        System.out.println("cos φ = " + vector1.cosFi(vector2));
        Vector[] array = Vector.randomArray(3);
        for (int i = 0; i < array.length; i++) {
            System.out.println("vector[" + i + "] = " + array[i]);
        }
    }

}