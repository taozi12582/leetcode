package tao;

public class NQueenProblem {
    public static int getSolutionNum(int n) {
        if (n <= 3) {
            return 0;
        }
        int[] records = new int[n];
        return process(0, records, n);
    }

    //i为数组下标，对应行数减一
    public static int process(int i, int[] records, int n) {
        if (i == n) {
            return 1;
        }
        int res = 0;
        for (int j = 0; j < n; j++) {
            if (isValid(records, i, j)) {
                records[i] = j;
                res += process(i + 1, records, n);
            }
        }
        return res;
    }

    private static boolean isValid(int[] records, int i, int j) {
        for (int k = 0; k < i; k++) {
            if (j == records[k] || Math.abs(records[k] - j) == Math.abs(i - k)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(getSolutionNum(14));
        System.out.println(NQueenPlus(14));
    }

    public static int NQueenPlus(int n) {
        if (n <= 3) {
            return 0;
        }
        int limit = n == 32 ? -1 : (1 << n) - 1;
        return process2(limit, 0, 0, 0);
    }

    private static int process2(int limit, int colLim, int leftDiaLim, int rightDiaLim) {
        if (colLim == limit) {
            return 1;
        }
        int pos = (~(colLim | leftDiaLim | rightDiaLim)) & limit;
        int res = 0;
        int rightOne = 0;
        while (pos != 0) {
            rightOne = pos & (~pos + 1);
            res += process2(limit, colLim | rightOne, (leftDiaLim | rightOne) << 1, (rightDiaLim | rightOne) >>> 1);
            pos -= rightOne;
        }
        return res;
    }
}
