package chapter1_4;

import algs4.In;
import algs4.StdOut;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * a. O(N)
 * b. O(N)
 * c. O(N log(N))
 */
public class Ex6 {

    public static void main(String[] args) {
//        In in = new In(args[0]);
//        int[] values = in.readAllInts();
//        StdOut.println(countNumberOfPairs(values));

        // Tests
        int[] values1 = {1, 2, 4, 1, 2, 1, 2, 4, 5, 1, 2, 4, 5, 1, 2, 5, 6, 7, 7, 8, 2, 1, 2, 4, 5};
        StdOut.println("Equal pairs 1: " + countNumberOfPairs2(values1) + " Expected: 49");

        int[] values2 = {1, 1, 1};
        StdOut.println("Equal pairs 2: " + countNumberOfPairs2(values2) + " Expected: 3");
    }

    private static int countNumberOfPairs(int[] values) {
        Arrays.sort(values);

        int count = 0;
        int currentFrequency = 1;

        // 从0开始比较，故应该从索引1开始 否则下表会小于0
        for (int i = 1; i < values.length; i++) {
            if (values[i] == values[i - 1]) {
                currentFrequency++;
            } else {
                if (currentFrequency > 1) {
                    // 相同数字有多少种组合方式 的方程 n-1 + 。。。 + 1 既C 2 n 公式即组合公式 （n！）/（2！*（n-2）！）
                    count += currentFrequency * (currentFrequency - 1) / 2;
                    // 重置相同数字计数
                    currentFrequency = 1;
                }
            }

        }
        // 最后还有一次判断
        if (currentFrequency > 1) {
            count += currentFrequency * (currentFrequency - 1) / 2;
        }

        return count;
    }

    private static int countNumberOfPairs2(int[] values) {
        Map<Integer, Integer> valuesMap = new HashMap<>();
        int equalNumbersCount = 0;
        for (int value : values) {
            int count = 0;
            // 从索引0开始
            if (valuesMap.containsKey(value)) {
                count = valuesMap.get(value);
            }
            count++;
            valuesMap.put(value, count);
        }
        for (Integer integer : valuesMap.keySet()) {
            if (valuesMap.get(integer) > 1) {
                int n = valuesMap.get(integer);
                equalNumbersCount += n;
            }
        }
        return equalNumbersCount;
    }


}
