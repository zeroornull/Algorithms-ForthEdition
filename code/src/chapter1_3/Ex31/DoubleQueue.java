package chapter1_3.Ex31;

public class DoubleQueue<Item> {

    private DoubleNode<Item> first;
    private DoubleNode<Item> last;


    private static class DoubleNode<E> {
        public E item;
        public DoubleNode<E> prev;
        public DoubleNode<E> next;

    }

    public static <T> void insertFirst(DoubleQueue<T> doubleQueue, T item) {
        DoubleNode<T> node = new DoubleNode<>();
        node.item = item;
        node.prev = null;
        node.next = doubleQueue.first;
        if (doubleQueue.first == null) {
            doubleQueue.first = node;
            doubleQueue.last = node;
        } else {
            //
            // 调整指向
            doubleQueue.first.prev = node;
            // 调整first
            doubleQueue.first = node;
        }
    }

    public static <T> void insertLast(DoubleQueue<T> doubleQueue, T item) {
        DoubleNode<T> node = new DoubleNode<>();
        node.item = item;
        node.prev = doubleQueue.last;
        node.next = null;
        if (doubleQueue.last == null) {
            doubleQueue.first = node;
            doubleQueue.last = node;
        } else {
            doubleQueue.last.next = node;
            doubleQueue.last = node;
        }
    }

    public static <T> void deleteFirst(DoubleQueue<T> doubleQueue) {
        if (doubleQueue.first == null) {
            throw new RuntimeException();
        }
        if (doubleQueue.first == doubleQueue.last) {
            doubleQueue.first = null;
            doubleQueue.last = null;
        } else {
            doubleQueue.first = doubleQueue.first.next;
            doubleQueue.first.prev.next = null;
            doubleQueue.first.prev = null;
        }
    }

    public static <T> void deleteLast(DoubleQueue<T> doubleQueue) {
        if (doubleQueue.last == null) {
            throw new RuntimeException();
        }
        if (doubleQueue.last == doubleQueue.first) {
            doubleQueue.first = null;
            doubleQueue.last = null;
        } else {
            doubleQueue.last = doubleQueue.last.prev;
            doubleQueue.last.next.prev = null;
            doubleQueue.last.next = null;
        }
    }


    /**
     * 将值插入到某个节点前
     *
     * @param doubleQueue
     * @param node
     * @param item
     * @param <T>
     */
    public static <T> void insertBefore(DoubleQueue<T> doubleQueue, DoubleNode<T> node, T item) {
        if (node == null)
            return;
        if (doubleQueue.first == node)
            insertFirst(doubleQueue, item);
        else {
            DoubleNode<T> newNode = new DoubleNode<>();
            newNode.item = item;
            newNode.prev = node.prev;
            newNode.next = node;
            node.prev.next = newNode;
            node.prev = newNode;
        }
    }

    /**
     * 将值插入到某个节点后
     *
     * @param doubleQueue
     * @param node
     * @param item
     * @param <T>
     */
    public static <T> void insertAfter(DoubleQueue<T> doubleQueue, DoubleNode<T> node, T item) {
        if (node == null)
            return;
        if (doubleQueue.last == node)
            insertLast(doubleQueue, item);
        else {
            DoubleNode<T> newNode = new DoubleNode<>();
            newNode.item = item;
            newNode.prev = node;
            newNode.next = node.next;
            node.next.prev = newNode;
            node.next = newNode;
        }
    }

    public static <T> void deleteNode(DoubleQueue<T> doubleQueue, DoubleNode<T> node) {
        if (node == null)
            return;
        else if (node == doubleQueue.first)
            deleteFirst(doubleQueue);
        else if (node == doubleQueue.last)
            deleteLast(doubleQueue);
        else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = null;
            node.next = null;
        }
    }

    public static <T> void print(DoubleQueue<T> doubleQueue) {
        for (DoubleNode<T> x = doubleQueue.first; x != null; x = x.next) {
            System.out.println(x.item);
        }
    }

}
