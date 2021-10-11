package temp;

import algs4.StdDraw;

public class VisualCounter {
    private int count;
    private int operator;
    private int N;
    private int max;

    public VisualCounter(int N, int max) {
        this.N = N;
        this.max = Math.abs(max);
        StdDraw.setXscale(0, N + 1);
        StdDraw.setYscale(-max * 2, max * 2);
        StdDraw.setPenRadius(0.05);
    }

    public void increment() {
        operator++;
        count++;
        StdDraw.point(operator, count);
        if (operator > N || Math.abs(count) > max) {
            throw new RuntimeException();
        }
    }

    public void decline() {
        operator++;
        count--;
        StdDraw.point(operator, count);
        if (operator > N || Math.abs(count) > max) {
            throw new RuntimeException();
        }
    }

    public int tally() {
        return count;
    }

    public String toString() {
        return "操作了:" + operator + "次，此时count为：" + count;
    }

    public static void main(String[] args) {
        int N = 5;
        int max = 3;
        VisualCounter visualCounter = new VisualCounter(N, max);
        visualCounter.increment();
        visualCounter.increment();
        visualCounter.increment();
        visualCounter.decline();
        visualCounter.decline();
        System.out.println(visualCounter);
    }

}
