package main.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class TopKFrequentElements {

    public static int[] topKFrequent(int[] arr, int k){
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

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(topKFrequent(new int[]{1,1,1,2,2,3}, 2)));
        System.out.println(Arrays.toString(topKFrequent(new int[]{1,2,1,2,1,2,3,1,3,2}, 2)));
    }
}
