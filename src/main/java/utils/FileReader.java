package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

public class FileReader {
    public ArrayList<String> fileReader(String filename) {
        try {
            File file;
            URL resource = getClass().getClassLoader().getResource(filename);
            file = new File(resource.toURI());

            BufferedReader br = new BufferedReader(new java.io.FileReader(file));
            String line;
            ArrayList<String> input = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                input.add(line);
            }
            return input;
        } catch (IOException | URISyntaxException e) {
            System.out.printf(e.getMessage());
        }
        return null;
    }
}
