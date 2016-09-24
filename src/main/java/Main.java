import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    private List<Integer> results = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        new Main().takeInputAndFindPath();
    }

    private void takeInputAndFindPath() throws FileNotFoundException {
        final Scanner input = new Scanner(System.in);

        final int rows = input.nextInt();
        final int cols = input.nextInt();

        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                matrix[i][j] = input.nextInt();
            }
        }

        findPath(matrix, rows - 1, cols - 1);

        System.out.println(results.size());
        Collections.sort(results);

        if (results.size() >= 2) {
            System.out.println(results.get(results.size() - 1) - results.get(0));
        } else if(results.size()==1) {
            System.out.println(results.get(0));
        }
    }

    private void findPath(final int[][] matrix,
                          final int rows,
                          final int cols) {
        if (matrix == null) {
            return;
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                findPathUtil(matrix, new ArrayList<>(), rows, cols, i, j);
            }
        }

    }

    /**
     * @param matrix skiing map.
     * @param rows   number of rows.
     * @param cols   number of cols
     * @param x      row to start
     * @param y      col to start
     */
    private void findPathUtil(final int[][] matrix,
                              final List<Integer> path,
                              final int rows,
                              final int cols,
                              final int x,
                              final int y) {
        if (x < 0 || x > rows) {
            updateResult(path);
            return;
        }

        if (y < 0 || y > cols) {
            updateResult(path);
            return;
        }

        path.add(matrix[x][y]);

        if (isSafe(matrix, rows, cols, x, y, x + 1, y)) {
            findPathUtil(matrix, path, rows, cols, x + 1, y);
            removeAndUpdate(path);
        }

        if (isSafe(matrix, rows, cols, x, y, x, y + 1)) {
            findPathUtil(matrix, path, rows, cols, x, y + 1);
            removeAndUpdate(path);
        }


        if (isSafe(matrix, rows, cols, x, y, x - 1, y)) {
            findPathUtil(matrix, path, rows, cols, x - 1, y);
            removeAndUpdate(path);
        }


        if (isSafe(matrix, rows, cols, x, y, x, y - 1)) {
            findPathUtil(matrix, path, rows, cols, x, y - 1);
            removeAndUpdate(path);
        }
    }

    /**
     * Whether its safe to move from one point to another.
     *
     * @param matrix skiing map.
     * @param rows   number of rows.
     * @param cols   number of cols
     * @param fromX  current position X
     * @param fromY  current position Y
     * @param toX    position to move X
     * @param toY    position to move Y
     * @return true/false depending on whether we can move fromX,fromY to toX, toY
     */
    private boolean isSafe(final int[][] matrix,
                           final int rows,
                           final int cols,
                           final int fromX,
                           final int fromY,
                           final int toX,
                           final int toY) {
        if (toX < 0 || toX > rows) {
            return false;
        }

        if (toY < 0 || toY > cols) {
            return false;
        }

        final int fromValue = matrix[fromX][fromY];
        final int toValue = matrix[toX][toY];

        return toValue < fromValue;
    }

    /**
     * Utility functions to update result.
     */

    private void removeAndUpdate(final List<Integer> path) {
        updateResult(path);
        if (path.size() > 0) {
            path.remove(path.size() - 1);
        }
    }

    private void updateResult(final List<Integer> path) {
        if (path.size() > results.size()) {
            results.clear();
            results.addAll(new ArrayList<>(path));
        } else if (path.size() == results.size()) {
            int resultDiff = results.get(0) - results.get(results.size() - 1);
            int pathDiff = path.get(0) - path.get(path.size() - 1);
            if (pathDiff > resultDiff) {
                results.clear();
                results.addAll(new ArrayList<>(path));
            }
        }
    }

}