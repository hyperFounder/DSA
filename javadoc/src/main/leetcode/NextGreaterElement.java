package main.leetcode;

import java.util.*;

public class NextGreaterElement {

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // https://www.youtube.com/watch?v=8BDKB2yuGyg
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> deque = new ArrayDeque<>();

        // Build a hashmap of next greatest elements in nums2
        for (int i : nums2){
            while (!deque.isEmpty() && deque.peek() < i){
                map.put(deque.pop(), i);
            }
            deque.push(i);
        }

        for (int i = 0; i<nums1.length; i++){
            // Lookup next greatest elements. If key is missing return -1 (no greatest element exists);
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }
        return nums1;
    }

//    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
//        int []result = new int[nums1.length];
//        Arrays.fill(result, -1);
//
//        for (int i = 0; i < nums1.length; i++) {
//            int j = 0; // Reset j after every iteration
//            while (j < nums2.length){
//                if (nums1[i] == nums2[j]){
//                    thirdLoop:
//                    while (j < nums2.length){
//                        j++;
//                        if (j < nums2.length && nums2[j] > nums1[i]){ // greater does exist
//                            result[i] = nums2[j];
//                            break thirdLoop;
//                        }
//                    }
//                }
//                j++;
//            }
//        }
//        return result;
//    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{4,1,2}, new int[]{1,3,4,2})));
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{2, 4}, new int[]{1,2,3,4})));
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{1,3,5,2,4}, new int[]{6,5,4,3,2,1,7})));
    }
}
