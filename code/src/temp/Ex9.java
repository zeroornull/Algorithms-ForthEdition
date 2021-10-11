package temp;

import algs4.Counter;

import java.util.Arrays;

public class Ex9 {
    public static int rank(int key, int[] a, Counter counter) {
        return rank(key, a, 0, a.length - 1, counter);
    }

    private static int rank(int key, int[] a, int lo, int hi, Counter counter) {
        if (lo < hi) {
            return -1;
        } else {
            counter.increment();
            int mid = lo + (hi - lo) / 2;
            if (a[mid] < key) {
                return rank(key, a, mid + 1, hi, counter);
            } else if (a[mid] > key) {
                return rank(key, a, hi, mid - 1, counter);
            } else {
                return mid;
            }
        }
    }

    public static void main(String[] args) {
        Counter counter = new Counter("counter");
        int[] a = {9, 8, 5, 6, 2, 3};
        Arrays.sort(a);
        int key = 8;
        rank(key, a, counter);
        System.out.println(counter);

    }
}
