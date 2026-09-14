package main.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MergeSortedArray {

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> hs = new HashSet<Integer>();

        for (int i = 0; i<nums.length; i++){
            if (hs.contains(nums[i])){
                return true;
            }
            hs.add(nums[i]);
        }
        return false;
    }

    private static String bubbleUpFromIndex(int[] arr, int index){
        for (int i = arr.length; i >index ; i--) {
            arr[i] = arr[i-1];
        }
        return Arrays.toString(arr);
    }

    // Insertion sort: Insert the key a[i] into sorted array a[0:i-1]
    public static String sortMethodTwo(int[] nums) {
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
        return Arrays.toString(nums);
    }


    public static void main(String[] args) {
//        System.out.println(bubbleUpFromIndex(new int[] {1, 2, 3,0,0,0}, 2));
        System.out.println(containsDuplicate(new int[] {1,2,3,1}));
        System.out.println(sortMethodTwo(new int[] {5,2,6,1,3}));
    }
}
