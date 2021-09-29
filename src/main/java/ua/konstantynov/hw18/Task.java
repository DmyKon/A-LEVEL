package ua.konstantynov.hw18;

public class Task {
    public static void main(String[] args) {
        Box boxJson = new Box();
        BoxService.fillFromFile(boxJson, "Task18_Box.json");
        System.out.println(boxJson);
        Box boxXml = new Box();
        BoxService.fillFromFile(boxXml, "Task18_Box.xml");
        System.out.println(boxXml);
    }
}