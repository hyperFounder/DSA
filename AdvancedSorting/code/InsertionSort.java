public class InsertionSort{

    public static void main(String[] args) {
        int[] data = {8, 5, 7, 3, 2};
        System.out.println("Original: " + java.util.Arrays.toString(data));
        sort(data);
        System.out.println("Sorted: " + java.util.Arrays.toString(data));

    }

    // Insertion sort: Insert the key a[i] into sorted array a[0:i-1]
    public static void sortMethodTwo(int[] nums) {
        for (int i = 1; i<nums.length; i++){
            for (int j = 0; j<i; j++){
                if (nums[i] < nums[j]){
                    // swap
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    public static void sort(int[] arr){
        if (arr == null || arr.length <=1) return;

        for (int i = 1; i < a.length; i++) {
            int key = a[i];  // The value we want to insert into the sorted prefix.
            int j = i - 1;

            // Shift larger elements one position to the right
            // until we find where 'key' belongs.
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }

            // Place 'key' into the gap created by shifting.
            a[j + 1] = key;
        }
    }
}
