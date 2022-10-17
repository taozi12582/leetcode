package tao;

public class SiZeYunSuan {
    public static int sum(int a, int b) {
        int resY = a ^ b;
        int resJ = (a & b) << 1;
        int temp;
        while (resJ != 0) {
            temp = resY ^ resJ;
            resJ = (resY & resJ) << 1;
            resY = temp;
        }
        return resY;
    }

    public static int sub(int a, int b) {
        return sum(a, sum(~b, 1));
    }

    public static void main(String[] args) {
        System.out.println(sum(123, 431));
        System.out.println(sub(77,44));
    }
}
