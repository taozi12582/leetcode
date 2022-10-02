package tao;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ProjectProfit {
    public static class Project {
        public int cost;
        public int profit;

        public Project(int cost, int profit) {
            this.cost = cost;
            this.profit = profit;
        }
    }

    public static int getMaxProfit(Project[] projects, int money, int maxNum) {
        PriorityQueue<Project> costMinQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        PriorityQueue<Project> profitMaxQueue = new PriorityQueue<>((a, b) -> b.profit - a.profit);
        costMinQueue.addAll(Arrays.asList(projects));
        int allMoney = money;
        Project cp = null;
        while (maxNum > 0) {
            while (!costMinQueue.isEmpty() && costMinQueue.peek().cost <= allMoney) {
                profitMaxQueue.add(costMinQueue.poll());
            }
            if (profitMaxQueue.isEmpty()) {
                return allMoney - money;
            }
            allMoney += profitMaxQueue.poll().profit;
            maxNum--;
        }
        return allMoney - money;
    }
}
