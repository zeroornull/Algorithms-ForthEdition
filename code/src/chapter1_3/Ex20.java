package chapter1_3;

public class Ex20 {
    public static void main(String[] args) {
        int i = 1;
//        delete(i);
    }

    /* 鏈表
    private static void delete(int i) {
        if (first == null || i <= 0) {
            throw new RuntimeException();
        }
        if (i == 1) {
            first = first.next;
            return;
        }
        --k;
        Node current = first;
        while (current != null && --k > 0) {
            current = current.next;
        }
        if (current == null || current.next == null) {
            throw new RuntimeException();
        }
        current.next = current.next.next;
    }*/


}
