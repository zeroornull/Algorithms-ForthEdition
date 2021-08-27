package chapter1_1;

import java.util.Arrays;

/**
 * @author xxp
 * @version 1.0
 * @date 2021-08-26 18:06
 **/
public class Ex28 {

    public static void main(String[] args) {
        int[] whitelist = {0, 0, 1, 1, 1, 2, 3, 4, 4, 6, 6, 7, 8, 7, 5};
        Arrays.sort(whitelist);
        int repeat = 0;// calculate count repeat
        for (int i = 1; i < whitelist.length; i++) {
            if (whitelist[i] == whitelist[i - 1]) {
                repeat++;
            }
        }
        int[] noRepeat = new int[whitelist.length - repeat];
        noRepeat[0] = whitelist[0];
        int temp = 1;
        for (int j = 1; j < whitelist.length; j++) {
            if (whitelist[j] != whitelist[j - 1]) {
                // 将不重复的add进去
                noRepeat[temp++] = whitelist[j];
            }
        }
        for (int i = 0; i < noRepeat.length; i++) {
            System.out.print(noRepeat[i] + " ");
        }
    }

//    public static void main(String[] args) {
//        int[] whitelist = {0, 0, 1, 1, 1, 2, 3, 4, 4, 6, 6, 7, 8, 7, 5};
//        Arrays.sort(whitelist);
//        int repeat = 0;//计算有多少重复的
//        for (int i = 1; i < whitelist.length; i++) {
//            if (whitelist[i] == whitelist[i - 1])
//                repeat++;
//        }
//        //新建一个数组存不重复的
//        int[] noRepeat = new int[whitelist.length - repeat];
//        noRepeat[0] = whitelist[0];
//        int temp = 1;
//        for (int j = 1; j < whitelist.length; j++) {
//            if (whitelist[j] != whitelist[j - 1])
//                noRepeat[temp++] = whitelist[j];
//        }
//        for (int i = 0; i < noRepeat.length; i++) {
//            System.out.print(noRepeat[i] + " ");
//        }
//    }

}
