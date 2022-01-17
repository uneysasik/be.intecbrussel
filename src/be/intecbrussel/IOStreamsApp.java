package be.intecbrussel;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.Files.createFile;

public class IOStreamsApp {
    public static void main(String[] args) {

        Path path = Paths.get("files/IOfiles/Notebook.txt");

        createFile(path);
        writeDataToFile(path);
        readDataFromFile(path);

    }

    private static void createFile(Path path) {
        try {
            Files.createDirectories(path.getParent());

            if (!Files.exists(path)) {
                Files.createFile(path);
            }
        } catch (IOException ioExceptions) {
            ioExceptions.printStackTrace();
        }
    }

    private static void writeDataToFile(Path path) {

        try (FileWriter fileWriter = new FileWriter(path.toFile()) ){
            fileWriter.write("Hello\n");
            fileWriter.write("World\n");
            fileWriter.write("Jean-Pierre\n");

        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    private static void readDataFromFile(Path path) {
        try (FileReader fileReader = new FileReader(path.toFile())) {
            int character;
            while( (character = fileReader.read()) != -1) {
                System.out.print((char) character);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
