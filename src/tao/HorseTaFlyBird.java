package tao;

public class HorseTaFlyBird {
    public static int countSteps(int a, int b, int k, int length, int width) {
        return process(0, 0, a, b, k, length, width);
    }

    private static int process(int x, int y, int a, int b, int k, int length, int width) {
        if (k == 0) {
            if (x == a && y == b) {
                return 1;
            }
            return 0;
        }
        if (x < 0 || x > width || y < 0 || y > length) {
            return 0;
        }
        return process(x - 1, y + 2, a, b, k - 1, length, width) +
                process(x + 1, y + 2, a, b, k - 1, length, width) +
                process(x + 2, y + 1, a, b, k - 1, length, width) +
                process(x + 2, y - 1, a, b, k - 1, length, width) +
                process(x + 1, y - 2, a, b, k - 1, length, width) +
                process(x - 1, y - 2, a, b, k - 1, length, width) +
                process(x - 2, y - 1, a, b, k - 1, length, width) +
                process(x - 2, y + 1, a, b, k - 1, length, width);

    }

    public static int countSteps2(int a, int b, int k, int length, int width) {
        int[][][] dp = new int[width + 1][length + 1][k + 1];
        for (int i = 0; i <= width; i++) {
            for (int j = 0; j <= length; j++) {
                if (i == a && j == b) {
                    dp[i][j][0] = 1;
                } else {
                    dp[i][j][0] = 0;
                }
            }
        }
        for (int height = 1; height <= k; height++) {
            for (int i = 0; i <= width; i++) {
                for (int j = 0; j <= length; j++) {
                    dp[i][j][height] += ifOut(i - 1, j + 2, length, width) ? 0 : dp[i - 1][j + 2][height - 1];
                    dp[i][j][height] += ifOut(i - 1, j - 2, length, width) ? 0 : dp[i - 1][j - 2][height - 1];
                    dp[i][j][height] += ifOut(i + 2, j + 1, length, width) ? 0 : dp[i + 2][j + 1][height - 1];
                    dp[i][j][height] += ifOut(i + 2, j - 1, length, width) ? 0 : dp[i + 2][j - 1][height - 1];
                    dp[i][j][height] += ifOut(i + 1, j - 2, length, width) ? 0 : dp[i + 1][j - 2][height - 1];
                    dp[i][j][height] += ifOut(i + 1, j + 2, length, width) ? 0 : dp[i + 1][j + 2][height - 1];
                    dp[i][j][height] += ifOut(i - 2, j - 1, length, width) ? 0 : dp[i - 2][j - 1][height - 1];
                    dp[i][j][height] += ifOut(i - 2, j + 1, length, width) ? 0 : dp[i - 2][j + 1][height - 1];
                }
            }
        }
        return dp[0][0][k];
    }

    public static boolean ifOut(int x, int y, int length, int width) {
        if (x < 0 || x > width || y < 0 || y > length) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(countSteps(1, 2, 5, 10, 9));
        System.out.println(countSteps2(1, 2, 5, 10, 9));
    }
}
