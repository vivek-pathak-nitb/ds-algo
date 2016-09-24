package kryptolabs;

import java.util.HashSet;
import java.util.Set;

public class Q5 {

    public static void main(String[] args) {
        if (args == null || args.length == 0) {
            return;
        }

        final int[] arr = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            arr[i] = Integer.parseInt(args[i]);
        }

        new Q5().findDuplicates(arr);
    }

    /**
     * Takes an input array and prints duplicates
     */
    private void findDuplicates(final int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        final Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            int index = Math.abs(arr[i]);
            if (arr[index] < 0 && !visited.contains(Math.abs(arr[index]))) {
                System.out.println(Math.abs(arr[index]));
                visited.add(Math.abs(arr[index]));
            } else {
                arr[index] = -arr[index];
            }
        }
    }
}
