package tao;

import java.util.Arrays;

public class MinDictionaryValue {
    public static String findMin(String[] strings) {
        if (strings == null || strings.length == 0) {
            return "";
        }
        Arrays.sort(strings, (a, b) -> (a + b).compareTo(b + a));
        StringBuilder sb = new StringBuilder();
        for (String str : strings) {
            sb.append(str);
        }
        return sb.toString();
    }
}
