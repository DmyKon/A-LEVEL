package ua.konstantynov.hw16.task4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class StudentService {
    static void setLocateOfStudents(List<Student> list) {
        List<Student> toDelete = new ArrayList<>();
        StringBuilder expelled = new StringBuilder();
        for (Student student : list) {
            double averageMark = (student.getBiologicalGrade() + student.getHistoryGrade() +
                    student.getMathGrade() + student.getPhysicsGrade()) / 4d;
            if (averageMark < 3) {
                expelled.append("\n").append(student.getName()).append(", группа ")
                        .append(student.getGroup()).append(", ")
                        .append(student.getCourse()).append(" курс - отчислен");
                toDelete.add(student);
            } else {
                student.setCourse(student.getCourse() + 1);
                if (student.getCourse() > 6) {
                    expelled.append("\n").append(student.getName()).append(" - окончил обучение");
                    toDelete.add(student);
                }
            }
        }
        for (Student student : toDelete) {
            list.remove(student);
        }
        System.out.println(expelled);
    }

    static void printStudents(List<Student> list, int course) {
        System.out.println("Список учащихся на " + course + " курсе: ");
        int count = 1;
        for (Student student : list) {
            if (student.getCourse() == course) {
                System.out.println(count + ") " + student.getName() + " ");
                count++;
            }
        }
    }

    static void fillListByRandomStudents(List<Student> list, int count) {
        String[] names = ("Даниил Максим Владислав Никита Артем Иван Кирилл Егор " +
                "Илья Андрей Алексей Богдан Денис Дмитрий Ярослав ").split(" ");
        String[] surnames = ("Смирнов Иванов Кузнецов Соколов Попов Лебедев " +
                "Козлов Новиков Морозов Петров Волков Соловьёв Васильев Зайцев " +
                "Павлов Семёнов Голубев Виноградов Богданов Воробьёв Фёдоров Михайлов " +
                "Беляев Тарасов Белов Комаров Орлов Киселёв Макаров Андреев").split(" ");
        for (int i = 0; i < count; i++) {
            list.add(new Student(names[ThreadLocalRandom.current().nextInt(names.length)] + " " +
                    surnames[ThreadLocalRandom.current().nextInt(surnames.length)],
                    (char) (ThreadLocalRandom.current().nextInt(3) + 0x41),
                    ThreadLocalRandom.current().nextInt(6) + 1,
                    ThreadLocalRandom.current().nextInt(5) + 1,
                    ThreadLocalRandom.current().nextInt(5) + 1,
                    ThreadLocalRandom.current().nextInt(5) + 1,
                    ThreadLocalRandom.current().nextInt(5) + 1));
        }
    }
}