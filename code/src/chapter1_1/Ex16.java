package chapter1_1;

/**
 * @author xxp
 * @version 1.0
 * @date 2021-08-26 16:02
 **/
public class Ex16 {
    public static String exR1(int n){
        if (n<=0){
            return "";
        }
        return exR1(n-3) + n + exR1(n-2) + n;
    }

    public static void main(String[] args) {
        System.out.println(exR1(6));
    }
}
