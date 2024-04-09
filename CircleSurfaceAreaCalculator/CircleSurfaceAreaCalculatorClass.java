package CircleSurfaceAreaCalculator;

import java.util.Scanner;

public class CircleSurfaceAreaCalculatorClass {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        double pi = 3.14;

        System.out.print("Give circle radius: ");   // I've used "print" instead of "println" to get the input in the same line as my message printed in console.
        double r = scanner.nextDouble();

        // A = π r²
        double A = pi * Math.pow(r, 2);

        System.out.println("A = " + A);
        System.out.println("Surface Area of circle with radius " + r + " is approximately equal to " + A);

    }
}
