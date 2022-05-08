package epam.advanced.practice8.Presentation;

import epam.advanced.practice8.Entities.Film;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHelper {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getCommand() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                showError("Not format");
            }
        }
    }

    public static int getId() {
        while (true) {
            try {
                System.out.println("Write id:");
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                showError("Not format");
            }
        }
    }

    public static int getNumber(){
        while (true) {
            try {
                System.out.println("Write number:");
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                showError("Not format");
            }
        }
    }

    public static String getTitle() {
        while (true) {
            System.out.println("Write title");
            String title = scanner.nextLine();
            if (title.length() <= 3) {
                showError("Short title");
            } else {
                return title;
            }
        }
    }

    public static int getYear() {
        while (true) {
            System.out.println("Write year:");
            int year = scanner.nextInt();
            if (1800 < year) {
                return year;
            } else {
                showError("Not format");
            }
        }
    }

    public static String getCountry() {
        while (true) {
            System.out.println("Write Country");
            String country = scanner.nextLine();
            if (country.length() <= 2) {
                showError("Short title");
            } else {
                return country;
            }
        }
    }

    public static Film getFilm(){
        Film film = new Film();
        film.setTitle(getTitle());
        film.setReleaseYear(getYear());
        film.setReleaseCounty(getCountry());
        return film;
    }

    public static void showError(String message) {
        System.out.print("\u001B[31m");
        System.out.print(message);
        System.out.println("\u001B[0m");
    }
}
