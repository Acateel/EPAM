package epam.task10;

import java.util.Arrays;

public class UsersList {
    User[] users;

    public UsersList(User[] users) {
        this.users = users;
    }

    public UsersList() {
        this.users = new User[0];
    }

    public void addUser(User user) {
        users = Arrays.copyOf(users, users.length + 1);
        users[users.length - 1] = user;
    }

    public void addUsers(User[] userArray) {
        for (var user : userArray) {
            users = Arrays.copyOf(users, users.length + 1);
            users[users.length - 1] = user;
        }
    }

    public double getMaxSalary() {
        double maxSalary = 0;
        for (var user : users) {
            if (maxSalary < user.getSalary()) {
                maxSalary = user.getSalary();
            }
        }
        return maxSalary;
    }

    public User getUserWithMinSalary() {
        User userWithMinSalary = new User("", "", getMaxSalary());
        for (var user : users) {
            if (userWithMinSalary.getSalary() > user.getSalary()) {
                userWithMinSalary = user;
            }
        }
        return userWithMinSalary;
    }

    public double getAverageSalary() {
        double average = 0;
        for (var user : users) {
            average += user.getSalary();
        }
        average /= users.length;
        return average;
    }

    public User[] getUsersWithAverageSalary(double present) {
        User[] usersWithAverageSalary = new User[0];
        double minValue = getAverageSalary() * (1 - present / 100);
        double maxValue = getAverageSalary() * (1 + present / 100);
        for (var user : users) {
            if (user.getSalary() >= minValue && user.getSalary() <= maxValue) {
                usersWithAverageSalary = Arrays.copyOf(usersWithAverageSalary, usersWithAverageSalary.length + 1);
                usersWithAverageSalary[usersWithAverageSalary.length - 1] = user;
            }
        }
        return usersWithAverageSalary;
    }
}
