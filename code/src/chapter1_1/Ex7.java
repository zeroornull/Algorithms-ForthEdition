package chapter1_1;

import algs4.StdOut;

/**
 * @author xxp
 * @version 1.0
 * @date 2021-08-25 15:41
 **/
public class Ex7 {
    public static void main(String[] args) {
        // a
       /* double t= 9.0;
        while (Math.abs(t - 9.0/t) > .001) {
            t=(9.0/t + t) /2.0;
        }
        StdOut.printf("%.5f\n", t);*/

        // b
        /*int sum = 0;
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < i; j++) {
                sum ++;
            }
        }
        StdOut.println(sum);*/

        // c
        int sum = 0;
        for (int i = 1; i < 1000; i *= 2) {
            for (int j = 0; j < 1000; j++) {
                sum++;
            }
        }
        StdOut.println(sum);

    }
}
