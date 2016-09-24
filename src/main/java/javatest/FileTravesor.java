package javatest;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by vivek.pathak on 07/05/16.
 */
public class FileTravesor {
    public static void main(String[] args) {
        System.out.println(reverseUsingRec("vivek"));
    }

    private static void recurUtil(final String fileName) {
        final File a = new File(fileName);
        if (!a.isDirectory()) {
            return;
        }

        File[] files = a.listFiles();
        if (files == null || files.length == 0) {
            return;
        }

        for (File file : files) {
            System.out.print(file.getName());
            recurUtil(file.getAbsolutePath());
        }

        System.out.println();
    }

    private static void printPrimeNumber(final int n) {
        boolean[] arr = new boolean[n + 1];
        for (int i = 2; i < Math.sqrt(n); i++) {
            printPrimeNumberUtil(arr, i);
        }

        for (int index = 2; index < arr.length; index++) {
            if (!arr[index]) {
                System.out.println(index);
            }
        }
    }

    private static void printPrimeNumberUtil(final boolean[] arr, int i) {
        for (int index = 2 * i; index < arr.length; index += i) {
            arr[index] = true;
        }
    }

    private static void testSameCharacter(final String s1, final String s2) {
        final Map<Character, Integer> charToCount = new HashMap<>();
        for (char c : s1.toCharArray()) {
            if (charToCount.containsKey(c)) {
                charToCount.put(c, charToCount.get(c) + 1);
            } else {
                charToCount.put(c, 1);
            }
        }

        for (char c : s2.toCharArray()) {
            if (charToCount.containsKey(c)) {
                if (charToCount.get(c) == 1) {
                    charToCount.remove(c);
                } else {
                    charToCount.put(c, charToCount.get(c) - 1);
                }
            } else {
                System.out.println(false);
                break;
            }
        }

        charToCount.values().stream().filter(i -> i != 0).forEach(i -> {
            System.out.println(false);
        });
    }

    private static String reverseUsingRec(final String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        return s.charAt(s.length() - 1) + reverseUsingRec(s.substring(0, s.length() - 1));
    }

    private static void toUpperLength3(final String[] arr) {
        for (String str : arr) {
            if (str.length() == 3) {
                str = str.toUpperCase();
            }
        }
    }
}
