public class InsertionSort{

    public static void main(String[] args) {
        int[] data = {8, 5, 7, 3, 2};
        System.out.println("Original: " + java.util.Arrays.toString(data));
        sort(data);
        System.out.println("Sorted: " + java.util.Arrays.toString(data));

    }

    public static void sort(int[] arr){
        if (arr == null || arr.length <=1) return;

        for (int i = 1; i<arr.length; i++){
            // Assume first element is already sorted.
            int curr = arr[i];
            int j = i - 1;

            while (j>=0 && arr[j] > curr){
                arr[j+1] = arr[j];
                j--;
            }
            // Insert the key (element) in the correct position
            arr[j+1] = curr;
        }
    }
}
