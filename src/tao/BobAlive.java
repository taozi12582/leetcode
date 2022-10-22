package tao;

public class BobAlive {
    public static double aliveP(int a, int b, int k, int row, int col) {
        if (a < 0 || a >= col || b < 0 || b >= row) {
            return 0;
        }
        return (double) KAlive(a, b, k, row, col) / (double) KNum(a, b, k, row, col);
    }

    private static int KAlive(int x, int y, int k, int row, int col) {
        if (x < 0 || x > col || y < 0 || y > row) {
            return 0;
        }
        if (k == 0) {
            return 1;
        }
        return KAlive(x - 1, y, k - 1, row, col) +
                KAlive(x, y + 1, k - 1, row, col) +
                KAlive(x + 1, y, k - 1, row, col) +
                KAlive(x, y - 1, k - 1, row, col);
    }

    private static int KNum(int x, int y, int k, int row, int col) {
        if (k == 0) {
            return 1;
        }
        return 4 * KNum(x - 1, y, k - 1, row, col);
//                KNum(x, y + 1, k - 1, row, col) +
//                KNum(x + 1, y, k - 1, row, col) +
//                KNum(x, y - 1, k - 1, row, col);
    }

    public static void main(String[] args) {
        System.out.println(KAlive(1, 1, 2, 2, 2));
        System.out.println(KNum(1, 1, 2, 2, 2));
        System.out.println(aliveP(1, 1, 2, 2, 2));
        System.out.println(aliveP2(1, 1, 2, 2, 2));
    }

    public static double aliveP2(int a, int b, int k, int row, int col) {
        if (a < 0 || a > col || b < 0 || b > row) {
            return 0;
        }
        double kNum = Math.pow(4, k);
        int[][][] dp = new int[col + 1][row + 1][k+1];
        for (int i = 0; i <= col; i++) {
            for (int j = 0; j <= row; j++) {
                dp[i][j][0] = 1;
            }
        }
        for (int h = 1; h <= k; h++) {
            for (int i = 0; i <= col; i++) {
                for (int j = 0; j <= row; j++) {
                    dp[i][j][h] += ifOut(i - 1, j, col, row) ? 0 : dp[i - 1][j][h - 1];
                    dp[i][j][h] += ifOut(i, j + 1, col, row) ? 0 : dp[i][j + 1][h - 1];
                    dp[i][j][h] += ifOut(i + 1, j, col, row) ? 0 : dp[i + 1][j][h - 1];
                    dp[i][j][h] += ifOut(i, j - 1, col, row) ? 0 : dp[i][j - 1][h - 1];
                }
            }
        }
        return dp[a][b][k] / kNum;
    }

    private static boolean ifOut(int x, int y, int col, int row) {
        if (x < 0 || x > col || y < 0 || y > row) {
            return true;
        }
        return false;
    }
}
