package chapter1_3;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class Ex12<Item> implements Iterable<Item> {


    private int N;
    private Item[] a;

    public Ex12() {
        a = (Item[]) new Object[1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        if (N == a.length) {
            resize(2 * a.length);
        }
        a[N++] = item;
    }

    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    public Item pop() {
        Item item = a[--N];
        a[N] = null;
        if (N > 0 && N == a.length / 4) {
            resize(a.length / 2);
        }
        return item;
    }

    public Item peek() {
        return a[N - 1];
    }

    public static Stack<String> copy(Stack<String> stack) {
        Stack<String> stack1 = new Stack<>();
        Stack<String> stack2 = new Stack<>();
        for (String s : stack) {
            stack1.push(s);
        }
        for (String s : stack1) {
            stack2.push(s);
        }
        return stack2;
    }

    public static void main(String[] args) {

    }

    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            int i = N;

            @Override
            public boolean hasNext() {
                return i > 0;
            }


            @Override
            public Item next() {
                if (i == 0) {
                    throw new NoSuchElementException();
                }
                return a[--i];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
