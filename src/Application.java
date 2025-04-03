import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        String inputFile="in.txt";
        String outputFile="out.txt";
        try {
            System.out.println("Original file content:");
            printSmallTextFile("in.txt");

            System.out.println("\n\nModified content with newlines after '.' saved to " + outputFile);
            saveModifiedTextToFile(inputFile, outputFile);

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

    static void saveModifiedTextToFile(String inputFile, String outputFile) throws IOException {
        Path inputPath = Paths.get(inputFile);
        Path outputPath = Paths.get(outputFile);

        List<String> lines = Files.readAllLines(inputPath);
        StringBuilder modifiedContent = new StringBuilder();

        for (String line : lines) {
            modifiedContent.append(line.replace(".", ".\n")).append("\n");
        }

        Files.write(outputPath, modifiedContent.toString().getBytes());
        System.out.println("Modified content saved to " + outputFile);
    }
}
