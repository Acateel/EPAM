package epam.advanced.practice8.Presentation;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHelper {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getCommand(){
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                showError("Not format");
            }
        }
    }

    public static void showError(String message){
        System.out.print("\u001B[31m");
        System.out.print(message);
        System.out.println("\u001B[0m");
    }
}
