package chapter1_4.sample;

import algs4.StdOut;
import algs4.StdRandom;

public class DoublingTest {

    public static double timeTrail(int N) {
        // deal six Integer
        int MAX = 1_000_000;
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform(-MAX, MAX);
        }
        StopWatch timer = new StopWatch();
        int cnt = ThreeSum.count(a);
        return timer.elapsedTime();
    }

    public static void main(String[] args) {
        for (int N = 250; true; N += N) {
            double time = timeTrail(N);
            StdOut.printf("%7d %5.1f\n", N, time);
        }
    }
}
