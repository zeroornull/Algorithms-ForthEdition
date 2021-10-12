package chapter1_3;

import algs4.Stack;

public class Ex10 {

    public static void main(String[] args) {
        String s = "((1+2)*((3-4)*(5-6)))";
        Stack<String> vals = new Stack<>();
        Stack<String> ops = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                ops.push(c + "");
            } else if (c == ')') {
                String v = vals.pop();
                String w = vals.pop();
                String string = w + " " + v + " " + ops.pop();
                vals.push(string);
            } else if (c == '(') {

            } else {
                vals.push(c + "");
            }
        }
        System.out.println(vals.pop());
    }

}
