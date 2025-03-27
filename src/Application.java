import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            System.out.println("\n\n");
            printAndModifyFile("in.txt");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void printAndModifyFile(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        List<String> lines = Files.readAllLines(path);

        for (String line : lines) {
            System.out.print(": " + line + "\n\n");
        }
    }
}
