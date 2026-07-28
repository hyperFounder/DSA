public class SelectionSort {


    public static void selectionSort(int[] arr){

        for (int i=0; i<arr.length-1; i++){
            // Find minimum element in the unsorted array
            int minIndex = i;
            for (int j = i + 1; j<arr.length; j++){
                if (arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            // Swap minimum element with the first element of the unsorted part
            if (minIndex != i){
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }


        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};

        System.out.println("Before sorting:" + java.util.Arrays.toString(arr));
        selectionSort(arr);
        System.out.println("After sorting:" + java.util.Arrays.toString(arr));
    }
}
