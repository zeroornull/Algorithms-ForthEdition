package temp;

public class Ex6 {
    public static void main(String[] args) {
        String s = "ACTGACG";
        String t = "TGACGAC";
        String temp = s + s;
        if (temp.indexOf(t) != -1) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
