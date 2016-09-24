package kryptolabs;


import java.util.Random;

public class Q3 {

    private Random random = new Random();

    public static void main(String[] args) {
        final Q3 q3 = new Q3();
        System.out.print(q3.rand7());
    }

    private int rand7() {
        int s = 0, c = 7;
        while (c-- > 0) {
            s += rand5();
        }
        return s % 7 + 1;
    }

    private int rand5() {
        return random.nextInt(5) + 1;
    }
}
