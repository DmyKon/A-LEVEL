// Ход коня по шахматной доске. Вводится текущее положение коня и клетка в
// которую пробуют его передвинуть за 1 ход.
// Программа должна проверить, возможно ли это сделать
package ua.konstantynov.test1;

public class Test2 {
    public static void main(String[] args) {
        System.out.println(knightsMove("b6", "A8"));
        System.out.println(knightsMove("a9", "b7"));
        System.out.println(knightsMove("g6", "I5"));
        System.out.println(knightsMove("", ""));
        System.out.println(knightsMove("54321", "edcba"));
    }

    public static boolean knightsMove(String current, String target) {
        if (current.length() != 2 || target.length() != 2) {
            return false;
        }
        int curNum = current.charAt(1) - 0x30;
        int tarNum = target.charAt(1) - 0x30;
        int curLet = current.toLowerCase().charAt(0) - 0x60;
        int tarLet = target.toLowerCase().charAt(0) - 0x60;
        int difNum = Math.abs(curNum - tarNum);
        int difLet = Math.abs(curLet - tarLet);
        return (difNum == 1 && difLet == 2 || difNum == 2 && difLet == 1) &&
                tarNum >= 1 && curNum >= 1 && tarLet >= 1 && curLet >= 1 &&
                tarNum <= 8 && curNum <= 8 && tarLet <= 8 && curLet <= 8;
    }

}