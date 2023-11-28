package rip;

import java.util.LinkedList;

class valid {
    public static boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();

        for (char c : s.toCharArray()) {

            if (c == '(' || c == '{' || c == '[') {
                stack.addFirst(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char peek = stack.peek();
                    if ((c == ')' && peek == '(') || (c == '}' && peek == '{') || (c == ']' && peek == '[')) {
                        stack.removeFirst();
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
    }
}