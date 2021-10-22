package chapter1_4;

import algs4.StdOut;

import javax.swing.*;
import java.util.Arrays;

public class Ex11 {

    private int[] array;

    public Ex11(int[] keys) {
        array = new int[keys.length];
        // defensive copy
        System.arraycopy(keys, 0, array, 0, keys.length);
        Arrays.sort(array);
    }

    public static void main(String[] args) {
        int[] array = {2, 4, 8, 16, 16, 16, 32, 64, 128, 128};
        Ex11 ex11 = new Ex11(array);

        StdOut.println("How many 2: " + ex11.howMany(2) + " Expected: 1");
        StdOut.println("How many 16: " + ex11.howMany(16) + " Expected: 3");
        StdOut.println("How many 128: " + ex11.howMany(128) + " Expected: 2");
        StdOut.println("How many -99: " + ex11.howMany(-99) + " Expected: 0");
    }


    public boolean contains(int key) {
        // return index of key
        // if not present,must be -1
        return rank(key) != -1;
    }

    // return index of key
    // if not present,must be -1
    private int rank(int key) {
        // Binary search
        int low = 0;
        int high = array.length - 1;
        while (low < high) {
            // Key is in a[low.length] or not present
            int mid = low + (high - low) / 2;
            if (key < array[mid]) {
                high = mid - 1;
            } else if (key > array[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    private int recursiveRank(int key, int low, int high) {
        int middle = low + (high - low) / 2;
        if (low > high) {
            return -1;
        }
        if (array[middle] > key) {
            return recursiveRank(key, low, middle - 1);
        } else if (array[middle] < key) {
            return recursiveRank(key, middle + 1, high);
        } else {
            return middle;
        }
    }

    /**
     * O(log n)
     *
     * @param key
     * @return
     */
    private int howMany(int key) {
        int indexFromRank = rank(key);
        if (indexFromRank == -1) {
            return 0;
        }
        int count;
        int previousIndex = indexFromRank;
        int currentPreviousIndex = previousIndex;
        int nextIndex = indexFromRank;
        int currentNextIndex = nextIndex;

        // find the smallest index of an element;
        while (currentPreviousIndex != -1) {
            currentPreviousIndex = recursiveRank(key, 0, currentPreviousIndex - 1);
            if (currentPreviousIndex != -1) {
                previousIndex = currentPreviousIndex;
            }
        }
        // find the highest index of an element
        while (currentNextIndex != -1) {
            currentNextIndex = recursiveRank(key, currentNextIndex + 1, array.length - 1);
            if (currentNextIndex != -1) {
                nextIndex = currentNextIndex;
            }
        }


        count = (nextIndex - previousIndex) + 1;

        /* O(n)
        //count would have been initialized to 1
        while (previousIndex - 1 >= 0 && a[previousIndex - 1] == key) {
            count++;
            previousIndex--;
        }
        while (nextIndex + 1 < array.length && a[nextIndex + 1] == key) {
            count++;
            nextIndex++;
        }*/


        return count;


    }


}
