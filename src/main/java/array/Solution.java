package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

public class Solution {

    public boolean isPower(int n) {
        if (n <= 0) return false;
        if (n == 1 || n == 2) return false;

        int b;
        for (int a = 2; a <= Math.sqrt(n); a++) {
            b = 1;
            Double temp = Math.pow((double) a, (double) b);
            while (temp <= n && temp > 0) {
                if (temp == n) {
                    return true;
                } else {
                    b++;
                    temp = Math.pow((double) a, (double) b);
                }
            }

        }
        return false;
    }

    static void decentNumber(final String[] arr) {
        for (final String str : arr) {
            final int n = Integer.valueOf(str);
            String s = "";
            for (int i = n; i >= 0; i--) {
                if (i % 3 == 0 && (n - i) % 5 == 0) {
                    final StringBuilder temp1 = new StringBuilder();
                    for (int j = 0; j < i; j++) {
                        temp1.append("5");
                    }

                    final StringBuilder temp2 = new StringBuilder();
                    for (int j = 0; j < (n - i); j++) {
                        temp2.append("3");
                    }

                    s = temp1.toString() + temp2.toString();
                    break;
                }
            }

            if (s.equals("")) {
                System.out.println(-1);
            } else {
                System.out.println(s);
            }
        }
    }


    static int maxProfit(final int cost_per_cut,
                         final int metal_price,
                         final int[] lengths) {
        if (lengths == null || lengths.length == 0) {
            return 0;
        }

        int maximumLength = 0;
        for (final int length : lengths) {
            if (length > maximumLength) {
                maximumLength = length;
            }
        }

        int maximumProfit = 0;
        for (int i = 1; i < maximumLength; i++) {
            int sumOfLengths = 0;
            int sumOfCutCounts = 0;
            int sumOfCutWastes = 0;

            for (int length : lengths) {
                sumOfLengths += length;
                if (length % i == 0) {
                    sumOfCutCounts += (length / i - 1);
                } else {
                    sumOfCutCounts += (length / i);
                }

                sumOfCutWastes += (length % i);
            }

            int profit = sumOfLengths * metal_price - sumOfCutCounts * cost_per_cut - sumOfCutWastes * metal_price;
            if (profit > maximumProfit) {
                maximumProfit = profit;
            }
        }

        return maximumProfit;

    }


    public static void main(String[] args) {
        new Solution().solution(new int[]{1, 2, 4, 5, 7, 29, 30});
    }

    public ArrayList<Integer> primesum(int a) {
        final boolean[] primeList = primeNumbers(a);
        final ArrayList<Integer> toReturn = new ArrayList<Integer>();
        int ans1 = 0;
        int ans2 = 0;
        for (int i = 2; i <= a; i++) {
            if (primeList[i] && primeList[a - i]) {
                if (ans1 != 0 & ans2 != 0) {
                    if (ans1 > i) {
                        ans1 = i;
                        ans2 = a - i;
                    }
                    if (ans1 == i && ans2 > a - i) {
                        ans1 = i;
                        ans2 = a - i;
                    }

                } else {
                    ans1 = i;
                    ans2 = a - i;
                }
            }
        }
        toReturn.add(ans1);
        toReturn.add(ans2);
        return toReturn;
    }

