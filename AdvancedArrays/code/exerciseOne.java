public class AdvancedArrays {

    public static boolean isBalanced(String s){
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()){
            if (c == '[' || c == '{' || c == '(') {
                stack.push(c);
            }
            if (c == ']' || c == '}' || c == ')'){
                if (stack.isEmpty()){
                    return false;
                }
                char top = stack.pop();
                if (top == '(' && c == ')') continue;
                if (top == '[' && c == ']') continue;
                if (top == '{' && c == '}') continue;
                return false;
            }
            System.out.println(c);
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] numbers = new int[10];
        System.out.println(isBalanced("[{()}]"));
        System.out.println(isBalanced("[()]"));
    }
}
