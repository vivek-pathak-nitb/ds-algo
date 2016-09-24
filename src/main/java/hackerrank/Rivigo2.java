package hackerrank;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vivek.pathak on 31/05/16.
 */
public class Rivigo2 {

    public static void main(String[] args) {
        System.out.println(canReach(1, 2, 2, 1));
    }

    static String canReach(int a, int b, int c, int d) {
        final Map<Integer, Integer> memo = new HashMap<>();
        if (canReachUtil(a, b, c, d, memo)) {
            return "Yes";
        }

        return "No";
    }

    static boolean canReachUtil(final int a,
                                final int b,
                                final int c,
                                final int d,
                                final Map<Integer, Integer> memo) {
        if (a == c && b == d) {
            return true;
        }

        if (a > c || b > d) {
            return false;
        }

        if (memo.containsKey(a) && memo.get(a) == b) {
            return false;
        }

        memo.put(a, b);

        return canReachUtil(a + b, b, c, d, memo) || canReachUtil(a, a + b, c, d, memo);
    }
}
