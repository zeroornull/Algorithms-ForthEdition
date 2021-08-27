package chapter1_1;

import java.util.Scanner;

/**
 * @author xxp
 * @version 1.0
 * @date 2021-08-26 16:23
 **/
public class Ex21 {

    public static void main(String[] args) {
        System.out.println("input ");
        String[] array = new String[100];
        int i = 0;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            array[i++] = scanner.nextLine();
        }
        System.out.println();

        for (int j = 0; j < i; j++) {
            String [] strings=array[j].split(" ");
            String string1=strings[0];
            int x=Integer.parseInt(strings[1]);
            int y=Integer.parseInt(strings[2]);
            System.out.printf("%s  %d  %d  %.3f \n",string1,x,y,1.0*x/y);
        }


    }
}
