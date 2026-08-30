public class BubbleSort{
    public static void main(String[] args) {
        int[] data = {8, 5, 7, 3, 2};
        System.out.println("Original: " + java.util.Arrays.toString(data));
        sort(data);
        System.out.println("Sorted: " + java.util.Arrays.toString(data));
    }
    public static void sortOptimised(int[] arr){
        // If we complete an entire pass without swapping, then all numbers are in perfect order
        if (arr == null || arr.length <=1) return;
        boolean swapped = true;

        for (int i = 0; i<arr.length - 1; i++){
            swapped = false;
            for (int j = 0; j<arr.length - 1 - i; j++){
                if (arr[j] > arr[j+1]){
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;

                    // set swapped to true
                    swapped = true;
                }
            }
            // If the inner loop finished and swapped is still false, 
            // the array is completely sorted. Exit the outer loop early.
            if (!swapped) {
                break;
            }
        }
    }
    public static void sort(int[] arr){
        if (arr == null || arr.length <=1) return;
        for (int i = 0; i<arr.length - 1; i++){
            // The largest element is on the end of array.
            // Optimisation 1. Replace "j<arr.length - 1" with j < arr.length - 1 - i
            for (int j = 0; j<arr.length - 1 - i; j++){
                if (arr[j] > arr[j+1]){
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
