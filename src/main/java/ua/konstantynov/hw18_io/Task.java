package ua.konstantynov.hw18_io;

public class Task {
    public static void main(String[] args) {
        Box boxJson = new Box();
        BoxService.fillFromResources(boxJson, "Task18_Box.json");
        System.out.println(boxJson);
        Box boxXml = new Box();
        BoxService.fillFromResources(boxXml, "Task18_Box.xml");
        System.out.println(boxXml);
    }
}