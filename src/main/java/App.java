import utils.FileReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class App {

    public static void main(String[] args) throws IOException, URISyntaxException {
        System.out.println("\n-------- ADVENT OF CODE --------\n");
        dayOne();
    }

    public static void dayOne() throws IOException, URISyntaxException {
        System.out.println(">> ADVENT OF CODE -- DAY 1 -- START");
        FileReader fileReader = new FileReader();
        BufferedReader br = fileReader.fileReader();

        HashMap<Integer, Integer> elvesStocks = new HashMap<>();
        int key = 1;
        String line;
        while ((line = br.readLine()) != null) {
            if (!line.isBlank()) {
                if (elvesStocks.get(key) != null) {
                    elvesStocks.put(key, Integer.parseInt(line) + elvesStocks.get(key));
                } else {
                    elvesStocks.put(key, Integer.parseInt(line));
                }
            } else {
                key++;
            }
        }
        System.out.println("Nb d'elfes : " + elvesStocks.size());

        int totalBestStock = 0;

        Map.Entry<Integer, Integer> maxEntry = elvesStocks.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue()).get();
        elvesStocks.remove(maxEntry.getKey());
        totalBestStock += maxEntry.getValue();
        System.out.println("Le premier au stock : " + maxEntry.getValue()
                + " à la position : " + maxEntry.getKey());

        maxEntry = elvesStocks.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue()).get();
        elvesStocks.remove(maxEntry.getKey());
        totalBestStock += maxEntry.getValue();
        System.out.println("Le deuxième au stock : " + maxEntry.getValue()
                + " à la position : " + maxEntry.getKey());

        maxEntry = elvesStocks.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue()).get();
        elvesStocks.remove(maxEntry.getKey());
        totalBestStock += maxEntry.getValue();
        System.out.println("Le troisième au stock : " + maxEntry.getValue()
                + " à la position : " + maxEntry.getKey());

        System.out.println("Le stock des trois premiers : " + totalBestStock);
        System.out.println(">> ADVENT OF CODE -- DAY 1 -- END\n");
    }

    public static void dayTemplate() {
        System.out.println(">> ADVENT OF CODE -- DAY 1 -- START");
        System.out.println(">> ADVENT OF CODE -- DAY 1 -- END\n");
    }

}
