package dp;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by vivek.pathak on 24/09/16.
 */
public class MinimumNumberOfSteps {

    public int getMinimumNumSteps(final int targetNumber) {
        if (targetNumber == 0 || targetNumber == 1 || targetNumber == 2 || targetNumber < 0) {
            return targetNumber;
        }

        final Map<Integer, Integer> memo = new HashMap<>();
        return getMinimumNumStepsUtil(targetNumber, 2, memo) + 2;
    }

    private int getMinimumNumStepsUtil(final int targetNumber,
                                       final int currentNumber,
                                       final Map<Integer, Integer> memo) {

        if (currentNumber == targetNumber) {
            return 0;
        }

        if (currentNumber > targetNumber) {
            return Integer.MAX_VALUE;
        }

        if (memo.containsKey(currentNumber)) {
            return memo.get(currentNumber);
        }

        final int res = Math.min(getMinimumNumStepsUtil(targetNumber, currentNumber + 1, memo),
                getMinimumNumStepsUtil(targetNumber, 2 * currentNumber, memo)) + 1;
        memo.put(currentNumber, res);
        return res;
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        System.out.println(new MinimumNumberOfSteps().getMinimumNumSteps(number));
    }
}
