package main.sorting;

import java.util.Arrays;

public class InsertionSort{

    public static void main(String[] args) {
        int[] data = {5, 2, 4, 6, 1, 3};
        System.out.println("Before sorting: " + Arrays.toString(data));
        insertionSort(data);
        System.out.println("After sorting: " + Arrays.toString(data));
    }

    public static void insertionSort(int[] a){

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