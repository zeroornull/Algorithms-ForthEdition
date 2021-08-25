package chapter1_1;

import algs4.StdOut;

/**
 * @author xxp
 * @version 1.0
 * @date 2021-08-25 15:54
 **/
public class Ex9 {
    public static void main(String[] args) {
        
        toBinaryString(90);
    }

    public Ex9() {
    }

    private static String toBinaryString(Integer N) {
        StringBuilder s = new StringBuilder();
        for (int i = N; i > 0; i /= 2) {
            s.insert(0, (i % 2));
        }
        StdOut.println(s);
        return s.toString();
    }

}
