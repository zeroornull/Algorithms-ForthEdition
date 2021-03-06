package chapter1_3.Ex37;

import algs4.Queue;

public class JosephusCircle {
    public static void Josephus(int N, int M) {
        //N为人的个数,M为报到第几个死
        Queue<Integer> queue = new Queue<>();
        for (int i = 0; i < N; i++) {
            queue.enqueue(i);
        }
        for (int i = 0; i < N; i++) {
            //外循环表示最终都要打印N次,直到queue.size()为0
            for (int j = 0; j < M - 1; j++) {
                queue.enqueue(queue.dequeue());
            }
            System.out.print(queue.dequeue() + " ");
        }
    }

    public static void main(String[] args) {
        JosephusCircle.Josephus(7, 2);
    }
}
