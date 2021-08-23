// Ход коня по шахматной доске. Вводится текущее положение коня и клетка в
// которую пробуют его передвинуть за 1 ход.
// Программа должна проверить, возможно ли это сделать
package ua.konstantynov.test1;

public class Test2 {
    public static void main(String[] args) {
        System.out.println(knightsMove("b6", "A8"));
        System.out.println(knightsMove("a9", "b7"));
        System.out.println(knightsMove("g6", "I5"));
    }

    public static boolean knightsMove(String current, String target) {
        int curNum = Integer.parseInt(current.substring(1, 2));
        int curLet = current.toLowerCase().charAt(0) - 0x60;
        int tarNum = Integer.parseInt(target.substring(1, 2));
        int tarLet = target.toLowerCase().charAt(0) - 0x60;
        int difNum = Math.abs(curNum - tarNum);
        int difLet = Math.abs(curLet - tarLet);
        return (difNum == 1 && difLet == 2 || difNum == 2 && difLet == 1) &&
                (tarNum >= 1 && tarNum <= 8 && tarLet >= 1 && tarLet <= 8) &&
                (curNum >= 1 && curNum <= 8 && curLet >= 1 && curLet <= 8);
    }

}