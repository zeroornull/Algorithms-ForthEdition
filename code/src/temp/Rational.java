package temp;

public class Rational {
    private final long x;
    private final long y;

    public Rational(long x, long y) {
        if (y == 0) {
            throw new RuntimeException();
        }
        long gcd = gcd(x, y);
        //
        if (x < 0 && y < 0) {
            x = -x;
            y = -y;
        } else if (x > 0 && y < 0) {
            x = -x;
            y = -y;
        }
        this.x = x / gcd;
        this.y = y / gcd;
        if (gcd(this.x, this.y) != 1 && gcd(this.x, this.y) != this.y)// 如果x=0,gcd会等于y,否则等于1,y不可能等于0
            throw new RuntimeException();
        assert isLegal();
    }

    public Rational plus(Rational b) {
        long y = this.y * b.y;
        long x = this.x * b.y + this.y * b.x;
        assert isLegal();
        return new Rational(x, y);
    }

    public Rational minus(Rational b) {
        long y = this.y * b.y;
        long x = this.x * b.y - this.y * b.x;
        assert isLegal();
        return new Rational(x, y);
    }

    public Rational times(Rational b) {
        long y = this.y * b.y;
        long x = this.x * b.x;
        assert isLegal();
        Rational plus = new Rational(x, y);
        return plus;
    }

    public Rational divides(Rational b) {
        long y = this.y * b.x;
        long x = this.x * b.y;
        assert isLegal();
        Rational plus = new Rational(x, y);
        return plus;
    }

    public String toString() {
        if (x == 0)
            return "0";
        if (y == 1)
            return x + "";
        return x + "/" + y;
    }

    public boolean equals(Rational that) {
        if (this == that)
            return true;
        if (that == null)
            return false;
        if (this.x != that.x)
            return false;
        if (this.y != that.y)
            return false;
        return true;
    }

    private boolean isLegal() {
        if (x < Long.MIN_VALUE || x > Long.MAX_VALUE) {
            return false;
        }
        if (y < Long.MIN_VALUE || y > Long.MAX_VALUE) {
            return false;
        }
        return true;
    }

    // 反复取余得到公因子
    private long gcd(long p, long q) {
        if (p < 0) {
            p = -p;
        }
        if (q < 0) {
            q = -q;
        }
        if (q == 0) {
            return p;
        }
        long r = p % q;
        return gcd(q, r);
    }

    public static void main(String[] args) {
        Rational rational = new Rational(-10, 7);
        Rational rational1 = new Rational(5, -10);
        Rational rational2 = new Rational(-1, 2);
        System.out.println(rational);
        System.out.println(rational1);
        System.out.println(rational1.equals(rational2));
        System.out.println(rational1.plus(rational));
        System.out.println(rational1.minus(rational));
        System.out.println(rational1.times(rational));
        System.out.println(rational1.divides(rational));
    }
}
