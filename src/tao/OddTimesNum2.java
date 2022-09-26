package tao;

public class OddTimesNum2 {
    public static void printOddTimeNum2(int[] nums) {
        int eor = 0;
        for (int cur1 : nums) {
            eor ^= cur1;
        }
        int rightOne = eor & (~eor + 1);
        int eor2 = 0;
        for (int cur2 : nums) {
            if ((cur2 & rightOne) == 0) {
                eor2 ^= cur2;
            }
        }
        int eor3 = eor2 ^ eor;
        System.out.println(eor2);
        System.out.println(eor3);
    }

    public static void findOddTimeNum(int[] arr) {
        int eor1 = 0;
        for (int p1 : arr) {
            eor1 ^= p1;
        }
        int rightOne = eor1 & (~eor1 + 1);
        int eor2 = 0;
        for (int p2 : arr) {
            if ((p2 & rightOne) == 0) {
                eor2 ^= p2;
            }
        }
        System.out.println(eor2);
        System.out.println(eor1 ^ eor2);
    }

    public static void main(String[] args) {
        int[] ints = {3, 3, 5, 5, 7, 7, 7, 8};
        findOddTimeNum(ints);
    }
}
