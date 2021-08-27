package chapter1_1;

import java.util.Arrays;

/**
 * @author xxp
 * @version 1.0
 * @date 2021-08-27 9:45
 **/
public class Ex29 {

    //
    public static int rank(int key, int[] a) {
        return rank(key, a, 0, a.length - 1);
    }

    // 二分查找
    public static int rank(int key, int[] a, int lo, int hi) {
        if (hi < lo)
            return -1;
        int mid = lo + (hi - lo) / 2;
        if (a[mid] < key)
            return rank(key, a, mid + 1, hi);
        else if (a[mid] > key)
            return rank(key, a, lo, mid - 1);
        else {
            while ((mid - 1) >= 0 && a[mid] == a[mid - 1]) {
                mid--;
            }
            return mid;
        }
    }

    public static int count(int key, int[] a) {
        int mid = rank(key, a);
        int count = 1;
        while ((mid + 1) < a.length && a[mid] == a[mid + 1]) {
            count++;
            mid++;

        }
        return count;
    }

    public static void main(String[] args) {
        int[] whitelist =
                { 0, 0, 1, 1, 1, 2, 3, 4, 4, 6, 6, 7, 8, 7, 5 };
        Arrays.sort(whitelist);
        System.out.println(rank(4, whitelist));
        System.out.println(count(1, whitelist));
    }

}
