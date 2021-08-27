package chapter1_1;

/**
 * @author xxp
 * @version 1.0
 * @date 2021-08-26 16:07
 **/
public class Ex18 {
    public static void main(String[] args) {
        System.out.println(mystery(2, 25));
        System.out.println(mystery(3, 11));
    }

    public static int mystery(int a, int b) {
        if (b == 0) {
            return 0;
        }
        if (b % 2 == 0) {
            return mystery(a + a, b / 2);
        }
        return mystery(a + a, b / 2) + a;
    }
}
