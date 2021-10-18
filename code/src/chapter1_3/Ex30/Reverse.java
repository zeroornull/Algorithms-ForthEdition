package chapter1_3.Ex30;


public class Reverse<Item> {

    public Node reverse(Node x) {
        Node first = x;
        Node reverse = null;
        while (first != null) {
            Node second = first.next;
            first.next = reverse;
            reverse = first;
            first = second;
        }
        return reverse;
    }

    public Node reverse1(Node first) {
        if (first == null) {
            return null;
        }
        if (first.next == null) {
            return first;
        }
        Node second = first.next;
        Node rest = reverse(second);
        second.next = first;
        first.next = null;
        return rest;
    }

    private class Node {
        Item item;
        Node next;
    }
}
