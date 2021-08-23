// Task2 (4 балла)
// Создайте пример наследования, реализуйте класс Student и класс Aspirant,
// аспирант отличается от студента наличием некой научной работы.
// а) Класс Student содержит переменные: String firstName, lastName, group.
// А также, double averageMark, содержащую среднюю оценку.
// б) Создать переменную типа Student, которая ссылается на объект типа Aspirant.
// в) Создать метод getScholarship() для класса Student, который возвращает сумму стипендии.
// Если средняя оценка студента равна 5, то сумма 100 грн, иначе 80.
// Переопределить этот метод в классе Aspirant.
// Если средняя оценка аспиранта равна 5, то сумма 200 грн, иначе 180.
// г) Создать массив типа Student, содержащий объекты класса Student и Aspirant.
// Вызвать метод getScholarship() для каждого элемента массива.
package ua.konstantynov.hw7;

public class Task2 {
    public static void main(String[] args) {
        Student student1 = new Student("Иван", "Иванов", "группа А", 5);
        Student student2 = new Student("Олег", "Олегов", "группа Б", 4.5);
        Aspirant aspirant1 = new Aspirant("Сергей", "Сергеев", "группа В", 4.9);
        Aspirant aspirant2 = new Aspirant();
        aspirant2.firstName = "Ян";
        aspirant2.lastName = "Янов";
        aspirant2.group = "группа Г";
        aspirant2.averageMark = 5;
        Student[] students = {student1, student2, aspirant1, aspirant2};
        for (Student student : students) {
            System.out.println(student.firstName + " " + student.lastName + " " + student.group +
                    " cтипендия: " + student.getScholarship() + " грн.");
        }
    }

}
