package tao;

public class Hanoi {
    public static void hanoi(String start, String end, String other, int i) {
        if (i == 1) {
            System.out.println("move 1 from " + start + " to " + end);
            return;
        }
        hanoi(start, other, end, i - 1);
        System.out.println("move " + i + " from " + start + " to " + end);
        hanoi(other, end, start, i - 1);
    }

    public static void main(String[] args) {
        hanoi("左", "中", "右", 3);
    }
}
