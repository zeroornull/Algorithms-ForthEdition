package chapter1_3.Ex40;

public class MoveToFront {
    private class Node {
        Character ch;
        Node next;
    }

    private Node first;
    private int N;

    public void push(Character ch) {
        ++N;
        Node oldfirst = first;
        first = new Node();
        first.ch = ch;
        first.next = oldfirst;
    }

    public boolean isRepeat(char ch) {
        for (Node x = first; x != null; x = x.next) {
            if (x.ch == ch) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void print() {
        for (Node x = first; x != null; x = x.next) {
            System.out.println(x.ch + " ");
        }
    }

    public void delete(char ch) {
        for (Node x = first; x != null; x = x.next) {
            if (x.next != null && x.next.ch == ch) {
                x.next = x.next.next;
                return;
            }
        }
    }

    public static void main(String[] args) {
        char[] chars = {'a', 'b', 'c', 'd', 'e', 'a', 'e'};
        MoveToFront link = new MoveToFront();
        int N = chars.length;
        for (char aChar : chars) {
            if (link.isRepeat(aChar)) {
                link.delete(aChar);
            }
            link.push(aChar);
        }
        link.print();
    }


}
