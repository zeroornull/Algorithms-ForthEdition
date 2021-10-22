package chapter1_3.Ex43;

import algs4.Queue;

import java.io.File;

public class PrintFileName {
    public static void print(String path, int depth, Queue<String> queue) {
        File file = new File(path);
        File[] list = file.listFiles();
        for (File newFile : list) {
            StringBuilder s = new StringBuilder("    ");
            for (int i = 0; i < depth; i++) {
                s.append("    ");
            }
            s.append(newFile.getName());
            queue.enqueue(s.toString());
            if (newFile.isDirectory()) {
                print(newFile.getAbsolutePath(), depth + 1, queue);
            }

        }
    }

    public static void main(String[] args) {
        String path = "D:\\DingDingDownload";
        Queue<String> queue = new Queue<>();
        queue.enqueue(path);
        print(path, 0, queue);
        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
    }
}
