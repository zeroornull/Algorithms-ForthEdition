package chapter1_3;

import algs4.Queue;

import java.util.Scanner;

public class Ex15 {
    public static void main1(String[] args) {
        Queue<String> queue = new Queue<>();
        int k = Integer.parseInt(args[0]);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            queue.enqueue(scanner.next());
        }
        int N = queue.size();
        for (int i = 0; i < N - k; i++) {
            queue.dequeue();
        }
        System.out.println(queue.dequeue());
    }

    public static void main(String[] args) {
        //假设倒数第k个中,k从1开始
        Queue<String> queue = new Queue<>();
        int k = Integer.parseInt(args[0]);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            queue.enqueue(scanner.next());
        }
        int N = queue.size();
        for (int i = 0; i < N - k; i++) {
            queue.dequeue();
        }
        System.out.println(queue.dequeue());
    }
}
