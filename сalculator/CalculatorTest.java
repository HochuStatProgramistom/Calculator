package сalculator;

import java.util.HashMap;

public class CalculatorTest {
    public void arabicExpressionСheck(String[] mathematicalExpression) {
        String[] letters = mathematicalExpression;
        int count = 0;
        for (String letter : letters) {
            if (String.valueOf(letter).equals("+") || String.valueOf(letter).equals("*")
                    || String.valueOf(letter).equals("/") || String.valueOf(letter).equals("-")) {
                count++;
            } else {
                try {
                    Integer.parseInt(letter);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException(letter + " is not a valid integer");
                }
                if (Integer.valueOf(letter) == 0)
                    throw new IllegalArgumentException("The number must be greater than 0!");
                if (Integer.valueOf(letter) > 10)
                    throw new IllegalArgumentException("The number must not be greater than 10!");
                if (Integer.valueOf(letter) < 1)
                    throw new IllegalArgumentException("The number must not be less than 1!");
            }
        }
        if (count != 1)
            throw new IllegalArgumentException("the number of operators must not exceed one!");
    }

    public void romanExpressionCheck(String[] mathematicalExpression) {
        String[] letters = mathematicalExpression;
        HashMap<String, Integer> romanInt = new HashMap<>();
        romanInt.put("I", 1);
        romanInt.put("II", 2);
        romanInt.put("III", 3);
        romanInt.put("IV", 4);
        romanInt.put("V", 5);
        romanInt.put("VI", 6);
        romanInt.put("VII", 7);
        romanInt.put("VIII", 8);
        romanInt.put("IX", 9);
        romanInt.put("X", 10);
        int count = 0;
        for (String letter : letters) {
            if (String.valueOf(letter).equals("+") || String.valueOf(letter).equals("*")
                    || String.valueOf(letter).equals("/") || String.valueOf(letter).equals("-")) {
                count++;
            } else {
                for (int i = 0; i < romanInt.size(); i++) {
                    if (romanInt.get(letter) == null)
                        throw new IllegalArgumentException("Roman numerals must be no more than 10 and must not have a fractional part!");
                }
            }
        }
        if (count != 1)
            throw new IllegalArgumentException("the number of operators must not exceed one!");
    }
}
