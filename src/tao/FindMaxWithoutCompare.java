package tao;

public class FindMaxWithoutCompare {
    public static int getBigOne(int a, int b) {
        //可能溢出
        int diff = a - b;
        int sa = a >>> 31;
        int sb = b >>> 31;
        int signDiff = sa ^ sb;
        int sign = diff >>> 31;
        int resDiff = (1 - sa) * a + (1 - sb) * b;
        int resSame = a * (1 - sign) + b * sign;
        return (1 - signDiff) * resSame + signDiff * resDiff;
    }

    public static void main(String[] args) {
        System.out.println(getBigOne(Integer.MIN_VALUE, Integer.MAX_VALUE));
    }
}
