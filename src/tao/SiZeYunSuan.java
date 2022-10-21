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

    public static int multiply(int a, int b) {
        int res = 0;
        int num = 0;
        while (b != 0) {
            if ((b & 1) != 0) {
                res = sum(res, a << num);
            }
            num++;
            b >>>= 1;
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(sum(-10, -431));
        System.out.println(sub(77, 44));
        System.out.println(multiply(12, 5));
    }
}
