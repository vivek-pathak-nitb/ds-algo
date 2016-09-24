import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by vivek.pathak on 25/02/16.
 */
public class Solution {

    public static void main(String args[]) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        long[] a = new long[n + 1];
        for (int i = 0; i < m; i++) {
            int l = scanner.nextInt() - 1;
            int r = scanner.nextInt();
            int v = scanner.nextInt();
            a[l] += v;
            a[r] -= v;
        }

        long cur = 0;
        long max = 0;
        for (int i = 0; i < n; i++) {
            cur += a[i];
            max = Math.max(max, cur);
        }
        System.out.println(max);
    }

    public static class ListMax {
        private List<Integer> list;
        int n;

        public ListMax(int n) {
            this.n = n;
            this.list = new ArrayList<Integer>(this.n);
            //Initialize to default value of 0 for all n positions
            for (int i = 0; i < n; i++) {
                this.list.add(0);
            }
        }

        public void doOperation(int a, int b, int k) {
            for (int i = a - 1; i < b; i++) {
                int val = this.list.get(i);
                val += k;
                this.list.set(i, val);
            }
        }

        public int listMax() {
            Collections.sort(this.list);
            int size = this.list.size();
            return this.list.get(size - 1);
        }

        private static long calculateProfit(long n, Map<Long, Long> mem) {
            if (n == 0) {
                return 0;
            }

            Long res = mem.get(n);
            if (res == null) {
                res = Math.max(n, calculateProfit(n / 3, mem) + calculateProfit(n / 2, mem) + calculateProfit(n / 4, mem));
                mem.put(n, res);
            }

            return res;
        }

        private static int findCabs(int arr[], int dep[], int n) {
            Arrays.sort(arr);
            Arrays.sort(dep);

            int plat_needed = 1, result = 1;
            int i = 1, j = 0;

            while (i < n && j < n) {

                if (arr[i] < dep[j]) {
                    plat_needed++;
                    i++;
                    if (plat_needed > result) {
                        result = plat_needed;
                    }
                } else {
                    plat_needed--;
                    j++;
                }
            }

            return result;
        }

        private static int trap(int[] height) {
            int result = 0;
            if (height == null || height.length <= 2) {
                return result;
            }

            int left[] = new int[height.length];
            int right[] = new int[height.length];

            int max = height[0];
            left[0] = height[0];
            for (int i = 1; i < height.length; i++) {
                if (height[i] < max) {
                    left[i] = max;
                } else {
                    left[i] = height[i];
                    max = height[i];
                }
            }

            max = height[height.length - 1];
            right[height.length - 1] = height[height.length - 1];
            for (int i = height.length - 2; i >= 0; i--) {
                if (height[i] < max) {
                    right[i] = max;
                } else {
                    right[i] = height[i];
                    max = height[i];
                }
            }

            for (int i = 0; i < height.length; i++) {
                result += Math.min(left[i], right[i]) - height[i];
            }

            return result;
        }

        public void reverse(char[] str, int start, int end) {

            if (str == null || str.length == 0) {
                return;
            }

            if (start > end) {
                return;
            }

            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;

            reverse(str, start + 1, end - 1);
        }

        public int maxPoints(ArrayList<Integer> x, ArrayList<Integer> y) {
            if (x == null || x.size() == 0) return 0;

            if (y == null || y.size() == 0) return 0;

            if (x.size() != y.size()) {
                return 0;
            }

            HashMap<Double, Integer> result = new HashMap<Double, Integer>();
            int max = 0;

            for (int i = 0; i < x.size(); i++) {
                int duplicate = 1;//
                int vertical = 0;
                for (int j = i + 1; j < x.size(); j++) {
                    //handle duplicates and vertical
                    if (x.get(i).equals(x.get(j))) {
                        if (y.get(i).equals(y.get(j))) {
                            duplicate++;
                        } else {
                            vertical++;
                        }
                    } else {
                        double slope = y.get(i).equals(y.get(j)) ? 0.0
                                : (1.0 * (y.get(j) - y.get(i)))
                                / (x.get(j) - x.get(i));

                        if (result.get(slope) != null) {
                            result.put(slope, result.get(slope) + 1);
                        } else {
                            result.put(slope, 1);
                        }
                    }
                }

                for (Integer count : result.values()) {
                    if (count + duplicate > max) {
                        max = count + duplicate;
                    }
                }

                max = Math.max(vertical + duplicate, max);
                result.clear();
            }


            return max;
        }

        public String fractionToDecimal(int numerator, int denominator) {
            if (numerator == 0) {
                return "0";
            }

            if (denominator == 0) {
                return "";
            }

            StringBuilder result = new StringBuilder();

            if ((numerator < 0) ^ (denominator < 0)) {
                result.append("-");
            }

            long num = numerator, den = denominator;
            num = Math.abs(num);
            den = Math.abs(den);

            long res = num / den;
            result.append(String.valueOf(res));

            long remainder = (num % den) * 10;
            if (remainder == 0) {
                return result.toString();
            }

            HashMap<Long, Integer> map = new HashMap<Long, Integer>();
            result.append(".");
            while (remainder != 0) {
                if (map.containsKey(remainder)) {
                    int beg = map.get(remainder);
                    String part1 = result.substring(0, beg);
                    String part2 = result.substring(beg, result.length());
                    result = new StringBuilder();
                    result.append(part1).append("(").append(part2).append(")");
                    return result.toString();
                }

                map.put(remainder, result.length());
                res = remainder / den;
                result.append(String.valueOf(res));
                remainder = (remainder % den) * 10;
            }

            return result.toString();
        }
    }
}
