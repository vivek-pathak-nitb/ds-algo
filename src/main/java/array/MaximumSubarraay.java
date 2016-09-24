package array;

import java.util.Scanner;

/**
 * Created by vivek.pathak on 15/05/16.
 */
public class MaximumSubarraay {

    public static void main(String[] args) {
        final Scanner a = new Scanner(System.in);
        final int testCases = a.nextInt();
        for (int i = 0; i < testCases; i++) {
            final int size = a.nextInt();
            final int[] arr = new int[size];

            for (int j = 0; j < size; j++) {
                arr[j] = a.nextInt();
            }

            final int maxSumCont = maxSubArrayContiguous(arr);
            final int maxSumNonCont = maxSubArrayNonContiguous(arr);
            System.out.println(maxSumCont + " " + maxSumNonCont);
        }

    }

    private static int maxSubArrayContiguous(final int[] arr) {
        int maxSoFar = arr[0];
        int currMax = arr[0];

        for (int i = 1; i < arr.length; i++) {
            currMax = Math.max(arr[i], currMax + arr[i]);
            maxSoFar = Math.max(maxSoFar, currMax);
        }

        return maxSoFar;
    }

    private static int maxSubArrayNonContiguous(final int[] arr) {
        int sumMax = 0;
        int max = arr[0];
        boolean isNegativeArray = true;
        int result = 0;

        for (final int anArr : arr) {
            if (anArr >= 0) {
                sumMax += anArr;
                isNegativeArray = false;
            }

            if (anArr >= max) {
                max = anArr;
            }
        }

        if (!isNegativeArray) {
            result = sumMax;
        }

        if (isNegativeArray) {
            result = max;
        }

        return result;
    }
}
