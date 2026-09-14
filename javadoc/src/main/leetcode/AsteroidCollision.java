package main.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class AsteroidCollision {
    public static int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < asteroids.length; i++){
            if (asteroids[i] > 0){
                deque.push(asteroids[i]);
            }
            else {
                deque.push(asteroids[i]);

                // Top of the stack is the asteroid
                while (deque.size() > 1){
                    int curr = deque.pop();
                    int top = deque.peek();

                    if (top < 0){ // Asteroid and curr are both negative. No collision
                        // Push back curr
                        deque.push(curr);
                        break;
                    }
                    if (Math.abs(top) < Math.abs(curr)){
                        // Top loses
                        deque.pop();
                        // Push asteroid back
                        deque.push(curr);
                    }
                    else if (Math.abs(top) == Math.abs(curr)){
                        deque.pop();            // both die, curr stays off
                        break;
                    }
                    else {
                        break;                  // asteroid dies, curr stays off
                    }
                }
            }
        }

        System.out.println(deque);
        // Check if curr deque value is negative
        return deque.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(asteroidCollision(new int[]{-1,3,2,-3})));
        System.out.println(Arrays.toString(asteroidCollision(new int[]{3,5,-6,2,-1,4})));
//        System.out.println(Arrays.toString(asteroidCollision(new int[]{5, 10, -5})));
    }
}