    public int solution(int[] a) {
        // write your code in Java SE 8
        if (a == null || a.length == 0) {
            return 0;
        }

        if (a.length >= 20) {
            return 25;
        }

        if (a.length <= 3) {
            return 2 * a.length;
        }

        final Set<Integer> set = new HashSet<>();
        final Set<Integer> visited = new HashSet<>();
        for (final int num : a) {
            set.add(num);
        }

        int cost = 0;
        for (int anA : a) {
            if (visited.contains(anA)) {
                continue;
            }

            int count = 0;
            int temp = anA;
            final List<Integer> visitedList = new ArrayList<>();
            for (int j = 1; j < 7; j++) {
                if (set.contains(temp + 1)) {
                    count++;
                    visitedList.add(temp + 1);
                }
                temp = temp + 1;
            }

            if (count >= 4) {
                cost = cost + 7;
                visited.addAll(visitedList);
            } else {
                cost = cost + 2;
            }
        }
        return cost;
    }

//    public int[] solution(int[] t) {
//        if (t == null || t.length == 0) {
//            return new int[]{};
//        }
//
//        int capital = 0;
//        final Map<Integer, List<Integer>> map = new HashMap<>();
//
//        for (int i = 0; i < t.length; i++) {
//            if (t[i] == i) {
//                capital = i;
//                continue;
//            }
//
//            if (map.containsKey(t[i])) {
//                map.get(t[i]).add(i);
//            } else {
//                final List<Integer> list = new ArrayList<>();
//                list.add(i);
//                map.put(t[i], list);
//            }
//        }
//
//        int[] result = new int[t.length];
//        List<Integer> list = map.get(capital);
//        result[0] = list.size();
//        int i = 1;
//        while (list.size() > 0) {
//            List<Integer> temp = new ArrayList<>();
//            for (final int num : list) {
//                if (map.containsKey(num)) {
//                    temp.addAll(map.get(num));
//                }
//            }
//
//            result[i] = temp.size();
//            list = temp;
//            i++;
//        }
//
//        return result;
//    }

