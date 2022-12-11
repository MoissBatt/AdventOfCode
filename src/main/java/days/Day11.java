package days;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;

public class Day11 extends Day {
    public class Monkey {
        public ArrayList<Integer> objects;
        public boolean multiply;
        public String toCalcul;
        public int division;
        public int monkeyTrue;
        public int monkeyFalse;
        public int inspectScore;

        public Monkey(ArrayList<Integer> objects, boolean multiply, String toCalcul, int division, int monkeyTrue, int monkeyFalse) {
            this.objects = objects;
            this.multiply = multiply;
            this.toCalcul = toCalcul;
            this.division = division;
            this.monkeyTrue = monkeyTrue;
            this.monkeyFalse = monkeyFalse;
            this.inspectScore = 0;

        }

        public int play(int object) {
            int worryLevel = inspect(object);
            return Math.floorDiv(worryLevel, 3);
        }

        private int inspect(int object) {
            this.inspectScore++;
            int toCalculInt = toCalcul.equals("old") ? object : Integer.parseInt(toCalcul);
            if (multiply) {
                return object * toCalculInt;
            }
            return object + toCalculInt;
        }
    }

    private HashMap<Integer, Monkey> monkeys;

    public Day11() {
        super(11, "input_11.txt");
        monkeys = new HashMap<>();
    }

    public void go() {
        populateMonkeys();
        playAround(20);
        for (Monkey monkey : monkeys.values())
            System.out.println(monkey.inspectScore);
    }

    private void playAround(int maxRound) {
        for (int i = 0; i < maxRound; i++) {
            for (int j = 0; j < monkeys.size(); j++) {
                for (int k = 0; k < monkeys.get(j).objects.size(); k++) {
                    int newValue = monkeys.get(j).play(monkeys.get(j).objects.get(k));
                    monkeys.get(j).objects.remove(0);
                    if (newValue % monkeys.get(j).division == 0)
                        monkeys.get(monkeys.get(j).monkeyTrue).objects.add(newValue);
                    else
                        monkeys.get(monkeys.get(j).monkeyFalse).objects.add(newValue);
                }
            }
        }
    }

    private void populateMonkeys() {
        int name = 0;
        for (int i = 0; i < input.size(); i += 7) {
            monkeys.put(name, new Monkey(
                    parseObjectsList(input.get(i + 1)),
                    input.get(i + 2).contains("*"),
                    input.get(i + 2).split(" ")[input.get(i + 2).split(" ").length - 1],
                    Integer.parseInt(input.get(i + 3).split("  Test: divisible by ")[1]),
                    Integer.parseInt(input.get(i + 4).split("    If true: throw to monkey ")[1]),
                    Integer.parseInt(input.get(i + 5).split("    If false: throw to monkey ")[1])));
            name++;
        }
    }

    private ArrayList<Integer> parseObjectsList(String line) {
        String[] parsedLine = line.split("  Starting items: |, ");
        ArrayList<Integer> objects = new ArrayList<>();
        for (int i = 1; i < parsedLine.length; i++) {
            objects.add(Integer.parseInt(parsedLine[i]));
        }
        return objects;
    }
}
