package strings;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountAndSay {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        final List<String> result = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder("1");
        for (int i = 1; i <= n; i++) {
            char c = stringBuilder.charAt(0);
            int count = 1;
            StringBuilder res = new StringBuilder();
            for (int j = 1; j < stringBuilder.length(); j++) {
                if (c == stringBuilder.charAt(j)) {
                    count++;
                } else {
                    res.append(count).append(c);
                    count = 1;
                    c = stringBuilder.charAt(j);
                }
            }

            res.append(count).append(c);
            result.add(res.toString());
            stringBuilder = res;
        }

        result.forEach(System.out::println);
    }

}
