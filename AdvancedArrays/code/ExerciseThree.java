import java.util.ArrayDeque;

public class AdvancedArrays {

    public static boolean isPalindrome(String s){
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        ArrayDeque<Character> deque = new ArrayDeque<>();
        for (Character c : s.toCharArray()){
            deque.add(c);
        }
        System.out.println(deque.getFirst());
        System.out.println(deque.getLast());
        while (deque.size() > 1){
            char first = deque.removeFirst();
            char last = deque.removeLast();
            if (last != first) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome("hannah"));
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}
