import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Application {
    public static void main(String[] args) {
        String inputFile = "in.txt";
        String outputFile = "out.txt";
        String randomWordsFile = "outrand.txt";

        try {
            System.out.println("Original file content:");
            printSmallTextFile(inputFile);

            System.out.println("\n\nModified content with newlines after '.' saved to " + outputFile);
            saveModifiedTextToFile(inputFile, outputFile);

            System.out.println("\n\nGenerating random words file: " + randomWordsFile);
            generateRandomWordsFile(randomWordsFile);
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

    static void generateRandomWordsFile(String fileName) throws IOException {
        Path outputPath = Paths.get(fileName);
        Random random = new Random();
        List<String> lines = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            List<String> words = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                words.add(generateRandomWord(random));
            }
            Collections.sort(words);
            lines.add(String.join(" ", words));
        }

        Files.write(outputPath, lines);
        System.out.println("Random words file saved to " + fileName);
    }

    static String generateRandomWord(Random random) {
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            word.append((char) ('a' + random.nextInt(26)));
        }
        return word.toString();
    }
}
