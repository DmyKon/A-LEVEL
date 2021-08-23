package ua.konstantynov.hw6;

class Phone {
    String number;
    String model;
    String weight;

    public String getNubmer() {
        return number;
    }

    public static void receiveCall(String name) {
        System.out.println("Звонит {" + name + "}");
    }

    public Phone(String number, String model, String weight) {
        this.number = number;
        this.model = model;
        this.weight = weight;
    }

    public Phone(String number, String model) {
        this.number = number;
        this.model = model;
    }

    public Phone() {
    }

    @Override
    public String toString() {
        return "Phone {" +
                "number= " + number +
                ", model= " + model +
                ", weight= " + weight +
                '}';
    }
}