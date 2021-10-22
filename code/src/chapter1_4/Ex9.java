package chapter1_4;

/**
 * 1.4.9
 * <p>
 * Example:
 * <p>
 * T(16) = ?
 * T(2) = T(1) * 2^b
 * T(4) = T(2) * 2^b
 * T(8) = T(4) * 2^b
 * etc
 * <p>
 * so, we have that
 * T(16) = T(1) * 2^b * 2^b * 2^b * 2^b
 * which is equal to:
 * T(16) = T(1) * ((2^b)^lgN)
 * <p>
 * For a problem of size N:
 * <p>
 * T(N0) = T = T * ((2^b)^lg1) = T * 1^b
 * T(2 * N0) = T * 2^b = T * ((2^b)^lg2) = T * 2^b
 * T(4 * N0) = T * 2^b * 2^b = T * ((2^b)^lg4) = T * 4^b
 * T(8 * N0) = T * 2^b * 2^b * 2^b = T * ((2^b)^lg8) = T * 8^b
 * T(16 * N0) = T * 2^b * 2^b * 2^b * 2^b = T * ((2^b)^lg16) = T * 16^b
 * <p>
 * Thus, we have:
 * T(N) = T * (N / N0)^b
 * <p>
 * Thanks to luowyang (https://github.com/luowyang) for the correct solution to this exercise:
 * https://github.com/reneargento/algorithms-sedgewick-wayne/issues/93
 */
public class Ex9 {
}
