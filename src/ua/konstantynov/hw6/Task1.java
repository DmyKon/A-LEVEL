//а) Создайте класс Phone, который содержит переменные number, model и weight.
//б) Создайте три экземпляра этого класса.
//в) Присвоить значения полям класса.
//г) Выведите на консоль значения их переменных.
//д) Добавить в класс Phone методы:
// receiveCall, имеет один параметр – имя звонящего. Выводит на консоль сообщение “Звонит {name}”.
// getNumber – возвращает номер телефона на основании поля number объекта.
// Вызвать эти методы для каждого из объектов.
//e) Добавить конструктор в класс Phone, который принимает на вход
// три параметра для инициализации переменных класса - number, model и weight.
//ж) Добавить конструктор, который принимает на вход
// два параметра для инициализации переменных класса - number, model.
//з) Добавить конструктор без параметров.
package ua.konstantynov.hw6;

public class Task1 {
    public static void main(String[] args) {
        Phone phone1 = new Phone("+38(057) 707-16-61", "iPhone 15", "0.3 kg");
        Phone phone2 = new Phone("+38(068) 811-32-62", "iPhone 15 Note Pro Max");
        Phone phone3 = new Phone();
        phone2.weight = "0.5 kg";
        phone3.number = "+38(050) 144-37-32";
        phone3.model = "iPhone 15 Ultimate Extra Super Ultra Legend Note Pro Max";
        phone3.weight = "1 kg";
        System.out.println(phone1);
        System.out.println(phone2);
        System.out.println(phone3);
        Phone.receiveCall("телефон");
        System.out.println(phone1.getNubmer());
        System.out.println(phone2.getNubmer());
        System.out.println(phone3.getNubmer());
    }
}