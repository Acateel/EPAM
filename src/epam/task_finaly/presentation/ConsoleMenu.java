package epam.task_finaly.presentation;

import epam.task_finaly.servise.Country;
import epam.task_finaly.servise.Service;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleMenu {
    public static void main(String[] args) throws IOException {
        ConsoleMenu consoleMenu = new ConsoleMenu();
        consoleMenu.start();
    }

    Service service;

    public void start() throws IOException {
        service = new Service();
        boolean isRunning = true;

        while (isRunning) {
            meinMenu();
            String command = new Scanner(System.in).nextLine();
            switch (command) {
                case "1" -> showCountries();
                case "2" -> showError("Don`t realize");
                case "3" -> addCountry();
                case "4" -> deleteCountry();
                case "5" -> changeCountryName();
                case "6" -> showError("Don`t realize");
                case "7" -> isRunning = false;
                default -> showError("Command not found");
            }
        }
        service.saveDataBase();
    }

    private void meinMenu() {
        System.out.println("\033[0;32m"); // Green foreground color

        System.out.println("1.Show Countries      | 2.Choice Country | 3.Add Country | 4.Delete Country");
        System.out.println("5.Change country name | 6.Search         |               | 7.Quit");

        System.out.println("\033[0m"); // reset foreground color
    }

    private void showError(String message) {
        System.out.println("\033[0;31m"); // Red foreground color
        System.out.println(message);
        System.out.println("\033[0m"); // reset foreground color
    }

    private void showCountries() {
        var countries = service.getCountries();
        if (countries.isEmpty()) {
            showError("Empty");
            return;
        }
        System.out.println("Countries:");
        for (var country : countries) {
            System.out.println("[" + country.getIdentification() + "] " + country.getName());
        }
    }

    private String getName(boolean skip) {
        while (true) {
            System.out.println("Write name:");
            String name = new Scanner(System.in).nextLine();
            if (name.matches("[a-zA-Z-]+")) {
                return name;
            }
            else if("".equals(name) && skip){
                return name;
            }
            else {
                showError("Name is not format");

            }
        }
    }

    private String getIdentification() {
        while (true) {
            System.out.println("Write identification:");
            String identification = new Scanner(System.in).nextLine();
            if (identification.matches("[0-9]+")) {
                return identification;
            } else {
                showError("Name is not format");

            }
        }
    }

    private void addCountry() {
        if (service.addCountry(new Country(getIdentification(), getName(false)))) {
            System.out.println("Country added");
        } else {
            System.out.println("Country not added. Not Unique Identification");
        }
    }

    private void deleteCountry() {
        if (service.deleteCountry(getIdentification())) {
            System.out.println("Country deleted");
        } else {
            System.out.println("Country not deleted. Country not found");
        }
    }

    private void changeCountryName(){
        var country = service.findCountry(getIdentification());
        if(country == null){
            showError("Country not found");
            return;
        }

        System.out.println("[" + country.getIdentification() + "] " + country.getName());
        String name = getName(true);
        if(name.equals("")){
            System.out.println("Country don't changed");
        }
        else{
            country.setName(name);
            System.out.println("Country name changed");
        }
    }

}
