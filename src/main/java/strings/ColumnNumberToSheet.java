package strings;

import java.util.Scanner;

/**
 * Created by vivek.pathak on 18/05/16.
 */
public class ColumnNumberToSheet {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        final StringBuilder stringBuilder = new StringBuilder();
        while (number > 0) {
            number--;
            int toADD = number % 26;
            char str = (char) ('A' + toADD);
            number = number / 26;
            stringBuilder.append(str);
        }

        System.out.println(stringBuilder.reverse());
    }
}
