// Параметрезировать интерфейс, класс, методы - работы с Object не должно быть.
package ua.konstantynov.hw14_generics;

import java.util.List;

class Util<T> implements Multiplier {
    private T type;

    public void printHashCode(T type) {
        System.out.println("HashCode: " + type.hashCode());
    }

    public void save(T type) {
        this.type = type;
    }

    public T get() {
        return type;
    }

    @Override
    public <V extends Number> Number[] doubleValueIn(V[] array) {
        Number[] result = new Number[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i].doubleValue() * array[i].doubleValue();
        }
        return result;
    }

    public <V extends Number> void sum(V one, V two) {
        System.out.println(one.doubleValue() + two.doubleValue());
    }

    public double sumOfArray(List<? extends Number> list) {
        double s = 0.0;
        for (Number n : list) {
            s += n.doubleValue();
        }
        return s;
    }

    public void addNumbers(List<? super Integer> list) {
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
    }
}