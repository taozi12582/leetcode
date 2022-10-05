package tao;

public class NumCharTransferNums {
    public static int getNums(String words) {
        if (words == null || words.isEmpty()) {
            return 0;
        }
        char[] chars = words.toCharArray();
        return process(chars, 0);
    }

    private static int process(char[] chars, int i) {
        if (i == chars.length) {
            return 1;
        }
        if (chars[i] == '0') {
            return 0;
        }
        int value = chars[i] - 48;
        int res = 0;
        if(value == 1){
            res = process(chars,i+1);
            if(i+1<chars.length){
                res += process(chars,i+2);
            }
            return res;
        }
        if(value == 2){
            res = process(chars,i+1);
            if(i+1<chars.length && chars[i+1] - 48 <=6){
                res += process(chars,i+2);
            }
            return res;
        }
        return process(chars,i+1);
    }

    private static int process1(char[] chars, int i) {
        if (i == chars.length) {
            return 1;
        }
        int value = chars[i] - 48;
        int res = 0;
        if (value == 1 || value == 2) {
            if (i + 1 < chars.length && chars[i + 1] != '0') {
                res += process(chars, i + 1);
                if (i + 2 < chars.length && chars[i + 2] != '0') {
                    if (value == 1) {
                        res += process(chars, i + 2);
                    } else if (chars[i + 1] - 48 <= 6) {
                        res += process(chars, i + 2);
                    }
                } else {
                    res += process(chars, i + 3);
                }
            } else if (i + 1 < chars.length && chars[i + 1] == '0') {
                res += process(chars, i + 2);
            } else {
                return 1;
            }
        } else {
            res += process(chars, i + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(getNums("1203"));
    }
}
