package temp;

import algs4.StdOut;

public class Ex4 {
    public static void main(String[] args) {
        String string1 = "Hello World";
        String string2 = string1;
        string1 = "world";
        StdOut.println(string1);
        StdOut.println(string2);
    }
}
