package days;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Day03 extends Day {
    private HashMap<Integer, String> rucksack1;
    private HashMap<Integer, String> rucksack2;
    private ArrayList<String> items;
    private int value;

    public Day03() {
        super(3, "input_3.txt");
        rucksack1 = new HashMap<>();
        rucksack2 = new HashMap<>();
        items = new ArrayList<>();
        value = 0;
    }

    public void go() {
        populateRucksacks();
        findDuplicateItems();
        convertItemsValue();
        System.out.println("Value of duplicated items is : " + value);

        items = new ArrayList<>();
        value = 0;
        findDuplicateItems2();
        convertItemsValue();
        System.out.println("Value of item badges is : " + value);
    }

    private void populateRucksacks() {
        int rucksack = 0;
        for (String line : input) {
            rucksack1.put(rucksack, line.substring(0, line.length() / 2));
            rucksack2.put(rucksack, line.substring(line.length() / 2));
            rucksack++;
        }
    }

    private void findDuplicateItems() {
        for (Map.Entry<Integer, String> containment1 : rucksack1.entrySet()) {
            boolean found = false;
            int i = 0;
            String[] items1 = containment1.getValue().split("");
            while (!found && i < items1.length) {
                if (rucksack2.get(containment1.getKey()).contains(items1[i])) {
                    items.add(items1[i]);
                    found = true;
                }
                i++;
            }
        }
    }

    private void findDuplicateItems2() {
        for (int i = 0; i < input.size(); i += 3) {
            boolean found = false;
            int j = 0;
            String[] elfSack = input.get(i).split("");
            while (!found && j < elfSack.length) {
                if (input.get(i+1).contains(elfSack[j]) && input.get(i+2).contains(elfSack[j])) {
                    items.add(elfSack[j]);
                    found = true;
                }
                j++;
            }
        }
    }

    private void convertItemsValue() {
        for (String item : items) {
            int asci = item.charAt(0);
            if (asci < 97)
                value += asci - 38;
            else
                value += asci - 96;
        }
    }
}
