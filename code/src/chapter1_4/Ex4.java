package chapter1_4;
/*
1.4.4

Statement in Block    Time in seconds         Frequency           Total time
        D                   t0           x(depends on input)           t0x
        C                   t1                N^2/2 - N/2          t1(N^2/2 - N/2)
        B                   t2                    N                    t2N
        A                   t3                    1                     t3
Grand total: (t1/2) N^2
               + (-t1/2 + t2) N
                 + t3 + t0x
Tilde approximation: ~(t1/2) N^2 (assuming x is small)
Order of growth: N^2
* */
public class Ex4 {
}
