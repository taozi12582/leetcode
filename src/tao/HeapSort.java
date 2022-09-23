package tao;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class HeapSort {
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
//        for (int i = 0; i < arr.length; i++) {
//            heapInsert(arr, i);
//        }
        for (int i = arr.length - 1; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }
        swap(0, arr.length - 1, arr);
        int heapSize = arr.length - 1;
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(0, --heapSize, arr);
        }
    }

    private static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(index, (index - 1) / 2, arr);
            index = (index - 1) / 2;
        }
    }

    private static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left]
                    ? left + 1 : left;
            largest = arr[index] > arr[largest] ? index : largest;
            if (largest == index) {
                break;
            }
            swap(index, largest, arr);
            index = largest;
            left = index * 2 + 1;
        }
    }

    private static void swap(int j, int i, int[] arr) {
        if (i == j) {
            return;
        }
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) {
//        int[] arr = RandomArray.generateRandomArray(20, 20);
////        for (int i = 0; i < arr.length; i++) {
////            heapInsert(arr, i);
////        }
//        System.out.println(Arrays.toString(arr));
//        heapSort(arr);
////        System.out.println(Arrays.toString(arr));
//        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> a - b);
//        heap.add(1);
//        heap.add(2);
//        heap.add(3);
//        heap.add(4);
//        heap.add(5);
//        while (!heap.isEmpty()) {
//            System.out.println(heap.poll());
//        }
        int[] arr = RandomArray.generateRandomArray(20, 20);
        System.out.println(Arrays.toString(arr));
        hs(arr);
        System.out.println(Arrays.toString(arr));
    }

    // java提供的优先级队列，不传参的情况下，默认小根堆
    // PriorityQueue<Integer> heap = new PriorityQueue<>();

    public static void hi(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(index, (index - 1) / 2, arr);
            index = (index - 1) / 2;
        }
    }

    public static void hy(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int large = left + 1 < heapSize & arr[left + 1] > arr[left] ? left + 1 : left;
            large = arr[index] > arr[large] ? index : large;
            if (large == index) {
                break;
            }
            swap(large, index, arr);
            index = large;
            left = index * 2 + 1;
        }
    }

    public static void hs(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
//        for (int i = 0; i < arr.length; i++) {
//            hi(arr, i);
//        }
        //计算出满二叉树的最后一个节点的下标
        int f = (int) (Math.log(arr.length) / Math.log(2));
        for (int i = (int) (Math.pow(2, f) - 2); i >= 0; i--) {
            heapify(arr, i, arr.length);
        }
        swap(0, arr.length - 1, arr);
        int heapSize = arr.length - 1;
        while (heapSize > 1) {
            heapify(arr, 0, heapSize);
            swap(0, --heapSize, arr);
        }
    }
}
