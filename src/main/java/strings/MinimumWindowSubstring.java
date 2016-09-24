package strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by vivek.pathak on 18/05/16.
 */
public class MinimumWindowSubstring {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String mainString = scanner.nextLine();
        final String patternString = scanner.nextLine();
        minimumWindowSubstring(mainString, patternString);
    }

    public static void minimumWindowSubstring(final String str, final String subStr) {
        final Map<Character, Integer> subStrCountMap = new HashMap<>();
        final Map<Character, Integer> strCountMap = new HashMap<>();

        // populating subStrCount map
        for (int i = 0; i < subStr.length(); i++) {
            if (subStrCountMap.containsKey(subStr.charAt(i))) {
                subStrCountMap.put(subStr.charAt(i), subStrCountMap.get(subStr.charAt(i)) + 1);
            } else {
                subStrCountMap.put(subStr.charAt(i), 1);
            }
        }

        int minLen = Integer.MAX_VALUE;
        int count = 0;
        int start = 0;
        for (int i = 0; i < str.length(); i++) {
            final char c = str.charAt(i);
            if (subStrCountMap.containsKey(c)) {
                if (!strCountMap.containsKey(c)) {
                    strCountMap.put(c, 1);
                    count++;
                } else {
                    if (strCountMap.get(c) < subStrCountMap.get(c)) {
                        strCountMap.put(c, strCountMap.get(c) + 1);
                        count++;
                    } else {
                        strCountMap.put(c, strCountMap.get(c) + 1);
                    }
                }
            }

            if (count == subStr.length()) {
                char c1 = str.charAt(start);
                while (!subStrCountMap.containsKey(c1) || (subStrCountMap.get(c1) < strCountMap.get(c1))) {
                    if (strCountMap.containsKey(c1) && strCountMap.get(c1) > subStrCountMap.get(c1))
                        strCountMap.put(c1, strCountMap.get(c1) - 1);
                    start++;
                    c1 = str.charAt(start);
                }

                minLen = Math.min(minLen, i - start + 1);

            }
        }

        System.out.println(minLen);

    }
}
