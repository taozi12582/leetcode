package tao;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PrintAllSubsquence {

    public static void printAllSubsquence(String string) {
        if (string == null) {
            return;
        }
        char[] chars = string.toCharArray();
        List<Character> list = new ArrayList<>();
        process(0, chars, list);
    }

    private static void process(int i, char[] chars, List<Character> res) {
        if (i == chars.length) {
            printList(res);
            return;
        }
        List<Character> cp1 = copyList(res);
        cp1.add(chars[i]);
        process(i + 1, chars, cp1);
        List<Character> cp2 = copyList(res);
        process(i + 1, chars, res);
    }

    private static List<Character> copyList(List<Character> res) {
        return new ArrayList<>(res);
    }

    private static void printList(List<Character> res) {
        Stack<Character> characterStack = new Stack<>();
        for (char c : res) {
            characterStack.push(c);
        }
        while (!characterStack.isEmpty()) {
            System.out.print(characterStack.pop());
        }
        System.out.println();
    }

    public static void main(String[] args) {
//        printAllSubsquence("abc");
//        char[] chars = {'a', 'b', 0, 'c'};
//        System.out.println(String.valueOf(chars));
        process2("abc".toCharArray(),0);
    }

    public static void process2(char[] chars, int i) {
        if (i == chars.length) {
            System.out.println(String.valueOf(chars));
            return;
        }
//        process2(chars, i + 1);
        char temp = chars[i];
        chars[i] = 0;
        process2(chars, i + 1);
        chars[i] = temp;
        process2(chars, i + 1);
    }
}