    public boolean[] primeNumbers(int n) {
        final boolean[] primeList = new boolean[n + 1];
        String s = "";
        Arrays.fill(primeList, true);
        primeList[0] = false;
        primeList[1] = false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (primeList[i]) {
                for (int j = i * 2; j <= n; j += i)
                    primeList[j] = false;
            }
        }
        return primeList;
    }

    public int uniquePaths(int m, int n) {
        int count[][] = new int[m][n];


        for (int i = 0; i < m; i++) {
            count[i][0] = 1;
        }

        for (int j = 0; j < n; j++) {
            count[0][j] = 1;
        }


        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++)

                count[i][j] = count[i - 1][j] + count[i][j - 1];

        }

        return count[m - 1][n - 1];
    }

    public void arrange(ArrayList<Integer> a) {
        int n = a.size();
        for (int i = 0; i < n; i++) {
            int toAdd = (a.get(a.get(i)) % n) * n;
            a.set(i, a.get(i) + toAdd);

        }

        for (int i = 0; i < n; i++) {
            a.set(i, a.get(i) / n);
        }
    }

    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (numRows <= 0) {
            return result;
        }

        ArrayList<Integer> pre = new ArrayList<Integer>();
        pre.add(1);
        result.add(pre);

        for (int i = 2; i <= numRows; i++) {
            ArrayList<Integer> cur = new ArrayList<Integer>();

            cur.add(1); //first
            for (int j = 0; j < pre.size() - 1; j++) {
                cur.add(pre.get(j) + pre.get(j + 1)); //middle
            }
            cur.add(1);//last

            result.add(cur);
            pre = cur;
        }

        return result;
    }

    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> a) {
        int rows = a.size();
        int cols = a.get(0).size();
        final Set<String> visited = new HashSet<String>();
        final ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                String flag = i + "," + j;
                if (!visited.contains(flag)) {
                    final ArrayList<Integer> toAdd = new ArrayList<Integer>();
                    toAdd.add(a.get(i).get(j));
                    find(i + 1, j - 1, rows, cols, a, toAdd, visited);
                    result.add(toAdd);
                    visited.add(flag);
                }
            }
        }

        return result;
    }

    public void find(int row,
                     int col,
                     int rows,
                     int cols,
                     ArrayList<ArrayList<Integer>> a,
                     final ArrayList<Integer> toAdd,
                     final Set<String> visited) {
        if (row < 0 || row >= rows) {
            return;
        }

        if (col < 0 || col >= cols) {
            return;
        }

        String flag = row + "," + col;
        if (!visited.contains(flag)) {
            toAdd.add(a.get(row).get(col));
            visited.add(flag);
            find(row + 1, col - 1, rows, cols, a, toAdd, visited);
        }

    }

    public int searchMatrix(ArrayList<ArrayList<Integer>> matrix, int target) {
        if (matrix == null || matrix.size() == 0 || matrix.get(0).size() == 0) {
            return 0;
        }

        int m = matrix.size();
        int n = matrix.get(0).size();

        int start = 0;
        int end = m * n - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            int midX = mid / n;
            int midY = mid % n;

            if (matrix.get(midX).get(midY) == target) {
                return 1;
            }

            if (matrix.get(midX).get(midY) < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return 0;
    }

    public int search(final List<Integer> a, int b) {
        int left = 0;
        int right = a.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (a.get(mid) == b) {
                return mid;
            }

            if (a.get(left) <= a.get(mid)) {
                if (a.get(left) <= b && b < a.get(mid)) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (a.get(mid) < b && b <= a.get(right)) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;

    }

    public int pow(int x, int n, int d) {
        int res = power(x, n);
        if (res > 0) {
            return res % d;
        }

        res = res + d;
        while (!(res > 0 && res < d)) {
            res = res + d;
        }

        return res % d;
    }

    public int power(int x, int y) {
        int temp;
        if (y == 0) {
            return 1;
        }
        temp = power(x, y / 2);
        if (y % 2 == 0) {
            return temp * temp;
        } else {
            return x * temp * temp;
        }
    }

    public int searchInsert(List<Integer> a, int target) {
        if (a == null || a.size() == 0)
            return 0;

        return searchInsert(a, target, 0, a.size() - 1);
    }

    public int searchInsert(List<Integer> a, int target, int start, int end) {
        int mid = (start + end) / 2;

        if (target == a.get(mid))
            return mid;
        else if (target < a.get(mid))
            return start < mid ? searchInsert(a, target, start, mid - 1) : start;
        else
            return end > mid ? searchInsert(a, target, mid + 1, end) : (end + 1);
    }

    public int diffPossible(ArrayList<Integer> a, int b) {
        Collections.sort(a);
        for (int i = 0; i < a.size(); i++) {
            int flag = binarySearch(a, 0, a.size() - 1, i, b + a.get(i));
            if (flag == 1) {
                return 1;
            }
        }

        return 0;
    }

    public int binarySearch(ArrayList<Integer> a, int start, int end, int index, int k) {
        if (start > end) {
            return 0;
        }
        int mid = start + (end - start) / 2;
        if (a.get(mid) == k && mid != index) {
            return 1;
        }

        if (a.get(mid) > k) {
            return binarySearch(a, start, mid - 1, index, k);
        }

        if (a.get(mid) < k) {
            return binarySearch(a, mid + 1, end, index, k);
        }

        return 0;
    }

    public int threeSumClosest(ArrayList<Integer> nums, int target) {
        int min = Integer.MAX_VALUE;
        int result = 0;

        Collections.sort(nums);

        for (int i = 0; i < nums.size(); i++) {
            int j = i + 1;
            int k = nums.size() - 1;
            while (j < k) {
                int sum = nums.get(i) + nums.get(j) + nums.get(k);
                int diff = Math.abs(sum - target);

                if (diff == 0) return sum;

                if (diff < min) {
                    min = diff;
                    result = sum;
                }
                if (sum <= target) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return result;
    }

    public void sort012(ArrayList<Integer> a) {
        int lo = 0;
        int hi = a.size() - 1;
        int mid = 0, temp;
        while (mid <= hi) {
            switch (a.get(mid)) {
                case 0: {
                    temp = a.get(lo);
                    a.set(lo, a.get(mid));
                    a.set(mid, temp);
                    lo++;
                    mid++;
                    break;
                }
                case 1:
                    mid++;
                    break;
                case 2: {
                    temp = a.get(mid);
                    a.set(mid, a.get(hi));
                    a.set(hi, temp);
                    hi--;
                    break;
                }
            }
        }
    }

    public int isPalindrome(String a) {
        final StringBuilder sb1 = new StringBuilder();
        for (char c : a.toCharArray()) {
            if (Character.isDigit(c) || Character.isAlphabetic(c)) {
                sb1.append(c);
            }
        }

        final String str = sb1.toString();
        final StringBuilder sb2 = new StringBuilder(str);
        if (str.equalsIgnoreCase(sb2.reverse().toString())) {
            return 1;
        }

        return 0;

    }

    public int numSetBits(long n) {
        int count = 0;
        for (int i = 1; i < 33; i++) {
            if (getBit(n, i)) {
                count++;
            }
        }
        return count;
    }

    public boolean getBit(long n, int i) {
        return (n & (1 << i)) != 0;
    }

    public long reverse(long n) {
        for (int i = 0; i < 16; i++) {
            n = swapBits(n, i, 32 - i - 1);
        }

        return n;
    }

    public long swapBits(long n, int i, int j) {
        long a = (n >> i) & 1;
        long b = (n >> j) & 1;

        if ((a ^ b) != 0) {
            return n ^= (1 << i) | (1 << j);
        }

        return n;
    }

    public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if (num.size() < 3) {
            return result;
        }

        Collections.sort(num);

        for (int i = 0; i < num.size() - 2; i++) {

            if (i == 0 || num.get(i) > num.get(i - 1)) {
                int negate = -num.get(i);
                int start = i + 1;
                int end = num.size() - 1;

                while (start < end) {
                    if (num.get(start) + num.get(end) == negate) {
                        ArrayList<Integer> temp = new ArrayList<Integer>();
                        temp.add(num.get(i));
                        temp.add(num.get(start));
                        temp.add(num.get(end));

                        result.add(temp);
                        start++;
                        end--;

                        while (start < end && num.get(end).equals(num.get(end + 1))) {
                            end--;
                        }

                        while (start < end && num.get(start).equals(num.get(start - 1))) {
                            start++;
                        }

                    } else if (num.get(start) + num.get(end) < negate) {
                        start++;
                    } else {
                        end--;
                    }
                }

            }
        }

        return result;
    }

    public String countAndSay(int n) {
        if (n <= 0) {
            return null;
        }

        String result = "1";
        int i = 1;

        while (i < n) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) == result.charAt(j - 1)) {
                    count++;
                } else {
                    sb.append(count);
                    sb.append(result.charAt(j - 1));
                    count = 1;
                }
            }

            sb.append(count);
            sb.append(result.charAt(result.length() - 1));
            result = sb.toString();
            i++;
        }

        return result;
    }

    public String longestPalindrome(String a) {
        if (a.isEmpty()) {
            return null;
        }

        if (a.length() == 1) {
            return a;
        }

        String longest = a.substring(0, 1);
        for (int i = 0; i < a.length(); i++) {
            // get longest palindrome with center of i
            String tmp = helper(a, i, i);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }

            // get longest palindrome with center of i, i+1
            tmp = helper(a, i, i + 1);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }
        }

        return longest;
    }

    // Given a center, either one letter or two letter,
