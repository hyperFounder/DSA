package main.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {
    public static boolean isValid(String bracket){
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : bracket.toCharArray()){
            if (c == '[' || c == '(' || c == '{'){
                deque.push(c);
            }
            else{
                if (!deque.isEmpty()){
                    char top = deque.pop();
                    if (c == ')' && top == '(') continue;
                    if (c == ']' && top == '[') continue;
                    if (c == '}' && top == '{') continue;
                    else return false;
                }
            }
        }
        return deque.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("{[()]}"));
        System.out.println(isValid("{[(])}"));
    }
}
