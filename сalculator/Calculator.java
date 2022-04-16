package сalculator;

import java.util.HashMap;

public class Calculator {

    public static String calc(String input) {
        String[] signOfmathematicalOperation = {"+", "-", "/", "*"};
        String result;
        Boolean mathematicalExpressionIsRoman = false;
        String currentSignOfmathematicalOperation = "";
        String[] operands = new String[2];
        String[] inputWithoutSpaces = deleteSpaces(input);
        if (isRoman(inputWithoutSpaces)) {
            mathematicalExpressionIsRoman = true;
        }
        checkingMathematicalExpression(mathematicalExpressionIsRoman, inputWithoutSpaces);
        for (String value : inputWithoutSpaces) {
            for (String sign : signOfmathematicalOperation) {
                if (value.equals(sign)) {
                    operands[0] = inputWithoutSpaces[0];
                    operands[1] = inputWithoutSpaces[2];
                    currentSignOfmathematicalOperation = sign;
                }
            }
        }
        if (mathematicalExpressionIsRoman == false) {
            result = arabicCalc(operands, currentSignOfmathematicalOperation);
        } else {
            result = romanCalc(operands, currentSignOfmathematicalOperation);
        }
        return result;
    }

    private static Integer multiplication(Integer firstOperand, Integer secondOperand) {
        Integer result;
        result = firstOperand * secondOperand;
        return result;
    }

    private static Integer division(Integer firstOperand, Integer secondOperand) {
        Integer result;
        result = firstOperand / secondOperand;
        return result;
    }

    private static Integer addition(Integer firstOperand, Integer secondOperand) {
        Integer result;
        result = firstOperand + secondOperand;
        return result;
    }

    private static Integer subtraction(Integer firstOperand, Integer secondOperand) {
        Integer result;
        result = firstOperand - secondOperand;
        return result;
    }

    private static Integer performingMathematicalOperation(Integer firstOperand, Integer secondOperand,
                                                           String currentSignOfmathematicalOperation) {
        Integer result = null;
        if (currentSignOfmathematicalOperation.equals("*")) {
            result = multiplication(firstOperand, secondOperand);
        } else if (currentSignOfmathematicalOperation.equals("+")) {
            result = addition(firstOperand, secondOperand);
        } else if (currentSignOfmathematicalOperation.equals("-")) {
            result = subtraction(firstOperand, secondOperand);
        } else if (currentSignOfmathematicalOperation.equals("/")) {
            result = division(firstOperand, secondOperand);
        }
        return result;
    }

    private static String arabicCalc(String[] operands, String currentSignOfmathematicalOperation) {
        Integer result;
        Integer firstOperand = Integer.valueOf(operands[0]);
        Integer secondOperand = Integer.valueOf(operands[1]);
        result = performingMathematicalOperation(firstOperand, secondOperand, currentSignOfmathematicalOperation);
        return result.toString();
    }

    private static String arabicToRoman(Integer operand) {
        String arabicInt;
        HashMap<Integer, String> romanInt = new HashMap<>();
        romanInt.put(1, "I");
        romanInt.put(2, "II");
        romanInt.put(3, "III");
        romanInt.put(4, "IV");
        romanInt.put(5, "V");
        romanInt.put(6, "VI");
        romanInt.put(7, "VII");
        romanInt.put(8, "VIII");
        romanInt.put(9, "IX");
        romanInt.put(10, "X");
        arabicInt = romanInt.get(operand);
        return arabicInt;
    }

    private static Integer lastDigit(Integer number) {
        Integer lastDigit = (number % 10);
        return lastDigit;
    }