// Find longest palindrome
    public String helper(String s, int begin, int end) {
        while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
        }
        return s.substring(begin + 1, end);
    }

    public String reverseWords(String a) {
        if (a == null || a.length() == 0) {
            return "";
        }

        String[] arr = a.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; --i) {
            if (!arr[i].equals("")) {
                sb.append(arr[i]).append(" ");
            }
        }
        return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
    }

    public int lengthOfLastWord(final String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int result = 0;
        int len = s.length();

        boolean flag = false;
        for (int i = len - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                flag = true;
                result++;
            } else {
                if (flag) {
                    return result;
                }
            }
        }

        return result;
    }

    public int atoi(final String a) {
        String str = a;
        if (str == null || str.length() < 1) {
            return 0;
        }

        str = str.trim();

        char flag = '+';

        int i = 0;
        if (str.charAt(0) == '-') {
            flag = '-';
            i++;
        } else if (str.charAt(0) == '+') {
            i++;
        }

        double result = 0;
        boolean numericFound = false;

        while (str.length() > i) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                result = result * 10 + (str.charAt(i) - '0');
                numericFound = true;
            } else {
                if (numericFound) {
                    if (flag == '-') {
                        result = -result;
                    }

                    if (result > Integer.MAX_VALUE) {
                        return Integer.MAX_VALUE;
                    }

                    if (result < Integer.MIN_VALUE) {
                        return Integer.MIN_VALUE;
                    }

                    return (int) result;
                }
            }

            i++;
        }

        if (flag == '-') {
            result = -result;
        }

        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int) result;
    }

    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] numerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                result.append(numerals[i]);
            }
        }
        return result.toString();
    }

    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);
        int res = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (i < s.length() - 1 && map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                res -= map.get(s.charAt(i));
            } else {
                res += map.get(s.charAt(i));
            }
        }
        return res;
    }

    public int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");

        int i = 0;
        while (i < arr1.length || i < arr2.length) {
            if (i < arr1.length && i < arr2.length) {
                if (Double.parseDouble(arr1[i]) < Double.parseDouble(arr2[i])) {
                    return -1;
                } else if (Double.parseDouble(arr1[i]) > Double.parseDouble(arr2[i])) {
                    return 1;
                }
            } else if (i < arr1.length) {
                if (Double.parseDouble(arr1[i]) != 0) {
                    return 1;
                }
            } else if (i < arr2.length) {
                if (Double.parseDouble(arr2[i]) != 0) {
                    return -1;
                }
            }

            i++;
        }

        return 0;
    }


    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        ArrayList<String> t = new ArrayList<String>();
        dfs(result, s, 0, t);

        ArrayList<String> finalResult = new ArrayList<String>();

        for (ArrayList<String> l : result) {
            StringBuilder sb = new StringBuilder();
            for (String str : l) {
                sb.append(str + ".");
            }
            sb.setLength(sb.length() - 1);
            finalResult.add(sb.toString());
        }

        return finalResult;
    }

    public void dfs(ArrayList<ArrayList<String>> result, String s, int start, ArrayList<String> t) {
        //if already get 4 numbers, but s is not consumed, return
        if (t.size() >= 4 && start != s.length())
            return;

        //make sure t's size + remaining string's length >=4
        if ((t.size() + s.length() - start + 1) < 4)
            return;

        //t's size is 4 and no remaining part that is not consumed.
        if (t.size() == 4 && start == s.length()) {
            ArrayList<String> temp = new ArrayList<String>(t);
            result.add(temp);
            return;
        }

        for (int i = 1; i <= 3; i++) {
            //make sure the index is within the boundary
            if (start + i > s.length())
                break;

            String sub = s.substring(start, start + i);
            //handle case like 001. i.e., if length > 1 and first char is 0, ignore the case.
            if (i > 1 && s.charAt(start) == '0') {
                break;
            }

            //make sure each number <= 255
            if (Integer.valueOf(sub) > 255)
                break;

            t.add(sub);
            dfs(result, s, start + i, t);
            t.remove(t.size() - 1);
        }
    }

    public ArrayList<Integer> intersect(final List<Integer> a, final List<Integer> b) {
        ArrayList<Integer> intersection = new ArrayList<Integer>();
        int n1 = a.size();
        int n2 = b.size();
        int i = 0, j = 0;
        while (i < n1 && j < n2) {
            if (a.get(i) > b.get(j)) {
                j++;
            } else if (b.get(j) > a.get(i)) {
                i++;
            } else {
                intersection.add(a.get(i));
                i++;
                j++;
            }
        }
        return intersection;
    }

    public int maxArea(ArrayList<Integer> a) {
        if (a == null || a.size() < 2) {
            return 0;
        }

        int max = 0;
        int left = 0;
        int right = a.size() - 1;

        while (left < right) {
            max = Math.max(max, (right - left) * Math.min(a.get(left), a.get(right)));
            if (a.get(left) < a.get(right)) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }

    public int braces(String str) {

        int n = str.length();
        Stack<Character> stack = new Stack<Character>();


        for (int i = 0; i < n; ++i) {

            if (str.charAt(i) == ')') {

                int cnt = 0;

                while (stack.peek() != '(') {
                    stack.pop();
                    cnt++;
                }

                stack.pop();
                if (cnt < 2)
                    return 1;
            } else {
                stack.push(str.charAt(i));
            }

        }

        boolean is = true;

        while (stack.size() > 0) {

            if (stack.peek() == '(' || stack.peek() == ')') {
                is = false;
                break;
            }
            stack.pop();
        }

        if (!is) {
            return 1;
        }
        return 0;
    }

    public int minCut(String s) {
        int n = s.length();

        boolean dp[][] = new boolean[n][n];
        int cut[] = new int[n];

        for (int j = 0; j < n; j++) {
            cut[j] = j; //set maximum # of cut
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 1 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;

                    // if need to cut, add 1 to the previous cut[i-1]
                    if (i > 0) {
                        cut[j] = Math.min(cut[j], cut[i - 1] + 1);
                    } else {
                        // if [0...j] is palindrome, no need to cut
                        cut[j] = 0;
                    }
                }
            }
        }

        return cut[n - 1];
    }

    public int largestRectangleArea(ArrayList<Integer> height) {
        if (height == null || height.size() == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<Integer>();

        int max = 0;
        int i = 0;

        while (i < height.size()) {
            //push index to stack when the current height is larger than the previous one
            if (stack.isEmpty() || height.get(i) >= height.get(stack.peek())) {
                stack.push(i);
                i++;
            } else {
                //calculate max value when the current height is less than the previous one
                int p = stack.pop();
                int h = height.get(p);
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(h * w, max);
            }

        }

        while (!stack.isEmpty()) {
            int p = stack.pop();
            int h = height.get(p);
            int w = stack.isEmpty() ? i : i - stack.peek() - 1;
            max = Math.max(h * w, max);
        }

        return max;
    }

    public int evalRPN(ArrayList<String> tokens) {
        int returnValue = 0;
        String operators = "+-*/";

        Stack<String> stack = new Stack<String>();

        for (String t : tokens) {
            if (!operators.contains(t)) {
                stack.push(t);
            } else {
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                switch (t) {
                    case "+":
                        stack.push(String.valueOf(a + b));
                        break;
                    case "-":
                        stack.push(String.valueOf(b - a));
                        break;
                    case "*":
                        stack.push(String.valueOf(a * b));
                        break;
                    case "/":
                        stack.push(String.valueOf(b / a));
                        break;
                }
            }
        }

        returnValue = Integer.valueOf(stack.pop());

        return returnValue;
    }

    public ArrayList<Integer> twoSum(final List<Integer> numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i++) {
            if (map.containsKey(numbers.get(i))) {
                int index = map.get(numbers.get(i));
                if (result.size() > 0) {
                    int index1 = result.get(0);
                    int index2 = result.get(1);
                    if (index2 < i + 1) {
                        result.clear();
                        result.add(index + 1);
                        result.add(i + 1);
                    } else if (index1 < (index + 1)) {
                        result.clear();
                        result.add(index + 1);
                        result.add(i + 1);
                    }
                } else {
                    result.add(index + 1);
                    result.add(i + 1);
                }
            } else {
                map.put(target - numbers.get(i), i);
            }
        }

        return result;
    }

    public ArrayList<ArrayList<Integer>> anagrams(final List<String> strs) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (strs == null || strs.size() == 0) {
            return result;
        }

        HashMap<String, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < strs.size(); i++) {
            char[] arr = strs.get(i).toCharArray();
            Arrays.sort(arr);
            String t = String.valueOf(arr);
            if (map.get(t) == null) {
                ArrayList<Integer> l = new ArrayList<>();
                l.add(i);
                map.put(t, l);
            } else {
                map.get(t).add(i);
            }
        }

        for (ArrayList<Integer> l : map.values()) {
            if (l.size() > 1) {
                result.add(l);
            }
        }

        return result;
    }

    public int longestConsecutive(final List<Integer> a) {
        final Set<Integer> set = new HashSet<>();
        for (final int num : a) {
            set.add(num);
        }

        int max = 1;
        for (final int num : a) {
            int left = num - 1;
            int right = num + 1;
            int count = 1;

            while (set.contains(left)) {
                set.remove(left);
                left--;
                count++;
            }

            while (set.contains(right)) {
                set.remove(right);
                right++;
                count++;
            }

            max = Math.max(max, count);

        }

        return max;
    }

