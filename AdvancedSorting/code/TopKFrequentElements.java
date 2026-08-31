package main.leetcode;

import java.util.*;

public class TopKFrequentElements {


    public static int[] topKFrequent(int[] nums, int k){
        List<Integer> bucket = new ArrayList<>();
        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
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
        // Convert List<Integer> to int[] array

        return bucket.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1,2,1,2,3,1,3,2};
        int k = 2;
        int[] result = topKFrequent(nums, k);
        System.out.println(Arrays.toString(result));

    }
}
