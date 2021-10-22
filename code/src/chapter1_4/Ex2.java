package chapter1_4;

import algs4.In;
import algs4.StdOut;

import java.math.BigInteger;

public class Ex2 {
    public static int count(int[] array) {
        //
        int length = array.length;
        int count = 0;
        BigInteger bigInteger;

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                for (int k = j + 1; k < length; k++) {
                    bigInteger = BigInteger.valueOf(array[i]);
                    bigInteger = bigInteger.add(BigInteger.valueOf(array[j]));
                    bigInteger = bigInteger.add(BigInteger.valueOf(array[k]));
                    if (bigInteger.intValue() == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        In in = new In("E:\\BaiduNetdiskDownload\\algs4-data\\1Kints.txt");
        int[] array = in.readAllInts();
        StdOut.println(count(array));
    }


}
