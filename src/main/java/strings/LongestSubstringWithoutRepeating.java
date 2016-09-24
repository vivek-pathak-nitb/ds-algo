package strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by vivek.pathak on 18/05/16.
 */
public class LongestSubstringWithoutRepeating {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String str = scanner.nextLine();
        int start = 0;
        int res = Integer.MIN_VALUE;
        final Map<Character, Integer> charToCountMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            final char c = str.charAt(i);
            if (charToCountMap.containsKey(c)) {
                res = Math.max(res, i - start);
                start = charToCountMap.get(c) + 1;
                charToCountMap.remove(c);
            }
            charToCountMap.put(c, i);
        }
    }
}
