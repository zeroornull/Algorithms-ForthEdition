package chapter1_1;

import algs4.StdOut;
import algs4.StdRandom;

/**
 * @author xxp
 * @version 1.0
 * @date 2021-08-25 16:26
 **/
public class Ex11 {

    public static void printBoolArr(boolean[][] arr) {
        StdOut.print(' ');
        for (int i = 0; i < arr[0].length; i++) {
            StdOut.print(i);
        }
        StdOut.print();
        for (int i = 0; i < arr.length; i++) {
            StdOut.print(i);
            for (int j = 0; j < arr[i].length; j++) {
                StdOut.print(arr[i][j] ? '*' : ' ');
            }
            StdOut.println();
        }
    }

    public static void main(String[] args) {
        boolean[][] arr = new boolean[7][6];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                double num = StdRandom.uniform();
                if (num > 0.5) {
                    arr[i][j] = true;
                } else {
                    arr[i][j] = false;
                }
            }
        }
        printBoolArr(arr);
    }

}
