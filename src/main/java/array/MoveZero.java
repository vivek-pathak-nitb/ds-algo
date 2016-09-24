package array;

/**
 * Created by vivek.pathak on 13/05/16.
 */
public class MoveZero {

    public static void main(String[] args) {
        int arr[] = {1, 2, 0, 0, 5, 6, 0, 8, 7};
        new MoveZero().moveZero(arr);
        for (final int n : arr) {
            System.out.print(n);
        }
    }

    public void moveZero(final int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                j++; // 1,2,0,0,5,6,0,8,7
            }
        }

    }
}
