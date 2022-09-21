package tao;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SortArrayDistanceLessK {
    public static void sortArrayDistanceLessK(int[] arr, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int index = 0;
        for (; index < Math.min(k, arr.length); index++) {
            heap.add(arr[index]);
        }
        int i = 0;
        for (; index <arr.length;i++,index++){
            heap.add(arr[index]);
            arr[i] = heap.poll();
        }
        while(!heap.isEmpty()){
            arr[i++]=heap.poll();
        }
    }

    public static void main(String[] args) {
        int[] ints = RandomArray.generateRandomArray(20, 9);
        System.out.println(Arrays.toString(ints));
        sortArrayDistanceLessK(ints,10);
        System.out.println(Arrays.toString(ints));
    }
}
