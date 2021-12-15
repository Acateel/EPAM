package epam.task10;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Main {
    static UsersList users;

    public static void main(String[] args) throws IOException {
        String path = "src\\epam\\task10\\resourse\\";
        String[] months = new String[]{
                "berezen",
                "kviten",
                "lupen"
        } ;
        UsersList[] usersLists = new UsersList[]{
                new UsersList(UserListHelper.getUserFromCsv(path + months[0] + "-2019.csv", StandardCharsets.UTF_8)),
                new UsersList(UserListHelper.getUserFromCsv(path + months[1] + "-2019.csv", StandardCharsets.UTF_8)),
                new UsersList(UserListHelper.getUserFromCsv(path + months[2] + "-2019.csv", Charset.forName("WINDOWS-1251")))
        };

        showMaxSalary(usersLists);

        showUserWithMinSalary(usersLists[0]);

        showUserWithAverageSalary(usersLists[0]);

        showAverageSalary(usersLists, months);

        showMaxAverageSalary(months, usersLists);
    }

    private static void showMaxAverageSalary(String[] months, UsersList[] usersLists) {
        String month = months[0];
        double maxAverage = usersLists[0].getAverageSalary();
        for (int i = 1; i < usersLists.length; i++) {
            if(usersLists[i].getAverageSalary() > maxAverage){
                maxAverage = usersLists[i].getAverageSalary();
                month = months[i];
            }
        }
        System.out.println("\nMax average salary: " + month + "\t" + Math.round(maxAverage*100.0)/100.0);
    }

    private static void showUserWithAverageSalary(UsersList usersList) {
        System.out.println("\nUsers with average salary:");
        for(var user : usersList.getUsersWithAverageSalary(20)){
            System.out.println(user.getName()+ "\t" + user.getSalary());
        }
    }

    private static void showUserWithMinSalary(UsersList usersList) {
        var userWithMinSalary = usersList.getUserWithMinSalary();
        System.out.println("\nUser with Min Salary: " + userWithMinSalary.getName() + "\t" + userWithMinSalary.getSalary());
    }

    private static void showMaxSalary(UsersList[] usersLists) {
        double maxSalary = 0;
        for (UsersList usersList : usersLists) {
            maxSalary = Math.max(maxSalary, usersList.getMaxSalary());
        }
        System.out.println("\nMax salary: " + maxSalary);
    }

    private static void showAverageSalary(UsersList[] usersLists, String[] month) {
        System.out.println("\nAverage salary:");
        for (int i = 0; i < usersLists.length; i++) {
            System.out.println(month[i] + "\t" + Math.round(usersLists[i].getAverageSalary()*100.0)/100.0);
        }
    }

}
