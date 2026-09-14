package main.sorting;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40};
        Arrays.sort(arr);
        System.out.println(Arrays.binarySearch(arr, -20));
        System.out.println(binarySearchT(arr, 20));
    }

    public static int binarySearchT(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if (arr[mid] == target) return mid;
            else if(target < arr[mid])right = mid -1;
            else left = mid + 1;
        }
        return -1;
    }
}
