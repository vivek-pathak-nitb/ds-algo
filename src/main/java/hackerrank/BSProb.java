package hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by vivek.pathak on 21/10/15.
 */
public class BSProb {

    private static int sum = 0;

    public static void main(String[] args) {
        final Scanner scan = new Scanner(System.in);
        final List<Integer> numbers = new ArrayList<Integer>();
        Integer n;
        try {
            while ((n = scan.nextInt()) != null) {
                numbers.add(n);
            }
        } catch (Exception exception) {
        }

        getLoops(numbers);
    }

    private static void getLoops(final List<Integer> numbers) {
        for (final int number : numbers) {
            final int[] arr = new int[number];
            printRes(arr, -1, 0, number - 1);
            System.out.printf("Case 1: " + sum);
            sum = 0;
        }
    }

    private static void printRes(final int arr[],
                                 final int initialSum,
                                 final int start,
                                 final int end) {
        if (arr == null || arr.length == 0) {
            return;
        }

        if (start > end) {
            return;
        }

        final int mid = (start + end) / 2;
        if (initialSum == -1) {
            arr[mid] = 1;
        } else {
            arr[mid] = 1 + initialSum;
        }
        sum += arr[mid];

        printRes(arr, arr[mid], start, mid - 1);
        printRes(arr, arr[mid], mid + 1, end);

    }
}
