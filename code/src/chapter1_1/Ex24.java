package chapter1_1;

/**
 * @author xxp
 * @version 1.0
 * @date 2021-08-26 16:51
 **/
public class Ex24 {
    public static void main(String[] args) {
        System.out.println(gcd(1111111, 1234567));
    }

    public static int gcd(int p, int q) {
        System.out.println(p + " " + q);
        if (q == 0) {
            return p;
        }
        int r = p % q;
        return gcd(q, r);
    }
}
