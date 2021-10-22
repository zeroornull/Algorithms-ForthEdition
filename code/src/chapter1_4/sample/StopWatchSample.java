package chapter1_4.sample;

import algs4.StdOut;
import algs4.StdRandom;

public class StopWatchSample {
    public static void main(String[] args) {
        int N = Integer.parseInt("2000");
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform(-1_000_000, 1_000_000);
        }
        StopWatch timer = new StopWatch();
        int cnt = ThreeSum.count(a);
        double time = timer.elapsedTime();
        StdOut.println(cnt + " triples " + time + " seconds");
    }
}
