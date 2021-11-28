//4. Создать класс Student, содержащий следующие характеристики – имя, группа, курс(1-6),
// оценки(1-5) по предметам.
// Создать коллекцию, содержащую объекты класса Student.
//   1. Написать метод, который удаляет студентов со средним баллом <3.
//   2. Если средний балл>=3, студент переводится на следующий курс.
//   3. Напишите метод printStudents(List<Student> students, int course),
//   который получает список студентов и номер курса.
//   А также печатает на консоль имена тех студентов из списка, которые обучаются на данном курсе.
package ua.konstantynov.hw16_collections.task4;

import java.util.ArrayList;
import java.util.List;

public class Task4 {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        StudentService.fillListByRandomStudents(students, 50);
        StudentService.printStudents(students, 5);
        StudentService.setLocateOfStudents(students);
    }
}