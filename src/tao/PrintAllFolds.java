package tao;

public class PrintAllFolds {
    public static void printAllFolds(int n) {
        process(1, n, true);
    }

    private static void process(int i, int n, boolean flag) {
        if (i > n) {
            return;
        }
        process(i + 1, n, true);
        System.out.println(flag ? "凹" : "凸");
        process(i + 1, n, false);
    }

    public static void main(String[] args) {
        printAllFolds(3);
    }
}
