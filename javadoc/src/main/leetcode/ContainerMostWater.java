package main.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ContainerMostWater {
    public static int maxArea(int[] height) {
        int maxArea = 0;
        // Two pointer approach
        // Can just brute force with 2 pointers i, j O(n^2)
        int l = 0;
        int r = height.length - 1;

        while (l < r){
            int shortestWall = Math.min(height[l], height[r]);
            int area = shortestWall * (r - l);
            maxArea = Math.max(area, maxArea);
            if (height[l] < height[r]){
                l++;
            } else{
                r--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
//        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
////        System.out.println(maxArea(new int[]{1,1}));
//        System.out.println(maxArea(new int[]{1,2,1}));
        String[] words = {"apple", "banana", "apple", "orange", "banana", "apple"};
        Map<String, Integer> frequencyMap = new HashMap<>();

        for (String word : words) {
            frequencyMap.computeIfAbsent(word, k -> 0);
            frequencyMap.put(word, frequencyMap.get(word) + 1);
        }

        System.out.println(frequencyMap);
    }
}
