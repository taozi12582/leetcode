package tao;

import java.util.Comparator;
import java.util.PriorityQueue;

public class GetMedian {
    public static double getMedian(double[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        PriorityQueue<Double> minQueue = new PriorityQueue<>(Comparator.comparingDouble(a -> a));
        PriorityQueue<Double> maxQueue = new PriorityQueue<Double>((a, b) -> b > a ? 1 : -1);
        maxQueue.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > maxQueue.peek()) {
                minQueue.add(nums[i]);
            } else {
                maxQueue.add(nums[i]);
            }
            int diff = minQueue.size() - maxQueue.size();
            if (Math.abs(diff) == 2) {
                if (diff > 0) {
                    maxQueue.add(minQueue.poll());
                } else {
                    minQueue.add(maxQueue.poll());
                }
            }
        }
        if (minQueue.size() == maxQueue.size()) {
            return ((minQueue.peek() + maxQueue.peek())) / 2;
        }
        return minQueue.size() > maxQueue.size() ? minQueue.peek() : maxQueue.peek();
    }

    public static void main(String[] args) {
        double[] doubles = new double[]{1, 2, 3, 4, 5, 6,7};
        System.out.println(getMedian(doubles));
    }
}
