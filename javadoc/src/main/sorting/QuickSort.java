package main.sorting;

public class QuickSort{

    public static void main(String[] args) {
        int[] data = {70, 30, 80, 90, 40 , 50 , 10};
        System.out.println("Original: " + java.util.Arrays.toString(data));
        sort(data);
        System.out.println("Sorted: " + java.util.Arrays.toString(data));
    }

    public static void sort(int[] arr){
        if (arr == null || arr.length <= 1) return;
        quickSort(arr, 0, arr.length -1);
    }
    private static void quickSort(int[] arr, int low, int high){
        if (low < high){
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }
    private static int partition(int[] arr, int low, int high){
        int pivot = arr[low];
        int i = low;

        for (int j = i + 1; j<=high; j++){
            if (arr[j] <= pivot){
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, low, i);
        return i;
    }
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}