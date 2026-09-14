package main.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MonotonicStack {
    // Find the next greater element in an arr
    // https://www.youtube.com/watch?v=DtJVwbbicjQ&t=202s

    public static int[] nextGreater(int[] arr){
        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[arr.length];
        Arrays.fill(result, -1);

        for (int i =0; i<arr.length; i++){
            while (!deque.isEmpty() && arr[i] > arr[deque.peek()]){
                int index = deque.pop();
                result[index] = arr[i];
            }
            deque.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreater(new int[]{2, 1, 5, 6, 2, 3})));
    }
}
