import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
    static void writeFile(String[] userData) throws IOException {
        String filename = userData[0] + ".txt";
        File file = new File(filename);

        // Если файл не существует, создаем его
        if (!file.exists()) {
            file.createNewFile();
        }

        try (FileWriter writer = new FileWriter(filename, true)) {
            for (int i = 0; i < 5; i++) {
                writer.write(userData[i] + ", " );
            };
            writer.write(userData[5] + "\n" );

            }
        catch (IOException e) {
            throw new IOException("Ошибка при записи данных в файл.", e);
        }
    }
}