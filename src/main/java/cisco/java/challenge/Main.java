package cisco.java.challenge;

import cisco.java.challenge.counter.WordCounter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {


        WordCounter wordCounter = new WordCounter();
        String file = "Files/myFile.txt";
        String fileData = readUsingFiles(file);
        System.out.println(wordCounter.count(fileData));
    }

    private static String readUsingFiles(String file) throws IOException {
        return new String(Files.readAllBytes(Paths.get(file)));
    }
}
