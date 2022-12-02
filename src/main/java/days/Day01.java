package days;

import java.util.HashMap;
import java.util.Map;

public class Day01 extends Day {
    private int totalBestStock;
    private HashMap<Integer, Integer> elvesStocks;

    public Day01() {
        super(1, "input_1.txt");
        this.totalBestStock = 0;
        this.elvesStocks = new HashMap<>();
    }

    public void go() {
        int key = 1;
        for (String line : input) {
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

        getRetrieveMaxStock("premier");
        getRetrieveMaxStock("deuxième");
        getRetrieveMaxStock("troisième");

        System.out.println("Le stock des trois premiers : " + totalBestStock);
    }

    private void getRetrieveMaxStock(String rang) {
        Map.Entry<Integer, Integer> maxEntry = elvesStocks.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue()).get();
        elvesStocks.remove(maxEntry.getKey());

        System.out.println("Le " + rang + " au stock : " + maxEntry.getValue()
                + " à la position : " + maxEntry.getKey());

        this.totalBestStock += maxEntry.getValue();
    }
}
