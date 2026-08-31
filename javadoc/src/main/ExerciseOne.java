package main;

import java.util.ArrayDeque;

public class ExerciseOne{

    public static boolean isValidParentheses(String s){
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()){
            if (c == '[' || c == '(' || c == '{'){
                stack.push(c);
            }
            else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if (top == '[' && c == '[') continue;
                if (top == '{' && c == '{') continue;
                if (top == '(' && c == '(') continue;
                return false;
            }
        }


        return stack.isEmpty();

        /**
         *[
         * (
         *
         * ([])
         *
         */
    }


    public static boolean isPalindrome(String s){

        return false;
    }


    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isValidParentheses("[()"));
        System.out.println(Math.pow(2, 3));
    }
}