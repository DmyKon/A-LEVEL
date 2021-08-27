package ua.konstantynov.hw7.task2;

public class Aspirant extends Student {

    @Override
    public int getScholarship() {
        return averageMark == 5 ? 200 : 180;
    }

    public Aspirant(String firstName, String lastName, String group, double averageMark) {
        super(firstName, lastName, group, averageMark);
    }

    public Aspirant() {
    }

}
