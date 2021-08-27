package chapter1_1;

/**
 * @author xxp
 * @version 1.0
 * @date 2021-08-27 9:51
 **/
public class Ex30 {
    public static int checkPrimeNumber(int[][] a) {
        boolean[][] b = new boolean[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {

            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int N = 5;
        boolean[][] a = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (huzhi(i, j)) {
                    a[i][j] = true;
                }
                if (a[i][j]) {
                    System.out.print("#");
                } else {
                    System.out.print("@");
                }
            }
            System.out.println();
        }
    }

    public static boolean huzhi(int i, int j) {
        if (gcd(i, j) == 1) {
            return true;
        } else {
            return false;
        }
    }

    // 获得最大公约数
    public static int gcd(int p, int q) {
        if (q == 0) {
            return p;
        }
        int r = p % q;
        return gcd(q, r);
    }
}
