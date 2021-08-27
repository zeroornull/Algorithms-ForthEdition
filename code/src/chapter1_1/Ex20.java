package chapter1_1;

import algs4.StdOut;

/**
 * @author xxp
 * @version 1.0
 * @date 2021-08-26 16:20
 **/
public class Ex20 {
    public static void main(String[] args) {
        StdOut.print(ln10(9));
    }

    public static double ln10(int N) {
        if (N == 1) {
            return Math.log10(1);
        }
        return Math.log10(N) + ln10(N - 1);
    }
}
