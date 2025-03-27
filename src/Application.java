import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            System.out.println("Original file content:");
            printSmallTextFile("in.txt");

            System.out.println("\n\n");
            printWithNewlineAfterDot("in.txt");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void printSmallTextFile(String fileName) throws IOException {
        System.out.println("Using Files.readAllLines:");
        Path path = Paths.get(fileName);
        List<String> allLinesInMemory = Files.readAllLines(path);
        for (String line : allLinesInMemory) {
            System.out.println(": " + line);
        }
    }

    static void printWithNewlineAfterDot(String fileName) throws IOException {
        System.out.println("Reading file and adding newline after '.' :");
        Path path = Paths.get(fileName);
        List<String> lines = Files.readAllLines(path);

        for (String line : lines) {
            String modifiedLine = line.replace(".", ".\n"); // Adaugă un newline după fiecare '.'
            System.out.print(": " + modifiedLine + "\n");
        }
    }
}
