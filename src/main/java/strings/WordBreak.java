package strings;

import com.google.common.collect.Sets;

import java.util.Set;

/**
 * Created by vivek.pathak on 11/09/16.
 */
public class WordBreak {

    private static final Set<String> DICTIONARY = Sets.newHashSet("cat", "cats", "and", "sand", "dog");


    private boolean isPossible(final String str) {
        if (str == null || str.length() == 0) {
            return true;
        }

        final boolean[] memo = new boolean[str.length() + 1];
        memo[str.length()] = true;

        for (int i = str.length() - 1; i >= 0; i--) {
            for (int j = i; j < str.length(); j++) {
                if (memo[j + 1] && DICTIONARY.contains(str.substring(i, j + 1))) {
                    memo[i] = true;
                    break;
                }
            }
        }

        return memo[0];
    }

    private String generateWords(final String str) {
        if (str == null || str.length() == 0) {
            return "";
        }

        if (!isPossible(str)) {
            return "";
        }

        return generateWordsUtil(0, "", str);
    }


    private String generateWordsUtil(int startIndex, final String path, final String str) {
        if (str == null || str.length() == 0) {
            return path;
        }

        if (startIndex > str.length()) {
            return path;
        }

        String test = "";
        for (int i = startIndex; i < str.length(); i++) {
            test = test + str.substring(startIndex, i + 1);
            if (DICTIONARY.contains(test)) {
                return generateWordsUtil(i + 1, path + " " + test, str.substring(i + 1));
            }
        }

        return path;
    }

    public static void main(String[] args) {
        System.out.println(new WordBreak().isPossible("catanddog"));
    }
}
