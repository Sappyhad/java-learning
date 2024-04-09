package CelsiusToFahrenheit;

import java.util.Scanner;

public class CelsiusToFahrenheitClass {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Give temperature in Celsius: ");
        double celsius_degrees = scanner.nextDouble();

        // Fahrenheit temp = (Celsius * 1.8) + 32
        double fahrenheit_temp = (celsius_degrees * 1.8) + 32;

        System.out.println("Given temperature in Fahrenheit is equal to: " + fahrenheit_temp);
    }
}
