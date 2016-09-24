package dp;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Palindrome {

    public static void main(String[] args) {
        System.out.println(new Palindrome().exist(Lists.newArrayList("FEDCBECD", "FABBGACG", "CDEDGAEC", "BFFEGGBA", "FCEEAFDA", "AGFADEAC", "ADGDCBAA", "EAABDDFF"), "BCDCB"));
    }

    public int findNumberOfPalindromes(String word) {
        final Set<String> palindromeSet = new HashSet<>();

        if (word == null || word.length() == 0) {
            return 0;
        }

        Boolean table[][] = new Boolean[word.length()][word.length()];
        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < word.length(); j++) {
                table[i][j] = false;
            }
        }

        for (int i = 0; i < word.length(); i++) {
            table[i][i] = true;
            palindromeSet.add(String.valueOf(word.charAt(i)));
        }

        for (int i = 0; i < word.length() - 1; i++) {
            if (word.charAt(i) == word.charAt(i + 1)) {
                String pal = "" + word.charAt(i) + word.charAt(i + 1);
                palindromeSet.add(pal);
                table[i][i + 1] = true;
            }
        }

        for (int i = 3; i < word.length(); i++) {
            for (int j = 0; j < word.length() - i + 1; j++) {
                int k = j + i - 1;
                if (word.charAt(j) == word.charAt(k) && table[j + 1][k - 1]) {
                    table[j][k] = true;
                    palindromeSet.add(word.substring(j, k + 1));
                }
            }
        }

        return palindromeSet.size();
    }

    public int exist(ArrayList<String> a, String b) {
        if (a == null || a.size() == 0 || b == null || b.length() == 0)
            return 0;

        int result = 0;
        boolean[][] visited = new boolean[a.size()][a.get(0).length()];

        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.get(i).length(); j++) {
                if (a.get(i).charAt(j) == b.charAt(0) && dfsSearch(a, b, i, j, 0, visited))
                return 1;
            }
        }
        return 0;
    }


    public boolean dfsSearch(ArrayList<String> a, String b, int row, int column, int index, boolean[][] visited) {
        if (index == b.length())
            return true;

        if (row < 0 || row >= a.size() || column < 0 || column >= a.get(0).length())
            return false;

        if (visited[row][column] || (a.get(row).charAt(column) != b.charAt(index)))
            return false;

        visited[row][column] = true;


        if (dfsSearch(a, b, row, column + 1, index + 1, visited) ||
                dfsSearch(a, b, row, column - 1, index + 1, visited) ||
                dfsSearch(a, b, row - 1, column, index + 1, visited) ||
                dfsSearch(a, b, row + 1, column, index + 1, visited))
            return true;

        visited[row][column] = false;

        return false;
    }

}
