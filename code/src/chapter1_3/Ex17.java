package chapter1_3;


import algs4.In;
import algs4.Queue;
import temp.Transaction;

import java.text.ParseException;

public class Ex17 {
    public static Transaction[] readTransactions(String name) throws ParseException {
        In in = new In(name);
        Queue<Transaction> queue = new Queue<>();
        while (!in.isEmpty()) {
            queue.enqueue(new Transaction(in.readLine()));
        }
        int N = queue.size();
        Transaction[] transactions = new Transaction[N];
        for (int i = 0; i < N; i++) {
            transactions[i] = queue.dequeue();
        }
        return transactions;
    }
}
