package ua.konstantynov.hw7.task2;

public class Aspirant extends Student {
    String scienceWork;

    @Override
    public int getScholarship() {
        return averageMark == 5 ? 200 : 180;
    }

    public Aspirant(String scienceWork, String firstName, String lastName, String group, double averageMark) {
        super(firstName, lastName, group, averageMark);
        this.scienceWork = scienceWork;
    }

    public Aspirant() {
    }

    @Override
    public String toString() {
        return "Student {Научная работа: " +
                scienceWork + ", " +
                firstName + " " +
                lastName + ", " +
                group +
                ", средняя оценка: " + averageMark +
                ", стипендия: " + getScholarship() +
                "}";
    }

}
