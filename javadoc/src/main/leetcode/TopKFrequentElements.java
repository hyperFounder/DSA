package main.leetcode;

import java.util.*;

public class TopKFrequentElements {


    public static int[] topKFrequent(int[] nums, int k){
        // Declare an array of integer lists
        List<Integer>[] bucket = new List[nums.length + 1];

        HashMap<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
        for (int n : nums){
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
            if (bucket[entry.getValue()] == null){
                bucket[entry.getValue()] = new ArrayList<>();
            }
            bucket[entry.getValue()].add(entry.getKey());
        }

        List<Integer> result = new ArrayList<>();

        for(int i =bucket.length-1; i>=0 && result.size() < k; i--){
            if (bucket[i] != null){
                result.addAll(bucket[i]);
            }
        }
        return result.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        int[] result = topKFrequent(nums, k);
        System.out.println(Arrays.toString(result));

    }
}
