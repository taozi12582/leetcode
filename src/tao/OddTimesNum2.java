package tao;

public class OddTimesNum2 {
    public static void printOddTimeNum2(int[] nums){
        int eor = 0;
        for(int cur1 : nums){
            eor ^= cur1;
        }
        int rightOne = eor & (~eor + 1);
        int eor2 = 0;
        for(int cur2:nums){
            if((cur2 & rightOne) == 0){
                eor2 ^= cur2;
            }
        }
        int eor3 = eor2 ^ eor;
        System.out.println(eor2);
        System.out.println(eor3);
    }
}
