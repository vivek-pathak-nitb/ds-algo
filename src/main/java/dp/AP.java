package dp;

/**
 * Created by vivek.pathak on 05/05/16.
 */
public class AP {

    private int lengthOfLargestAP(final int[] arr) {
        int res = Integer.MIN_VALUE;
        if (arr == null || arr.length == 0) {
            return Integer.MIN_VALUE;
        }

        int n = arr.length;
        int[][] memo = new int[n][n];

        for (int i = 0; i < n; i++) {
            memo[i][i] = 1;
        }

        for (int i = 0; i < n - 1; i++) {
            memo[i][n - 1] = 2;
        }

        for (int mid = n - 2; mid >= 1; mid--) {
            int left = mid - 1;
            int right = mid + 1;
            while (left >= 0 && right < n) {
                if (arr[left] + arr[right] > 2 * arr[mid]) {
                    memo[left][mid] = 2;
                    left--;
                } else if (arr[left] + arr[right] < 2 * arr[mid]) {
                    right++;
                } else {
                    memo[left][mid] = memo[mid][right] + 1;
                    left--;
                    right++;

                }
            }

            while (left >= 0) {
                memo[left][mid] = 2;
                left--;
            }
        }
        return res;
    }
}
