package algorithm;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {

    }

    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(' || chars[i] == '{' || chars[i] == '[') {
                stack.push(chars[i]);
            } else {
                char temp = stack.peek();
                if (temp == '(' && chars[i] == ')') {
                    stack.pop();
                    continue;
                }
                if (temp == '[' && chars[i] == ']') {
                    stack.pop();
                    continue;
                }
                if (temp == '{' && chars[i] == '}') {
                    stack.pop();
                    continue;
                }
                stack.push(chars[i]);
            }
        }

        return stack.empty();
    }
}
