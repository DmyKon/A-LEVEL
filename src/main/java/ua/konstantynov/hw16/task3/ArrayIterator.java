package ua.konstantynov.hw16.task3;

import java.util.NoSuchElementException;

class ArrayIterator<T> {
    private final T[] array;
    private int currentIndex;
    private int removeCount;

    public ArrayIterator(T[] array) {
        this.array = array;
    }

    public boolean hasNext() {
        return array.length - removeCount > currentIndex;
    }

    public T next() {
        if (array.length - removeCount <= currentIndex) {
            throw new NoSuchElementException();
        }
        return array[currentIndex++];
    }

    public void remove() {
        System.arraycopy(array, currentIndex + 1, array, currentIndex,
                array.length - removeCount - currentIndex - 1);
        array[array.length - removeCount - 1] = null;
        removeCount++;
    }
}
