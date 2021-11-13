// 1. Выполнить объектно-ориентированный дизайн для планет Солнечной системы для анализа
// ускорения свободного падения на ее различных планетах.
// Создать интерфейс Planet с методом, описывающим возврат значения ускорения свободного падения на планете.
// Можно ограничиться четырьмя или пятью планетами.
// Класс Earth (к примеру) должен содержать базовую информацию о планете и методы,
// позволяющие с ней работать. Например информация есть ли атмосфера и метод,
// возвращающий boolean значение (если есть – true, нет – false)
// Выполнить имплементацию интерфейса Planet для имеющихся планет.
// Таким образом в каждом классе, представляющем планету, должен оказаться метод,
// возвращающий ускорение свободного падения и по 1-2 дополнительных метода для получения информации.
// Переопределить методы equals() и hashCode() у планет из предыдущего ДЗ

package ua.konstantynov.hw9_interface.task1;

public class Task1 {
    public static void main(String[] args) {
        Planet mercury = new Mercury();
        Planet venus = new Venus();
        System.out.println("Mercury gravity acceleration = " + mercury.getGravityAccel());
        System.out.println("Venus gravity acceleration = " + venus.getGravityAccel());
        Earth earth = new Earth();
        System.out.println(earth.isSatellite());
    }
}