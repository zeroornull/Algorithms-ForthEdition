package chapter1_3;

import algs4.Stack;

public class Ex4 {
    public static void main(String[] args) {
        String string = "[()]{}{[()()]()}";
        if (isLegal(string)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

    }

    private static boolean isLegal(String string) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (c == '[' || c == '(' || c == '{') {
                stack.push(c);
            } else if (c == ')') {
                char temp = stack.pop();
                if (temp != '(') {
                    return false;
                }
            } else if (c == ']') {
                char temp = stack.pop();
                if (temp != '[')
                    return false;
            } else if (c == '}') {
                char temp = stack.pop();
                if (temp != '{')
                    return false;
            }
        }
        return stack.isEmpty();
    }


}
