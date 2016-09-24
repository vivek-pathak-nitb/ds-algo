package array;

/**
 * Created by vivek.pathak on 08/01/16.
 */
public class ThreeSortedSubSequence {

    private void findThreeSorted(final int arr[]) {
        if (arr == null || arr.length < 3) {
            return;
        }

        final int[] small = new int[arr.length];
        final int[] large = new int[arr.length];

        int min = arr[0];
        int max = arr[arr.length - 1];

        small[0] = -1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] <= arr[min]) {
                min = i;
                small[i] = -1;
            } else {
                small[i] = min;
            }
        }

        large[arr.length - 1] = -1;
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] >= arr[max]) {
                max = i;
                large[i] = -1;
            } else {
                large[i] = max;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (small[i] != -1 && large[i] != -1) {
                System.out.printf("" + arr[small[i]] + " " + arr[i] + " " + arr[large[i]]);
            }
        }

    }
}
