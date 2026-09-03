package main.leetcode;

import java.util.*;

public class TopKFrequentElements {

    public static int[] topKFrequentTwo(int[] arr, int k){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0;  i<arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        List<Integer> sortedByVal = map.entrySet()
                .stream()
                .sorted(new Comparator<Map.Entry<Integer, Integer>>() {
                    @Override
                    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                        // Reverse order
                        if (o1.getValue() > o2.getValue()){
                            return -1;
                        } else if (o1.getValue() < o2.getValue()){
                            return 1;
                        } else{
                            return 0;
                        }
                    }
                })
                .map(Map.Entry::getKey)
                .limit(k)
                .collect(Collectors.toList());
        System.out.println(sortedByVal);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            System.out.println("key: " + entry.getKey());
            System.out.println("value: " + entry.getValue());
        }
        return sortedByVal.stream().mapToInt(i->i).toArray();
    }

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
