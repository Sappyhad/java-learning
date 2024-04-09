package IsEvenChecker;

import java.util.Scanner;

public class IsEvenCheckerClass {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Give INTEGER number to check if it's even or odd: ");
        int number = scanner.nextInt();

        if (number % 2 == 0) {
            System.out.println("Number " + number + " is even");
        }
        else {
            System.out.println("Number " + number + " is odd");
        }
    }
}
