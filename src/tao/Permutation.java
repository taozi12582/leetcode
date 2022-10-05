package tao;

public class Permutation {
    public static void permutation(String word) {
        if (word == null || word.isEmpty()) {
            return;
        }
        char[] chars = word.toCharArray();
        process(chars, 0);
    }

    private static void process(char[] chars, int i) {
        if (i == chars.length) {
            System.out.println(String.valueOf(chars));
            return;
        }
        boolean[] visit = new boolean[26];
        for (int j = i; j < chars.length; j++) {
            if (!visit[chars[j] - 'a']) {
                swap(chars, i, j);
                visit[chars[j] - 'a'] = true;
                process(chars, i + 1);
                swap(chars, i, j);
            }
        }
    }

    private static void swap(char[] chars, int i, int j) {
        if (i == j) {
            return;
        }
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

    public static void main(String[] args) {
        permutation("王一然");
    }
}
