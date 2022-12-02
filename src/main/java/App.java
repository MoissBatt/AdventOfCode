import utils.FileReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class App {

    public static void main(String[] args) throws IOException {
        System.out.println("\n-------- ADVENT OF CODE --------\n");
        FileReader fileReader = new FileReader();
        dayOne(fileReader);
        dayTwo(fileReader);
    }

    public static void dayOne(FileReader fileReader) throws IOException {
        System.out.println(">> ADVENT OF CODE -- DAY 1 -- START");
        BufferedReader br = fileReader.fileReader("input_1.txt");

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

    public static void dayTwo(FileReader fileReader) throws IOException {
        System.out.println(">> ADVENT OF CODE -- DAY 2 -- START");
        BufferedReader br = fileReader.fileReader("input_2.txt");

        HashMap<String, Integer> gameModel = new HashMap<>();
        gameModel.put("A X", 4);
        gameModel.put("B X", 1);
        gameModel.put("C X", 7);
        gameModel.put("A Y", 8);
        gameModel.put("B Y", 5);
        gameModel.put("C Y", 2);
        gameModel.put("A Z", 3);
        gameModel.put("B Z", 9);
        gameModel.put("C Z", 6);

        HashMap<String, Integer> gameModel2 = new HashMap<>();
        gameModel2.put("A X", 3);
        gameModel2.put("B X", 1);
        gameModel2.put("C X", 2);
        gameModel2.put("A Y", 4);
        gameModel2.put("B Y", 5);
        gameModel2.put("C Y", 6);
        gameModel2.put("A Z", 8);
        gameModel2.put("B Z", 9);
        gameModel2.put("C Z", 7);

        int score = 0;
        int score2 = 0;
        String line;
        while ((line = br.readLine())!= null){
            score += gameModel.get(line);
            score2 += gameModel2.get(line);
        }
        System.out.println("Score total : "+ score);
        System.out.println("Score total 2 : "+ score2);

        System.out.println(">> ADVENT OF CODE -- DAY 2 -- END\n");
    }

    public static void dayTemplate(FileReader fileReader) throws IOException  {
        System.out.println(">> ADVENT OF CODE -- DAY 1 -- START");
        System.out.println(">> ADVENT OF CODE -- DAY 1 -- END\n");
    }

}
