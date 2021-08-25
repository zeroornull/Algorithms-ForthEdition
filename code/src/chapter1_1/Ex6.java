package chapter1_1;

import algs4.StdOut;

/**
 * @author xxp
 * @version 1.0
 * @date 2021-08-25 15:38
 **/
public class Ex6 {
    public static void main(String[] args) {
        int f = 0;
        int g = 1;
        for (int i = 0; i <= 15; i++) {
            StdOut.println(f);
            f = f + g;
            g = f - g;
        }
    }
}
