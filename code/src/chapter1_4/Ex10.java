package chapter1_4;

import algs4.StdOut;


public class Ex10 {
    public static void main(String[] args) {
        int[] testArray1 = {3, 4, 4, 5, 6, 10, 15, 20, 20, 20, 20, 21};
        int elementToSearch1 = 4;
        int elementToSearch2 = 20;
        int elementToSearch3 = -5;

        StdOut.println("Binary search: " + binarySearchIterative(testArray1, elementToSearch1, 0, testArray1.length) +
                " Expected: 1");
        StdOut.println("Binary search: " + binarySearchIterative(testArray1, elementToSearch2, 0, testArray1.length) +
                " Expected: 7");
        StdOut.println("Binary search: " + binarySearchIterative(testArray1, elementToSearch3, 0, testArray1.length) +
                " Expected: -1");

        int[] testArray2 = {4, 4, 4, 4, 4, 4, 15, 20, 20, 20, 20, 21};
        int elementToSearch4 = 4;

        StdOut.println("Binary search: " + binarySearchIterative(testArray2, elementToSearch4, 0, testArray2.length) +
                " Expected: 0");
    }

    private static int binarySearch(int[] array, int element, int low, int high) {
        if (low > high) {
            return -1;
        }
        int middle = low + (high - low) / 2;
        if (array[middle] < element) {
            return binarySearch(array, element, middle + 1, high);
        } else if (array[middle] > element) {
            return binarySearch(array, element, low, middle - 1);
        } else {
            // equal 可能这个index 比较大 所以再去search 如果出现 low > high 则可以确定是middle 否则 返回的那个 possible 才是
            int possibleIndex = binarySearch(array, element, low, middle - 1);

            if (possibleIndex == -1) {
                return middle;
            } else {
                return possibleIndex;
            }
        }
    }

    private static int binarySearchIterative(int[] array, int element, int low, int high) {
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (array[middle] < element) {
                low = middle + 1;
            } else if (array[middle] > element || (middle > 0 && array[middle - 1] == element)) {
                high = middle - 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

}
