package main.leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MissingNumber {


    public static int missingNumber(int[] nums){

        // Sum of N natural numbers: (n * (n+1)) / 2
        int n = nums.length;
        int sumN = (n * (n+1)) / 2;
        return sumN - IntStream.of(nums).sum();
    }

    public int missingNumberMethodTwo(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i<nums.length; i++){
            if (nums[i] != i) return i;
        }
        return nums.length;
    }
}
