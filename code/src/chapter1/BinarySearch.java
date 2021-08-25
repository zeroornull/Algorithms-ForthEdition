package chapter1;

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
            // 取整的方式 向下取整
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
        // 向下取整
        System.out.println(i/j);

        int i1 = 7;
        int j1 = 8;
        // 向下取整
        System.out.println(i1/j1);
        
    }

}
