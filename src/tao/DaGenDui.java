package tao;

public class DaGenDui {
    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(index, (index - 1) / 2, arr);
            index = (index - 1) / 2;
        }
    }

    private static void swap(int j, int i, int[] arr) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    //返回并移除最大值
    public static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int largesst = left + 1 < heapSize & arr[left + 1] > arr[left] ? left + 1 : left;
            largesst = arr[index] > arr[largesst] ? index : largesst;
            if (largesst == index) {
                break;
            }
            swap(index, largesst, arr);
            index = largesst;
            left = index * 2 + 1;
        }
    }
}