    private static String romanCalc(String[] operands, String currentSignOfmathematicalOperation) {
        String result;
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
        Integer firstOperand = romanInt.get(operands[0]);
        Integer secondOperand = romanInt.get(operands[1]);
        HashMap<Integer, String> romanNum = new HashMap<>();
        romanNum.put(10, "X");
        romanNum.put(20, "XX");
        romanNum.put(30, "XXX");
        romanNum.put(40, "XL");
        romanNum.put(50, "L");
        romanNum.put(60, "LX");
        romanNum.put(70, "LXX");
        romanNum.put(80, "LXXX");
        romanNum.put(90, "XC");
        romanNum.put(100, "C");
        result = performingMathematicalOperation(firstOperand, secondOperand, currentSignOfmathematicalOperation).toString();
        if (Integer.valueOf(result) < 1) {
            result = "";
        } else {
            if (Integer.valueOf(result) > 0 && Integer.valueOf(result) < 11) {
                if (Integer.valueOf(result) != 10) {
                    result = arabicToRoman(lastDigit(Integer.valueOf(result)));
                } else {
                    result = romanNum.get(10);
                }
            } else if (Integer.valueOf(result) > 10 && Integer.valueOf(result) < 21) {
                if (Integer.valueOf(result) != 20) {
                    result = romanNum.get(10) + arabicToRoman(lastDigit(Integer.valueOf(result)));
                } else {
                    result = romanNum.get(20);
                }
            } else if (Integer.valueOf(result) > 20 && Integer.valueOf(result) < 31) {
                if (Integer.valueOf(result) != 30) {
                    result = romanNum.get(20) + arabicToRoman(lastDigit(Integer.valueOf(result)));
                } else {
                    result = romanNum.get(30);
                }
            } else if (Integer.valueOf(result) > 30 && Integer.valueOf(result) < 41) {
                if (Integer.valueOf(result) != 40) {
                    result = romanNum.get(30) + arabicToRoman(lastDigit(Integer.valueOf(result)));
                } else {
                    result = romanNum.get(40);
                }
            } else if (Integer.valueOf(result) > 40 && Integer.valueOf(result) < 51) {
                if (Integer.valueOf(result) != 50) {
                    result = romanNum.get(40) + arabicToRoman(lastDigit(Integer.valueOf(result)));
                } else {
                    result = romanNum.get(50);
                }
            } else if (Integer.valueOf(result) > 50 && Integer.valueOf(result) < 61) {
                if (Integer.valueOf(result) != 60) {
                    result = romanNum.get(50) + arabicToRoman(lastDigit(Integer.valueOf(result)));
                } else {
                    result = romanNum.get(60);
                }
            } else if (Integer.valueOf(result) > 60 && Integer.valueOf(result) < 71) {
                if (Integer.valueOf(result) != 70) {
                    result = romanNum.get(60) + arabicToRoman(lastDigit(Integer.valueOf(result)));
                } else {
                    result = romanNum.get(70);
                }
            } else if (Integer.valueOf(result) > 70 && Integer.valueOf(result) < 81) {
                if (Integer.valueOf(result) != 80) {
                    result = romanNum.get(70) + arabicToRoman(lastDigit(Integer.valueOf(result)));
                } else {
                    result = romanNum.get(80);
                }
            } else if (Integer.valueOf(result) > 80 && Integer.valueOf(result) < 91) {
                if (Integer.valueOf(result) != 90) {
                    result = romanNum.get(80) + arabicToRoman(lastDigit(Integer.valueOf(result)));
                } else {
                    result = romanNum.get(90);
                }
            } else if (Integer.valueOf(result) > 90 && Integer.valueOf(result) < 101) {
                if (Integer.valueOf(result) != 100) {
                    result = romanNum.get(90) + arabicToRoman(lastDigit(Integer.valueOf(result)));
                } else {
                    result = romanNum.get(100);
                }
            }
        }
        return result;
    }

    private static void checkingMathematicalExpression(Boolean mathematicalExpressionIsRoman, String[] inputWithoutSpaces) {
        CalculatorTest calculatorTest = new CalculatorTest();
        if (mathematicalExpressionIsRoman == false) {
            calculatorTest.arabicExpressionСheck(inputWithoutSpaces);
        } else {
            calculatorTest.romanExpressionCheck(inputWithoutSpaces);
        }
    }

    private static String[] deleteSpaces(String input) {
        String[] operands = input.split(" ", 3);
        return operands;
    }

    private static Boolean isRoman(String[] RomanNumbers) {
        Boolean result = false;
        Integer count = 0;
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
        for (String RomanNumber : RomanNumbers) {
            if (romanInt.get(RomanNumber) != null) {
                count++;
            }
        }

        if (count == 1)
            throw new IllegalArgumentException("the mathematical expression is entered incorrectly, or contains Arabic and Roman numerals together!");
        if (count == 2) {
            result = true;
        }
        return result;
    }
}
