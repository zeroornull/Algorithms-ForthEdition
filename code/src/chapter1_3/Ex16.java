package chapter1_3;

import algs4.In;
import algs4.Queue;

import java.util.Date;

public class Ex16 {
    public static Date[] readDates(String name) {
        In in = new In(name);
        Queue<Date> queue = new Queue<>();
        while (!in.isEmpty()) {
            queue.enqueue(new Date(in.readString()));
        }
        int N = queue.size();
        Date[] dates = new Date[N];
        for (int i = 0; i < N; i++) {
            dates[i] = queue.dequeue();
        }
        return dates;
    }

    public static void main(String[] args) {
    }

}
