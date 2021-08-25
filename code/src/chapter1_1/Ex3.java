package chapter1_1;

import algs4.StdIn;
import algs4.StdOut;

/**
 * @author xxp
 * @version 1.0
 * @date 2021-08-25 15:24
 **/
public class Ex3 {
    public static void main(String[] args) {
        int a = StdIn.readInt();
        int b = StdIn.readInt();
        int c = StdIn.readInt();
        if (a == b && a == c) {
            StdOut.println("equal");
        } else {
            StdOut.println("not equal");

        }
    }
}
