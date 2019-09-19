package L01_QuickSort;

/**
 * Read words from file. Sort them and save into another file.
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String SOURCE = "src/L01_QuickSort/source.txt";
    private static final String SORTED = "src/L01_QuickSort/sorted.txt";

    public static void main(String[] args) throws IOException {
        String text = readDataFromFile(SOURCE);
        List<String> words = Arrays.asList(text.split(" "));
        SortAlgorithms.quickSort(words);
        printData(words);
        saveDataIntoFile(words, SORTED);
    }

    private static void printData(List<String> data) {
        data.forEach(System.out::println);
    }
    private static String readDataFromFile(String path) {
        String text = "";
        try (Scanner scanner = new Scanner(new File(path))) {
            while (scanner.hasNext()){
                text += scanner.nextLine();
                text += " ";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }
    private static void saveDataIntoFile(List<String> data, String outputFile) {
        try(FileWriter writer = new FileWriter(outputFile))
        {
            for (String word: data) {
                writer.append(word);
                writer.append('\n');
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}