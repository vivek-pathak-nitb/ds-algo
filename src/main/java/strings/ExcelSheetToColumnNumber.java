package strings;

import java.util.Scanner;

/**
 * Created by vivek.pathak on 18/05/16.
 */
public class ExcelSheetToColumnNumber {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String str = scanner.nextLine();
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            sum = sum * 26 + (str.charAt(i) - 'A'+1);
        }

        System.out.println(sum);
    }
}
