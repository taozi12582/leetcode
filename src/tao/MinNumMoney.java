package tao;

public class MinNumMoney {
//    public static int getMin(int[] arr, int rest, int i) {
//        if (rest == 0) {
//            return 0;
//        }
//        if (i == arr.length) {
//            return Integer.MAX_VALUE;
//        }
//        if (arr[i] <= rest) {
//            return Math.min(getMin(arr, rest - arr[i], i + 1), getMin(arr, rest, i + 1));
//        }
//        return getMin(arr, rest, i + 1);
//    }

    public static int getMin(int[] arr, int rest, int i) {
        if (rest == 0) {
            return 0;
        }
        if (rest < 0) {
            return -1;
        }
        if (i == arr.length) {
            return -1;
        }
        int res1 = getMin(arr, rest - arr[i], i + 1);
        int res2 = getMin(arr, rest, i + 1);
        if (res1 == -1 && res2 == -1) {
            return -1;
        }
        if (res1 == -1) {
            return res2;
        }
        if (res2 == -1) {
            return 1 + res1;
        }
        return Math.min(res1 + 1, res2);
    }

    public static int getResult(int[] arr, int aim) {
        int[][] dp = new int[arr.length + 1][aim + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -2;
            }
        }
        return getMin2(arr, aim, 0, dp);
    }

    private static int getMin2(int[] arr, int rest, int i, int[][] dp) {
        if (rest < 0) {
            return -1;
        }
        if (dp[i][rest] != -2) {
            return dp[i][rest];
        }
        if (rest == 0) {
            dp[i][rest] = 0;
            return dp[i][rest];
        }
        if (i == arr.length) {
            dp[i][rest] = -1;
            return dp[i][rest];
        }
        int res1 = getMin(arr, rest - arr[i], i + 1);
        int res2 = getMin(arr, rest, i + 1);
        if (res1 == -1 && res2 == -1) {
            dp[i][rest] = -1;
        } else if (res1 == -1) {
            dp[i][rest] = res2;
        } else if (res2 == -1) {
            dp[i][rest] = 1 + res1;
        } else {
            dp[i][rest] = Math.min(res1 + 1, res2);
        }
        return dp[i][rest];
    }

    public static int getResultDP(int[] arr, int rest) {
        int N = arr.length;
        int[][] dp = new int[N + 1][rest + 1];
        for (int i = 0; i <= N; i++) {
            dp[i][0] = 0;
        }
        for (int j = 1; j <= rest; j++) {
            dp[N][j] = -1;
        }
        for (int i = N - 1; i >= 0; i--) {
            for (int j = 1; j <= rest; j++) {

                int res1 = -1;
                if (j - arr[i] >= 0) {
                    res1 = dp[i + 1][j - arr[i]];
                }
                int res2 = dp[i + 1][j];

                if (res1 == -1 && res2 == -1) {
                    dp[i][j] = -1;
                } else if (res1 == -1) {
                    dp[i][j] = res2;
                } else if (res2 == -1) {
                    dp[i][j] = 1 + res1;
                } else {
                    dp[i][j] = Math.min(res1 + 1, res2);
                }
            }
        }
        return dp[0][rest];
    }


    public static void main(String[] args) {
        int[] arr = {2, 3, 7, 3, 5, 3};
        System.out.println(getResultDP(arr, 9));
    }
}
