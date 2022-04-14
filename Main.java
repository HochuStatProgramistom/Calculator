import сalculator.Calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a math expression: ");
        String mathExpression = scanner.nextLine();
        System.out.println("Answer: " + calculator.calc(mathExpression));
    }
}
