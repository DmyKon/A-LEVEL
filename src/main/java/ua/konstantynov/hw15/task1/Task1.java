//Реализовать двухсвязный список, при добавлении нового элемента он должен связаться с уже
//существующим последним элементом. Поиск с конца списка, если значение не найдено то возвращает null
package ua.konstantynov.hw15.task1;

public class Task1 {
    public static void main(String[] args) {
        MyList<Integer> myList = new MyList<>();
        for (int i = 0; i < 1000; i++) {
            myList.add(i);
        }
        System.out.println(myList.getFromLast(0));
        System.out.println(myList.getFromLast(999));
        System.out.println(myList.getFromLast(5000));
        System.out.println(myList.getFromLast(null));
    }
}