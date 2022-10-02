package tao;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinGoldPrice {
    public static int getMinPrice(int[] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparing(a-> a));
        for(int i:arr){
            queue.add(i);
        }
        int sum = 0;
        while(queue.size() >1){
            int a = queue.poll();
            int b = queue.poll();
            sum += a+b;
            queue.add(a+b);
        }
        return sum;
    }
}
