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
        for (int i = 0; i<a.length; i++){
            for (int j = 0; j<i; j++){
                if (a[i] < a[j]){
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }
}