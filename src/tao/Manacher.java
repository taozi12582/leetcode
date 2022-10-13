package tao;

public class Manacher {
    public static char[] getManacherString(String s) {
        char[] str = s.toCharArray();
        char[] res = new char[str.length * 2 + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : str[(i - 1) / 2];
        }
        return res;
    }

    public static int getMaxLength(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] str = getManacherString(s);
        int[] pArr = new int[str.length];
        int R = -1;
        int C = -1;
        int max = 0;
        for (int i = 0; i < str.length; i++) {
            pArr[i] = i < R ? Math.min(pArr[2 * C - i], R - i) : 1;
            while (i + pArr[i] < str.length && i - pArr[i] > -1) {
                if (str[i + pArr[i]] == str[i - pArr[i]]) {
                    pArr[i]++;
                } else {
                    break;
                }
            }
            if (i + pArr[i] > R) {
                R = i + pArr[i];
                C = i;
            }
            max = Math.max(max, pArr[i] - 1);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(getMaxLength("ddbaccabaawx"));
    }
}
