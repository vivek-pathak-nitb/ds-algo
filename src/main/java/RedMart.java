import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by vivek.pathak on 07/04/16.
 */
public class RedMart {

    public static void main(String[] args) {
        final Scanner a = new Scanner(System.in);
        final int rows = a.nextInt();
        final int cols = a.nextInt();
        final int[][] heights = new int[rows][cols];
        for(int i =0;i<rows;i++){
            for(int j =0;j<cols;j++){
                heights[i][j] = a.nextInt();
            }
        }

        List<Integer> result = new ArrayList<>();
    }

    private static void path(final int[][] heights,
                             final List<Integer> result){

    }


}
