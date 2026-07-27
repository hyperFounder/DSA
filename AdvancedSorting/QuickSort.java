public class QuickSort {

    public static void main(String[] args) {
        int[] data = {70, 30, 80, 90, 40, 50, 10};
        System.out.println("Original: " + java.util.Arrays.toString(data));
        sort(data);
        System.out.println("Sorted: " + java.util.Arrays.toString(data));
        // Output: [10, 30, 40, 50, 70, 80, 90]

    }

    public static void sort(int[] arr){
        if (arr == null || arr.length <= 1) return;
        quickSort(arr, 0, arr.length-1);
    }

    // Recursive divide and Conquer step
    private static void quickSort(int[] array, int low, int high){
        if (low < high){
            // Partition the array around a pivot
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high){

        int pivot = array[low];
        int i = low;

        for (int j = low + 1; j<=high; j++){

            // If curr element is smaller than or equal to pivot
            if (array[j] <= pivot){
                // swap
                i++;
                swap(array, i, j);
            }
        }
        // Swap the pivot element which is sitting at 'low' into its correct position 'i'
        swap(array, low, i);
        return i;
    }

    /**
     * Helper method to swap two elements in the array.
     */
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
