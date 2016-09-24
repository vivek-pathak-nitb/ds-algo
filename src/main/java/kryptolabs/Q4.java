package kryptolabs;


public class Q4 {

    public static void main(String[] args) {
        if (args == null || args.length < 2) {
            return;
        }

        final int n = Integer.parseInt(args[0]);
        final int e = Integer.parseInt(args[1]);

        final Q4 q4 = new Q4();
        System.out.println("Minimum numbers of drops required are " + q4.calculate(n, e));
    }

    public int calculate(final int floors,
                         final int eggs) {

        final int memo[][] = new int[eggs + 1][floors + 1];

        int c;
        for (int i = 0; i <= floors; i++) {
            memo[1][i] = i;
        }

        for (int egg = 2; egg <= eggs; egg++) {
            for (int floor = 1; floor <= floors; floor++) {
                memo[egg][floor] = Integer.MAX_VALUE;
                for (int k = 1; k <= floor; k++) {
                    c = 1 + Math.max(memo[egg - 1][k - 1], memo[egg][floor - k]);
                    if (c < memo[egg][floor]) {
                        memo[egg][floor] = c;
                    }
                }
            }
        }

        return memo[eggs][floors];
    }
}
