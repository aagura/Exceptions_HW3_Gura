import java.io.FileWriter;
import java.io.IOException;

public class Datachek {
    static String[] DataCheck(String input) throws DataFormatException {
        String[] parts = input.split(" ");
        if (parts.length != 6) {
            throw new DataFormatException("Неверное количество данных. Ожидается 6 параметров.");
        }

        String[] userData = new String[6];
        int dateOfBirthCount = 0;
        int phoneNumberCount = 0;
        int genderCount = 0;

        for (String part : parts) {
            if (part.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
                if (dateOfBirthCount > 0) {
                    throw new DataFormatException("Неверное количество дат рождения. Ожидается только одна дата рождения.");
                }
                userData[3] = part; // Дата рождения
                dateOfBirthCount++;
            } else if (part.matches("\\d+")) {
                if (phoneNumberCount > 0) {
                    throw new DataFormatException("Неверное количество номеров телефона. Ожидается только один номер телефона.");
                }
                userData[4] = part; // Номер телефона
                phoneNumberCount++;
            } else if (part.equalsIgnoreCase("m") || part.equalsIgnoreCase("f")) {
                if (genderCount > 0) {
                    throw new DataFormatException("Неверное количество пола. Ожидается только один символ 'f' или 'm'.");
                }
                userData[5] = part.toLowerCase(); // Пол
                genderCount++;
            } else {
                if (userData[0] == null) {
                    userData[0] = part; // Фамилия
                } else if (userData[1] == null) {
                    userData[1] = part; // Имя
                } else if (userData[2] == null) {
                    userData[2] = part; // Отчество
                }
            }
        }

        if (userData[3] == null) {
            throw new DataFormatException("Отсутствует дата рождения. Ожидается формат dd.mm.yyyy.");
        }

        if (userData[4] == null) {
            throw new DataFormatException("Отсутствует номер телефона. Ожидается целое беззнаковое число.");
        }

        if (userData[5] == null) {
            throw new DataFormatException("Отсутствует пол. Ожидается символ 'f' или 'm'.");
        }

        return userData;
    }

}

