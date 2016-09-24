package graph;

import java.util.Scanner;

/**
 * Created by vivek.pathak on 15/05/16.
 */
public class ConnectedCell {

    private static int cellCounter = 0;

    public static void main(String[] args) {
        final Scanner a = new Scanner(System.in);
        final int rows = a.nextInt();
        final int cols = a.nextInt();

        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = a.nextInt();
            }
        }

        System.out.println(findMaxConnectedCellNum(matrix, rows, cols));
    }

    private static int findMaxConnectedCellNum(final int[][] matrix,
                                               final int rows,
                                               final int cols) {
        int[][] visited = new int[rows][cols];
        int maxNum = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dfs(matrix, visited, i, j, rows, cols);
                if (cellCounter > maxNum) maxNum = cellCounter;
                cellCounter = 0;
            }
        }

        return maxNum;
    }

    private static void dfs(final int[][] matrix,
                            final int[][] visited,
                            final int i,
                            final int j,
                            final int rows,
                            final int cols) {
        if (i < 0 || i >= rows || j < 0 || j >= cols) {
            return;
        }

        if (visited[i][j] == 1 || matrix[i][j] == 0) {
            return;
        }

        cellCounter++;
        visited[i][j] = 1;

        dfs(matrix, visited, i + 1, j, rows, cols);
        dfs(matrix, visited, i, j + 1, rows, cols);
        dfs(matrix, visited, i - 1, j, rows, cols);
        dfs(matrix, visited, i, j - 1, rows, cols);
        dfs(matrix, visited, i + 1, j + 1, rows, cols);
        dfs(matrix, visited, i + 1, j - 1, rows, cols);
        dfs(matrix, visited, i - 1, j + 1, rows, cols);
        dfs(matrix, visited, i - 1, j - 1, rows, cols);
    }
}
