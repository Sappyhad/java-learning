package FactorialCalculator;

import java.util.Scanner;
import java.math.BigInteger;

public class FactorialCalculatorClass {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Give INTEGER number that you want to know factorial of: ");
        int number = scanner.nextInt();

        // because int and long types are too small for numbers higher than 21, I am using BigInteger
        // I assume that using BigInteger is probably not considered as good practice, but I am using it for educational puprose
        BigInteger factorial = BigInteger.ONE;
        for (int i = 1; i <= number; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));  // Multiplication of "BigInteger" by "i" value
        }
        System.out.println("Factorial of number " + number + " is equal to: " + factorial);
    }
}
