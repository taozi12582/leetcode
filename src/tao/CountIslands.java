package tao;

public class CountIslands {
    public static int countsIsland(int[][] island) {
        if (island == null || island[0] == null) {
            return 0;
        }
        int m = island.length;
        int n = island[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (island[i][j] == 1) {
                    res++;
                    infect(island, i, j, m, n);
                }
            }
        }
        return res;
    }

    private static void infect(int[][] island, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n || island[i][j] != 1) {
            return;
        }
        island[i][j] = 2;
        infect(island, i + 1, j, m, n);
        infect(island, i - 1, j, m, n);
        infect(island, i, j + 1, m, n);
        infect(island, i, j - 1, m, n);
    }

    public static void main(String[] args) {
        int[][] island = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0, 1, 1, 1, 0},
                {0, 1, 1, 1, 0, 0, 0, 1, 0},
                {0, 1, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1}
        };
        System.out.println(countsIsland(island));
    }
}