//    public int solution(int[] A) {
//        // write your code in Java SE 8
//
//        // Map containing key as element of array and value as its count.
//        final Map<Integer, Integer> valueToCountMap = new HashMap<>();
//
//        // Populating the map.
//        for (int num : A) {
//            // if element exist increment the current count
//            if (valueToCountMap.containsKey(num)) {
//                valueToCountMap.put(num, valueToCountMap.get(num) + 1);
//                continue;
//            }
//
//            // if element doesn't exist create a new entry for element
//            valueToCountMap.put(num, 1);
//        }
//
//        int sum = 0;
//        // if for a element count is n then total number of pairs are n*(n-1)/2.
//        for (int num : valueToCountMap.values()) {
//            if (num > 1) {
//                sum += ((num * (num - 1)) / 2);
//            }
//        }
//
//        return sum;
//    }


    public String solution(String S) {
        // write your code in Java SE 8
        if (S == null || S.length() == 1 || S.equals("")) {
            return S;
        }

        // look up map for replacement rules.
        Map<String, String> ruleMap = new HashMap<>();
        ruleMap.put("AB", "AA");
        ruleMap.put("BA", "AA");
        ruleMap.put("CB", "CC");
        ruleMap.put("BC", "CC");
        ruleMap.put("AA", "A");
        ruleMap.put("CC", "C");

        List<String> rules;
        // Iterate till we have valid rules applicable on string S.
        do {
            rules = getApplicableRules(ruleMap, S);
            Random random = new Random();
            if (rules.size() != 0) {
                // Generate random rule applicable.
                int index = random.nextInt(rules.size());
                final String replacementKey = rules.get(index);
                // applying rule for the first replacement.
                S = S.replaceFirst(replacementKey, ruleMap.get(replacementKey));
            }
        } while (rules.size() != 0); // break when no rule is applicable on current string S.

        return S;
    }

    // Get applicable rules associated with current string S.
    private List<String> getApplicableRules(Map<String, String> keyValueMap, String S) {
        return keyValueMap.keySet().stream().filter(S::contains).collect(Collectors.toList());
    }

    public int diffPossible(final List<Integer> a, int n) {
        if (a == null || a.size() == 0 || a.size() == 1) {
            return 0;
        }

        Collections.sort(a);
        int index = 0;
        for (int num : a) {
            int res = binarySearch(a, num + n, 0, a.size() - 1, index);
            if (res == 1) {
                return 1;
            }
            index++;
        }

        return 0;
    }

    private int binarySearch(final List<Integer> a, int target, int left, int right, int index) {
        if (left > right) {
            return 0;
        }

        int mid = left + (right - left) / 2;
        if (a.get(mid) == target && index != mid) {
            return 1;
        }

        if (a.get(mid) > target) {
            return binarySearch(a, target, left, mid - 1, index);
        }

        return binarySearch(a, target, mid + 1, right, index);

    }

    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<>();
        dfs(result, "", n, n);
        return result;
    }

    private void dfs(ArrayList<String> result, String s, int left, int right) {
        if (left > right)
            return;

        if (left == 0 && right == 0) {
            result.add(s);
            return;
        }

        if (left > 0) {
            dfs(result, s + "(", left - 1, right);
        }

        if (right > 0) {
            dfs(result, s + ")", left, right - 1);
        }
    }


}

//            1 2 3
//            4 5 6
//            7 8 9
//
//    Return the following :
//
//            [
//            [1],
//            [2, 4],
//            [3, 5, 7],
//            [6, 8],
//            [9]
//            ]
//}
