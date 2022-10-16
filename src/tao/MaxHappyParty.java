package tao;

import java.util.List;

public class MaxHappyParty {
    public static class Employee {
        public int happy;
        public List<Employee> nexts;

        public Employee(int happy, List<Employee> nexts) {
            this.happy = happy;
            this.nexts = nexts;
        }
    }

    public static class ReturnType {
        public int hasMax;
        public int hasNotMax;

        public ReturnType(int hasMax, int hasNotMax) {
            this.hasMax = hasMax;
            this.hasNotMax = hasNotMax;
        }
    }

    public static int getMaxHappy(Employee boss) {
        ReturnType res = process(boss);
        return Math.max(res.hasMax, res.hasNotMax);
    }

    private static ReturnType process(Employee employee) {
        if (employee.nexts.isEmpty()) {
            return new ReturnType(employee.happy, 0);
        }
        int res1 = employee.happy;
        int res2 = 0;
        for (Employee e : employee.nexts) {
            ReturnType process = process(e);
            res1 += process.hasNotMax;
            res2 += Math.max(process.hasMax, process.hasNotMax);
        }
        return new ReturnType(res1, res2);
    }
}
