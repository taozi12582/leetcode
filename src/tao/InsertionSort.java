package tao;

public class InsertionSort {
    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for(int i = 1; i <arr.length; i++){
            for(int j = i-1; j>=0 && arr[j]>arr[j+1]; j--){
                swap(j,j+1,arr);
            }
        }

    }

    private static void swap(int j, int i, int[] arr) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
