package tao;

public class Is24Mi {
    public static boolean is2Mi(int num) {
       /* if (num <= 0) {
            return false;
        }
        int rightOne = (num & (~num + 1));
        if (num - rightOne != 0) {
            return false;
        }*/
        return (num & (num - 1)) == 0;
    }

    public static boolean is4Mi(int num) {
        /*if (num <= 0) {
            return false;
        }
        int rightOne = (num & (~num + 1));
        int i = 0;
        while (rightOne != 1) {
            rightOne = rightOne >> 1;
            i++;
        }
        return i % 2 == 0;*/
        return (num & (num - 1)) == 0 && (num & 0x55555555) != 0;
    }

    public static void main(String[] args) {
        System.out.println(is4Mi(4));
    }
}
