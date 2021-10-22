package chapter1_4;

import algs4.Point2D;
import algs4.StdDraw;
import algs4.StdOut;
import algs4.StdRandom;
import chapter1_4.sample.StopWatch;
import chapter1_4.sample.ThreeSum;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 含有报错 找不到位置所在
 */
public class Ex3_1 {
    private static List<Point2D> standardPlotPoints;
    private static List<Point2D> logLogPlotPoints;
    private static int currentXMaxScale;
    private static int currentYMaxScale;

    public static void main(String[] args) {
        currentXMaxScale = 50;
        currentYMaxScale = 5;
        initializeCanvas(currentXMaxScale, currentYMaxScale);
        standardPlotPoints = new ArrayList<>(5);
        logLogPlotPoints = new ArrayList<>(5);

        // Print table of running times
        for (int n = 250; true; n += n) {
            // print time for problem size n
            double time = timeTrail(n);
            rescaleIfNecessary(n, time);
            drawPointAndLine(n, time, standardPlotPoints, true, false);
            drawPointAndLine(Math.log(n), Math.log(time), logLogPlotPoints, false, false);
            StdOut.printf("%7d %5.1f\n", n, time);
        }
    }

    private static void rescaleIfNecessary(int n, double time) {
        if (n > currentXMaxScale || time > currentYMaxScale) {
            if (n > currentXMaxScale) {
                if (currentXMaxScale * 2 > n) {
                    currentXMaxScale = currentXMaxScale * 2;
                } else {
                    currentXMaxScale = (int) (1.5 * n);
                }
            }
            if (time > currentYMaxScale) {
                currentYMaxScale = currentYMaxScale * 2;
            }

            rescaleCanvas();
        }
    }

    public static double timeTrail(int n) {
        //
        int MAX = 1_000_000;
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = StdRandom.uniform(-MAX, MAX);
        }
        StopWatch timer = new StopWatch();
        int count = ThreeSum.count(array);
        return timer.elapsedTime();
    }

    private static void initializeCanvas(int currentXMaxScale, int currentYMaxScale) {
        StdDraw.setCanvasSize(300, 300);
        StdDraw.setXscale(0, currentXMaxScale);
        StdDraw.setYscale(0, currentYMaxScale);
        StdDraw.setPenRadius(.005);
    }

    private static void drawPointAndLine(double x, double y, List<Point2D> pointList, boolean isStandard, boolean isRescale) {
        if (y == Double.NEGATIVE_INFINITY) {
            y = 0;
        }

        Point2D point = new Point2D(x, y);
        if (!isRescale) {
            pointList.add(point);
        }
        if (isStandard) {
            StdDraw.setPenColor(Color.BLUE);
        } else {
            StdDraw.setPenColor(Color.GREEN);
        }

        if (pointList.size() > 1) {
            Point2D previousPoint = pointList.get(pointList.size() - 2);
            StdDraw.line(previousPoint.x(), previousPoint.y(), point.x(), point.y());
        }
        StdDraw.point(x, y);
    }

    private static void rescaleCanvas() {
        StdDraw.clear();
        StdDraw.setXscale(0, currentXMaxScale);
        StdDraw.setYscale(0, currentYMaxScale);
        //
        for (int i = 0; i < standardPlotPoints.size(); i++) {
            drawPointAndLine(standardPlotPoints.get(i).x(), standardPlotPoints.get(i).y(), standardPlotPoints, true, true);

        }
        for (int i = 0; i < logLogPlotPoints.size(); i++) {
            drawPointAndLine(logLogPlotPoints.get(i).x(), logLogPlotPoints.get(i).y(), logLogPlotPoints, false, false);
        }
    }
}
