package chapter1_1;

import algs4.StdDraw;
import algs4.StdRandom;

/**
 * @author xxp
 * @version 1.0
 * @date 2021-08-27 10:00
 **/
public class Ex31 {
    private static class Point {
        private double x;
        private double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        int N = 7;
        double p = 0.5;
        StdDraw.setPenRadius(0.005);
        double x0 = 0.5, y0 = 0.5, r = 0.3;
        StdDraw.circle(x0, y0, r);
        StdDraw.setPenRadius(0.05);
        Point[] points = new Point[N];
        for (int i = 0; i < N; i++) {
            double angle = i * 2 * Math.PI / N;
            double x = x0 + r * Math.sin(angle);
            double y = y0 + r * Math.cos(angle);
            points[i] = new Point(x, y);
            StdDraw.point(points[i].x, points[i].y);
        }
        StdDraw.setPenRadius(0.005);
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (StdRandom.bernoulli(p)) {
                    StdDraw.line(points[i].x, points[i].y, points[j].x, points[j].y);
                }
            }
        }
    }

}
