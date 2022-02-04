package epam.basic.task10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;

public class UserListHelper {
    public static String[] readCsvFile(String path, Charset charset) {
        String[] result;

        try {
            result = new String[0];
            BufferedReader input = new BufferedReader(new FileReader(path, charset));
            input.readLine();

            while (input.ready()) {
                String line = input.readLine();
                result = Arrays.copyOf(result, result.length + 1);
                result[result.length - 1] = line;
            }
        } catch (IOException ex) {
            result = new String[0];
        }

        return result;
    }

    public static User[] getUsers(String[] lines) {
        User[] users = new User[0];
        String[] temp;
        for (String line : lines) {
            temp = line.split(";");
            users = Arrays.copyOf(users, users.length + 1);
            users[users.length - 1] = new User(temp[0], temp[1], convertSalaryToDouble(temp[temp.length - 1]));
        }
        return users;
    }

    public static double convertSalaryToDouble(String salary) {
        salary = salary.replaceAll("[^0-9,]", "").replace(",", ".");
        return Double.parseDouble(salary);
    }

    public static User[] getUserFromCsv(String path, Charset charset) {
        return getUsers(readCsvFile(path, charset));
    }
}
