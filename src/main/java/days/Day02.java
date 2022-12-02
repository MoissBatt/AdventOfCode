package days;

import java.util.HashMap;

public class Day02 extends Day {
    private HashMap<String, Integer> gameModel;
    private HashMap<String, Integer> gameModel2;
    private int score;
    private int score2;

    public Day02() {
        super(2, "input_2.txt");
        this.gameModel = new HashMap<>();
        this.gameModel2 = new HashMap<>();
        this.score = 0;
        this.score2 = 0;
    }

    public void go() {
        fillGameModel();
        fillGameModel2();

        for (String line : input) {
            score += gameModel.get(line);
            score2 += gameModel2.get(line);
        }
        System.out.println("Score total : " + score);
        System.out.println("Score total 2 : " + score2);
    }


    private void fillGameModel() {
        gameModel.put("A X", 4);
        gameModel.put("B X", 1);
        gameModel.put("C X", 7);
        gameModel.put("A Y", 8);
        gameModel.put("B Y", 5);
        gameModel.put("C Y", 2);
        gameModel.put("A Z", 3);
        gameModel.put("B Z", 9);
        gameModel.put("C Z", 6);
    }

    private void fillGameModel2() {
        gameModel2.put("A X", 3);
        gameModel2.put("B X", 1);
        gameModel2.put("C X", 2);
        gameModel2.put("A Y", 4);
        gameModel2.put("B Y", 5);
        gameModel2.put("C Y", 6);
        gameModel2.put("A Z", 8);
        gameModel2.put("B Z", 9);
        gameModel2.put("C Z", 7);
    }
}
