package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class FileReader {
    public BufferedReader fileReader(String filename)  {
        try {
            File file;
            URL resource = getClass().getClassLoader().getResource(filename);
            if (resource == null) {
                throw new IllegalArgumentException("file not found!");
            } else {
                file = new File(resource.toURI());
            }
            BufferedReader br = new BufferedReader(new java.io.FileReader(file));
            return br;
        }catch(IOException e) {
            System.out.printf(e.getMessage());
        } catch(URISyntaxException e){
            System.out.printf(e.getMessage());
        }
        return null;
    }
}
