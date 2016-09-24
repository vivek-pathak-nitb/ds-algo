package hackerrank;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.Vector;

/**
 * Created by vivek.pathak on 20/05/16.
 */
public class Adobe {

    static int isSumPossible(Vector<Integer> a, int N) {
        final Set<Integer> set = new HashSet<>();
        for (int num : a) {
            int temp = Math.abs(N - num);
            if (set.contains(temp)) {
                return 1;
            } else {
                set.add(num);
            }

        }
        return 0;
    }

    static int isIntegerPalindrome(int a) {
        String str = "" + a;
        final StringBuilder sb = new StringBuilder(str);
        if (str.equals(sb.reverse().toString())) {
            return 1;
        }
        return 0;
    }

    static int maxOnes(int[][] a, int N) {
        int res = Integer.MIN_VALUE;
        int rowToReturn = 0;
        int rows = a.length;
        int cols = a[0].length;
        for (int i = 0; i < rows; i++) {
            int count = 0;
            for (int j = 0; j < cols; j++) {
                if (a[i][j] == 1) {
                    count++;
                } else {
                    if (count > res) {
                        res = count;
                        rowToReturn = i;
                        break;
                    }
                }
            }
        }
        return rowToReturn;
    }

    static String smallestMultiple(int a) {
        int count = 1, rem = 1;
        while (rem != 0) {
            rem = (rem * 10 + 1) % a;
            count++;
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (count-- != 0) {
            stringBuilder.append("1");
        }

        return stringBuilder.toString();
    }


    public static boolean isValid(String s) {
        final Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');


        final Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (Character.isDigit(curr)) {
                continue;
            }

            if (map.keySet().contains(curr)) {
                stack.push(curr);
            } else if (map.values().contains(curr)) {
                if (!stack.empty() && map.get(stack.peek()) == curr) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.empty();
    }
}
