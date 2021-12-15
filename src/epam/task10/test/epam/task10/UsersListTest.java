package epam.task10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsersListTest {

    @Test
    void getMaxSalary() {
        UsersList list = new UsersList(new User[]{
                new User("A", "A", 10_000),
                new User("B", "B", 12_000),
                new User("C", "C", 8_000),
                new User("D", "D", 15_000)
        });
        double maxSalary = list.getMaxSalary();
        assertEquals(15_000, maxSalary);
    }

    @Test
    void getUserWithMinSalary() {
        UsersList list = new UsersList();
        list.addUser(new User("A", "A", 10_000));
        list.addUser(new User("B", "B", 12_000));
        list.addUser(new User("C", "C", 8_000));
        list.addUser(new User("D", "D", 15_000));

        var user = list.getUserWithMinSalary();
        assertEquals("C", user.getName());
    }

    @Test
    void getAverageSalary() {
        UsersList list = new UsersList();
        list.addUsers(new User[]{
                new User("A", "A", 10_000),
                new User("B", "B", 12_000),
                new User("C", "C", 8_000),
                new User("D", "D", 15_000)
        });
        double average = list.getAverageSalary();

        assertEquals(11_250, average, 1.0);
    }

    @Test
    void getUsersWithAverageSalary() {
        UsersList list = new UsersList(new User[]{
                new User("A", "A", 15_000),
                new User("B", "B", 25_000),
                new User("C", "C", 8_000),
                new User("D", "D", 15_000)
        });

        var users = list.getUsersWithAverageSalary(20);
        assertEquals(2, users.length);
        assertEquals("A", users[0].getName());
        assertEquals("D", users[1].getName());
    }
}