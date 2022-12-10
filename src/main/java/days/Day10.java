package days;

import java.util.ArrayList;

public class Day10 extends Day {
    public int x;
    public int nbCycle;
    public int toIncrement;
    public int result;
    public ArrayList<String> crtScreen;

    public Day10() {
        super(10, "input_10.txt");
        x = 1;
        nbCycle = 0;
        toIncrement = 0;
        result = 0;
        crtScreen = new ArrayList<>();
    }

    public void go() {
        readCPU();
        System.out.println("La valeur des messages est de : " + result);
        for (int i = 0; i < 240; i += 40) {
            for (int j = i; j < i + 40; j++) {
                System.out.print(crtScreen.get(j));
            }
            System.out.println();
        }
    }

    private void readCPU() {
        for (String line : input) {
            nbCycle++;
            System.out.println(nbCycle-1 + " / " + x);
            x += toIncrement;
            saveValue(nbCycle);
            checkSprite();
            toIncrement = 0;
            if (line.contains("addx")) {
                toIncrement = Integer.parseInt(line.split(" ")[1]);
                nbCycle++;
                saveValue(nbCycle);
                checkSprite();
            }
        }
    }

    private void checkSprite() {
        if ((nbCycle - 1) % 40 <= x + 1 && (nbCycle - 1) % 40 >= x - 1) {
            crtScreen.add("#");

        } else {
            crtScreen.add(".");
        }
    }

    private void saveValue(int cycle) {
        switch (cycle) {
            case 20 -> this.result += 20 * x;
            case 60 -> this.result += 60 * x;
            case 100 -> this.result += 100 * x;
            case 140 -> this.result += 140 * x;
            case 180 -> this.result += 180 * x;
            case 220 -> this.result += 220 * x;
        }
    }
}
