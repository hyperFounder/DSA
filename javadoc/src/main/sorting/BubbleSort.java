package main.sorting;

import java.util.*;

public class BubbleSort{

    public static void main(String[] args) {
        int[] data = {8, 5, 7, 3, 2};
        System.out.println("Original: " + java.util.Arrays.toString(data));
        sort(data);
        System.out.println("Sorted: " + java.util.Arrays.toString(data));

        System.out.println(missingNumber(new int[]{0, 1}));

        int[] nums = {1,2,1,2,1,2,3,1,3,2};
        List<Integer> bucket = new ArrayList<>();
        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
        int k = 2;

        for (int n : nums){
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        System.out.println("nums: " + Arrays.toString(nums));
         for (Map.Entry<Integer, Integer> entrySet : frequencyMap.entrySet()){
             System.out.println("key: " + entrySet.getKey() + " value: " + entrySet.getValue());
         }

        frequencyMap.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .limit(k)
                .forEach(System.out::println);

         frequencyMap.entrySet().stream()
                 .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                 .limit(k)
                 .forEach((entry) -> {
                     bucket.add(entry.getKey());
                 });

         for (int i : bucket){
             System.out.println(i);
         }

        System.out.println(Arrays.toString(bucket.toArray()));
    }

    public static int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i<nums.length -1; i++){
            if (nums[i+1] != (nums[i] + 1)){
                return i + 1;
            }
        }
        return 0;
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
        if (arr == null || arr.length <= 1) return;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j+1]){
                    // swapp
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

//    public static void sort(int[] arr){
//        if (arr == null || arr.length <=1) return;
//
//        for (int i = 0; i<arr.length - 1; i++){
//            // The largest element is on the end of array.
//            // Optimisation 1. Replace "j<arr.length - 1" with j < arr.length - 1 - i
//            for (int j = 0; j<arr.length - 1 - i; j++){
//                if (arr[j] > arr[j+1]){
//                    // swap
//                    int temp = arr[j];
//                    arr[j] = arr[j+1];
//                    arr[j+1] = temp;
//                }
//            }
//        }
//    }
}