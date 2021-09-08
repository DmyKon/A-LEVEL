package ua.konstantynov.hw11.task2;

public class Coordinate {
    private String current;
    private String target;
    private int[] coordinate;

    public void setCurrent(String current) {
        this.current = current;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public void setCoordinate(int[] coordinate) {
        this.coordinate = coordinate;
    }

    public int[] getCoordinate() {
        return coordinate;
    }

    public Coordinate() {
    }

    public Coordinate(String current, String target) {
        this.current = current;
        this.target = target;
        coordinate = convertCoordinate();
    }

    protected int[] convertCoordinate() {
        if (current.length() != 2 || target.length() != 2) {
            return null;
        }
        int[] coordinate = new int[4];
        coordinate[0] = current.toLowerCase().charAt(0) - 0x60;
        coordinate[1] = current.charAt(1) - 0x30;
        coordinate[2] = target.toLowerCase().charAt(0) - 0x60;
        coordinate[3] = target.charAt(1) - 0x30;
        return coordinate;
    }

}