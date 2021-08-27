package chapter1_1;

/**
 * @author xxp
 * @version 1.0
 * @date 2021-08-26 18:00
 **/
public class Ex27 {

    private static final int N = 20;
    private static final int k = 10;
    private static double[][] temp = new double[N + 1][k + 1];
    private static int count = 0;


    public static void main(String[] args) {
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[0].length; j++) {
                temp[i][j] = -1.0;
            }
        }
        System.out.println(binomial(N, k, 0.25));
        System.out.println(count);

    }

    public static double binomial(int N, int k, double p) {
        count++;
        if (N < 0 || k < 0) {
            return 0.0;
        } else if (N == 0 && k == 0) {
            if (temp[N][k] == -1.0) {
                temp[N][k] = 1.0;
            }
        } else {
            if (temp[N][k] == -1.0) {
                temp[N][k] = (1.0 - p) * binomial(N - 1, k, p) + p * binomial(N - 1, k - 1, p);
            }
        }
        return temp[N][k];
    }

}
