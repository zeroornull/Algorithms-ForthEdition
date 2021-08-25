package chapter1_1;

import algs4.StdOut;

/**
 * @author xxp
 * @version 1.0
 * @date 2021-08-25 15:33
 **/
public class Ex5 {
    public boolean betweenZeroAndOne(Double a, Double b) {
        if (0 < a && a < 1 && 0 < b && b < 1) {
            StdOut.println(true);
            return true;
        }
        StdOut.println(false);
        return false;
    }
}
