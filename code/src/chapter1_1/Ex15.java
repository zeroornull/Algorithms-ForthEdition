package chapter1_1;

import algs4.StdOut;

/**
 * 这个题目没看懂。。。
 * 
 * @author xxp
 * @version 1.0
 * @date 2021-08-26 12:55
 **/
public class Ex15 {

    public static void main(String[] args) {
        int[] arr  ={0,1,1,1};
        int[] timesArr = histogram(arr, 2);
        for (int i = 0; i < timesArr.length; i++) {
            StdOut.printf("%d", timesArr[i]);
        }
    }
    
    public static int[] histogram(int[] a, Integer M) {
        int[] arr = new int[M];
        for (int i = 0; i < M; i++) {
            int times = 0;
            for (int j = 0; j < a.length; j++) {
                if (a[j] == i) {
                    times++;
                }
                arr[i] = times;
            }
            arr[i] = times;
        }
        return arr;
    }
}
