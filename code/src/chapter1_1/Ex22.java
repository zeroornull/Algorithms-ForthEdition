package chapter1_1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author xxp
 * @version 1.0
 * @date 2021-08-26 16:46
 **/
public class Ex22 {
    private static int high = 0;

    public static int rank(int key, int[] a) {
        return rank(key, a, 0, a.length - 1, high);//开始时深度为0
    }

    public static int rank(int key, int[] a, int lo, int hi, int high) {
        System.out.println("high:" + high + "  lo:" + lo + "  hi:" + hi);
        if (hi < lo)
            return -1;
        int mid = lo + (hi - lo) / 2;
        if (a[mid] < key)
            return rank(key, a, mid + 1, hi, high + 1);
        else if (a[mid] > key)
            return rank(key, a, lo, mid - 1, high + 1);
        else
            return mid;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("先输入+/-，再输入要查询的");
        String pattern = scanner.nextLine();
        int[] whitelist = {1, 2, 5, 4, 9, 3, 1, 2, 3, 7};
        Arrays.sort(whitelist);
        while (scanner.hasNext()) {
            int key = scanner.nextInt();
            if (pattern == "+") {
                if (rank(key, whitelist) == -1) {
                    System.out.println(key);
                }
            } else {
                if (rank(key, whitelist) != -1) {
                    System.out.println(key);
                }
            }
        }
    }
}
