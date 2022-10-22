package tao;

public class MoneyCombineNum {
    public static int getNums(int aim, int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        return process1(aim, 0, arr);
    }

    private static int process1(int rest, int i, int[] arr) {
        if (rest == 0) {
            return 1;
        }
        if (i == arr.length) {
            return 0;
        }
        int res = 0;
        for (int num = 1; rest - arr[i] * num >= 0; num++) {
            res += process1(rest - arr[i] * num, i + 1, arr);
        }
        return res + process1(rest, i + 1, arr);
    }

    public static int getNums2(int aim, int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[][] dp = new int[aim + 1][arr.length + 1];
        for (int i = 0; i <= arr.length; i++) {
            dp[0][i] = 1;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int rest = 1; rest <= aim; rest++) {
                if (rest - arr[i] >= 0) {
                    dp[rest][i] = dp[rest - arr[i]][i] + dp[rest][i + 1];
                } else {
                    dp[rest][i] = dp[rest][i + 1];
                }
            }
        }
        return dp[aim][0];
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 10, 20, 50, 100};
        System.out.println(getNums(1000, arr));
        System.out.println(getNums2(1000, arr));
    }
}
