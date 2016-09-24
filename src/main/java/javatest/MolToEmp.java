package javatest;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MolToEmp {

    public static void main(String[] args) {
        final MolToEmp molToEmp = new MolToEmp();
        System.out.printf(molToEmp.toEmpiricalFormula("C6(H12)12O6"));
        System.out.printf(molToEmp.toEmpiricalFormula("CH2OHCH2OH"));
    }

    public String toEmpiricalFormula(final String moleculeFormula) {
        if (moleculeFormula == null || moleculeFormula.length() == 0) {
            return moleculeFormula;
        }

        // PreProcess String for Braces
        final String str = preProcess(moleculeFormula);

        final Map<Character, Integer> characterIntegerMap = new LinkedHashMap<>();
        int i = 0, j = 1;
        for (; j < str.length(); i++, j++) {
            final char c = str.charAt(i);
            if (!characterIntegerMap.containsKey(c)) {
                if (!Character.isDigit(str.charAt(j))) {
                    characterIntegerMap.put(c, 1);
                } else {
                    String numStr = "";
                    while (j < str.length() && Character.isDigit(str.charAt(j))) {
                        numStr += str.charAt(j);
                        j++;
                    }
                    characterIntegerMap.put(c, Integer.valueOf(numStr));
                    i = j - 1;
                }
                continue;
            }

            int count = characterIntegerMap.get(c);
            if (!Character.isDigit(str.charAt(j))) {
                characterIntegerMap.put(c, count + 1);
            } else {
                String numStr = "";
                while (j < str.length() && Character.isDigit(str.charAt(j))) {
                    numStr += str.charAt(j);
                    j++;
                }
                characterIntegerMap.put(c, count + Integer.valueOf(numStr));
                i++;
            }
        }

        if (i < str.length()) {
            final char c = str.charAt(i);
            if (characterIntegerMap.containsKey(c)) {
                characterIntegerMap.put(c, characterIntegerMap.get(c) + 1);
            } else {
                characterIntegerMap.put(c, 1);
            }
        }

        final StringBuilder stringBuilder = new StringBuilder();
        final List<Integer> values = new ArrayList<>(characterIntegerMap.values());
        final int gcd = gcd(values);
        for (final char c : characterIntegerMap.keySet()) {
            int countToAppend = characterIntegerMap.get(c) / gcd;
            stringBuilder.append(c);
            if (countToAppend > 1) {
                stringBuilder.append(countToAppend);
            }
        }

        return stringBuilder.toString();
    }

    private String preProcess(final String str) {
        final StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c != '(') {
                stringBuilder.append(c);
                continue;
            }

            int j = i + 1;
            final List<Character> characters = new ArrayList<>();
            while (str.charAt(j) != ')' && j < str.length()) {
                characters.add(str.charAt(j));
                j++;
            }


            int count = 1;
            j = j + 1;
            String tempStr = "";
            while (j < str.length() && Character.isDigit(str.charAt(j))) {
                tempStr += str.charAt(j);
                j++;
            }
            count = Integer.valueOf(tempStr);

            final StringBuilder builder = new StringBuilder();
            boolean flag = false;
            for (int k = 0; k < characters.size(); k++) {
                if (Character.isDigit(characters.get(k))) {
                    String num = "";
                    while (k < characters.size() && Character.isDigit(characters.get(k))) {
                        num += characters.get(k);
                        k++;
                    }
                    int temp = Integer.valueOf(num) * count;
                    builder.append(temp);
                    if (k < characters.size()) {
                        builder.append(characters.get(k));
                    }
                    flag = false;
                } else {
                    if (flag) {
                        builder.append(count);
                    }
                    builder.append(characters.get(k));
                    flag = true;
                }
            }

            if (flag) {
                builder.append(count);
            }

            i = j - 1;
            stringBuilder.append(builder.toString());
        }

        return stringBuilder.toString();
    }

    private int gcd(final List<Integer> numbers) {
        if (numbers == null || numbers.size() == 0) {
            return 1;
        }

        int result = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++)
            result = gcd(result, numbers.get(i));
        return result;
    }

    private int gcd(final int number1, final int number2) {
        if (number2 == 0) {
            return number1;
        }

        return gcd(number2, number1 % number2);
    }

}

