package ua.konstantynov.hw16.task4;

class Student {
    private String name;
    private char group;
    private int course;
    private int mathGrade;
    private int physicsGrade;
    private int biologicalGrade;
    private int historyGrade;

    public Student() {
    }

    public Student(String name, char group, int course, int mathGrade, int physicsGrade,
                   int biologicalGrade, int historyGrade) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.mathGrade = mathGrade;
        this.physicsGrade = physicsGrade;
        this.biologicalGrade = biologicalGrade;
        this.historyGrade = historyGrade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGroup() {
        return group;
    }

    public void setGroup(char group) {
        this.group = group;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public int getMathGrade() {
        return mathGrade;
    }

    public void setMathGrade(int mathGrade) {
        this.mathGrade = mathGrade;
    }

    public int getPhysicsGrade() {
        return physicsGrade;
    }

    public void setPhysicsGrade(int physicsGrade) {
        this.physicsGrade = physicsGrade;
    }

    public int getBiologicalGrade() {
        return biologicalGrade;
    }

    public void setBiologicalGrade(int biologicalGrade) {
        this.biologicalGrade = biologicalGrade;
    }

    public int getHistoryGrade() {
        return historyGrade;
    }

    public void setHistoryGrade(int historyGrade) {
        this.historyGrade = historyGrade;
    }
}
