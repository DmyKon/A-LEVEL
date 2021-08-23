package ua.konstantynov.hw7;

public class Student {
    String firstName;
    String lastName;
    String group;
    double averageMark;

    public Student(String firstName, String lastName, String group, double averageMark) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
        this.averageMark = averageMark;
    }

    public Student() {
    }

    public int getScholarship() {
        return averageMark == 5 ? 100 : 80;
    }

    @Override
    public String toString() {
        return "Student {" +
                firstName + " " +
                lastName + ", " +
                group +
                ", средняя оценка: " + averageMark +
                ", стипендия: " + getScholarship() +
                "}";
    }

}
