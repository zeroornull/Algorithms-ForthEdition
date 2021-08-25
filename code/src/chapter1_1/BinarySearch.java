package chapter1_1;

import algs4.In;
import algs4.StdIn;
import algs4.StdOut;

import java.util.Arrays;

/**
 * @author xxp
 * @version 1.0
 * @date 2021-08-25 14:28
 **/
public class BinarySearch {

    public static int rank(int key, int[] a) {
        //
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            // 取整的方式 向0取整
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) {
                hi = mid - 1;
            } else if (key > a[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int i = 3;
        int j = 2;
        // 向0取整
//        System.out.println(i/j);

        int i1 = 7;
        int j1 = 8;
        // 向0取整
//        System.out.println(i1/j1);

        int[] whitelist = In.readInts(args[0]);
        Arrays.sort(whitelist);
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (rank(key, whitelist) < 0) {
                StdOut.println(key);
            }
        }


    }

}
