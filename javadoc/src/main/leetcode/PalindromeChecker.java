package main.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Locale;

public class PalindromeChecker {
    public static boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        System.out.println(s);
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : s.toCharArray()){
            deque.add(c);
        }

        while (deque.size() > 1){
            char first = deque.removeFirst();
            char last = deque.removeLast();
            if (first != last) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("hannah"));
        System.out.println(isPalindrome(" "));
        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

}
