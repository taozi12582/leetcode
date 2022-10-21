package tao;

public class RobotWalk {
    public static int f(int N, int E, int rest, int cur) {
        if (rest == 0) {
            return cur == E ? 1 : 0;
        }
        if (cur == 1) {
            return f(N, E, rest - 1, 2);
        }
        if (cur == N) {
            return f(N, E, rest - 1, N - 1);
        }
        return f(N, E, rest - 1, cur + 1) + f(N, E, rest - 1, cur - 1);
    }

    public static int f2(int N, int E, int rest, int cur, int[][] dp) {
        if (dp[rest][cur] != -1) {
            return dp[rest][cur];
        }
        if (rest == 0) {
            dp[rest][cur] = cur == E ? 1 : 0;
            return dp[rest][cur];
        }
        if (cur == 1) {
            dp[rest][cur] = f2(N, E, rest - 1, 2, dp);
            return dp[rest][cur];
        }
        if (cur == N) {
            dp[rest][cur] = f2(N, E, rest - 1, N - 1, dp);
            return dp[rest][cur];
        }
        dp[rest][cur] = f2(N, E, rest - 1, cur + 1, dp) + f2(N, E, rest - 1, cur - 1, dp);
        return dp[rest][cur];
    }

    public static int walkWay2(int N, int E, int K, int S) {
        int[][] dp = new int[K + 1][N + 1];
        for (int i = 0; i <= K; i++) {
            for (int j = 0; j <= N; j++) {
                dp[i][j] = -1;
            }
        }
        return f2(N, E, K, S, dp);
    }

    public static void main(String[] args) {
        System.out.println(walkWay2(3, 3, 4, 1));
    }
}
