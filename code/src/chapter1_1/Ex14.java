package chapter1_1;

import algs4.StdOut;

/**
 * @author xxp
 * @version 1.0
 * @date 2021-08-26 12:16
 **/
public class Ex14 {

    public static void main(String[] args) {
        StdOut.print(lg(8));
    }

    public static Integer lg(Integer N) {
        int i = 0;
        // 从0开始遍历 直到大于N
        while (n2(i) <= N) {
            i++;
        }
        // 最后返回大于N的前一个数字
        return i - 1;
    }

    /**
     * @param n
     * @return
     */
    public static int n2(int n) {
        int result = 1;
        for (int i = 0; i < n; i++) {
            result *= 2;

        }
        return result;
    }

}
