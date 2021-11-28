//2. Создать функциональный интерфейс Pow с методом pow(int number, int pow), который принимает 2 параметра:
// 1 - число которое возводится в степень, 2 - степень в которую возводится число.
// Реализовать этот интерфейс в методе main через лямбду (без использования сторонних пакетов типа Math).
package ua.konstantynov.hw9_interface.task2;

public class Task2 {
    public static void main(String[] args) {
        Pow power = (num, pow) -> {
            int result = 1;
            for (int i = 0; i < pow; i++) {
                result *= num;
            }
            return result;
        };
        System.out.println(power.pow(2, 5));
    }

}