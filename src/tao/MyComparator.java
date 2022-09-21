package tao;

import java.util.Arrays;
import java.util.Comparator;

public class MyComparator {
    public static class Student {
        public String name;
        public int id;
        public int age;

        public Student(String name, int id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        //返回负值返回第一个参数
        Student a = new Student("a", 2, 20);
        Student b = new Student("b", 3, 21);
        Student c = new Student("c", 1, 22);
        Student[] students = {a, b, c};
        Arrays.sort(students, (s1, s2) -> s1.id-s2.id);
    }
}
