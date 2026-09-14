package main.leetcode;

import java.util.Arrays;
import java.util.Objects;

public class TwoSumTwo {
    public static Object[] getIndex(int[] arr, int num){
        for (int i =0; i<arr.length; i++){
            if (arr[i] == num){
                // Mark arr[i] as seen
                arr[i] = -100000;
                return new Object[]{arr, i + 1};
            }
        }
        return new Object[]{arr, -1};
    }

    public static int[] twoSum(int[] nums, int target) {

        int i = 0;
        int j = nums.length - 1;

        while (i < j){
            if (nums[i] + nums[j] < target){
                i++;
            } else if (nums[i] + nums[j] == target){
                return new int[]{i+1, j+1};
            }
            else {
                j--;
            }
        }
        return new int[]{i+1, j+1};


//        for (int i =0; i<numbers.length; i++){
//            for (int j=0; j<numbers.length; j++){
//                if (target == numbers[i] + numbers[j]){
//                    if (i!=j){
//                        Object[] result1 = getIndex(numbers, numbers[i]);
//                        int[] arr = (int[]) result1[0];
//                        int indexI = (int) result1[1];
//                        System.out.println("Result 1: " + Arrays.toString(arr));
//                        System.out.println("index i: " + indexI);
//
//                        // Call the numbers arr. Modify the seen index to -100000. Then, pass it through result2
//                        Object[] result2 = getIndex(arr, numbers[j]);
//                        int indexJ = (int) result2[1];
//                        System.out.println("Result 2: " + Arrays.toString(((int[]) result2[0])));
//                        System.out.println("index j: " + indexJ);
//
//                        return new int[]{indexI, indexJ};
//                    }
//                }
//            }
//        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{2, 3, 4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{-1, 0}, -1)));
        System.out.println(Arrays.toString(twoSum(new int[]{0,0,3,4}, 0)));

    }
}
