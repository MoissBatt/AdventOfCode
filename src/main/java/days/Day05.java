package days;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Day05 extends Day {
    private final HashMap<Integer, ArrayList<String>> pilesSet;

    public Day05() {
        super(5, "input_5.txt");
        this.pilesSet = new HashMap<>();
    }

    public void go() {
        populatePilesSet();
        moveCrates9000();
        System.out.print("Les boites en haut des tas sont : ");
        for (int i = 1; i <= pilesSet.size(); i++) {
            System.out.print(pilesSet.get(i).get(pilesSet.get(i).size() - 1));
        }

        System.out.println();
        populatePilesSet();
        moveCrates9001();
        System.out.print("Les boites en haut des tas sont : ");
        for (int i = 1; i <= pilesSet.size(); i++) {
            System.out.print(pilesSet.get(i).get(pilesSet.get(i).size() - 1));
        }
        System.out.println();
    }

    private void populatePilesSet() {
        pilesSet.put(1, new ArrayList<>(Arrays.asList("H", "T", "Z", "D")));
        pilesSet.put(2, new ArrayList<>(Arrays.asList("Q", "R", "W", "T", "G", "C", "S")));
        pilesSet.put(3, new ArrayList<>(Arrays.asList("P", "B", "F", "Q", "N", "R", "C", "H")));
        pilesSet.put(4, new ArrayList<>(Arrays.asList("L", "C", "N", "F", "H", "Z")));
        pilesSet.put(5, new ArrayList<>(Arrays.asList("G", "L", "F", "Q", "S")));
        pilesSet.put(6, new ArrayList<>(Arrays.asList("V", "P", "W", "Z", "B", "R", "C", "S")));
        pilesSet.put(7, new ArrayList<>(Arrays.asList("Z", "F", "J")));
        pilesSet.put(8, new ArrayList<>(Arrays.asList("D", "L", "V", "Z", "R", "H", "Q")));
        pilesSet.put(9, new ArrayList<>(Arrays.asList("B", "H", "G", "N", "F", "Z", "L", "D")));
    }

    private void moveCrates9000() {
        for (String line : input.subList(10, input.size())) {
            String[] moveString = line.split("move | from | to ");
            int[] move = {Integer.parseInt(moveString[1]), Integer.parseInt(moveString[2]), Integer.parseInt(moveString[3])};

            for (int i = 1; i <= move[0]; i++) {
                pilesSet.get(move[2]).add(pilesSet.get(move[1]).get(pilesSet.get(move[1]).size() - 1));
                pilesSet.get(move[1]).remove(pilesSet.get(move[1]).size() - 1);
            }
        }
    }

    private void moveCrates9001() {
        for (String line : input.subList(10, input.size())) {
            String[] moveString = line.split("move | from | to ");
            int[] move = {Integer.parseInt(moveString[1]), Integer.parseInt(moveString[2]), Integer.parseInt(moveString[3])};

            List<String> toMove = pilesSet.get(move[1]).subList(pilesSet.get(move[1]).size() - move[0], pilesSet.get(move[1]).size());
            pilesSet.get(move[2]).addAll(toMove);
            for (int i = 1; i <= move[0]; i++) {
                pilesSet.get(move[1]).remove(pilesSet.get(move[1]).size() - 1);
            }
        }
    }

}
