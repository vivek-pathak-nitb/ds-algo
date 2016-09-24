package array;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created by vivek.pathak on 08/01/16.
 */
public class LargestSubArrayWith10 {

    public int getMaxLength(final int[] arr, final int n) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int[] sumLeft = new int[n];
        if (arr[0] == 1) {
            sumLeft[0] = 1;
        } else {
            sumLeft[0] = -1;
        }

        int max = sumLeft[0];
        int min = sumLeft[0];
        final Map<Integer, Integer> hash = Maps.newHashMap();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 1) {
                sumLeft[i] += 1;
            } else {
                sumLeft[i] += -1;
            }

            if (sumLeft[i] < min) {
                min = sumLeft[i];
            } else if (sumLeft[i] > max) {
                max = sumLeft[i];
            }
        }

        return 0;
    }
}
