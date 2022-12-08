package days;

public class Day08 extends Day {

    private int[][] forest;
    private int visibleTrees;
    private int sizeForestX;
    private int sizeForestY;
    private int maxScoring;

    public Day08() {
        super(8, "input_8.txt");
        visibleTrees = 0;
        sizeForestX = 0;
        sizeForestY = 0;
        maxScoring = 0;
    }

    public void go() {
        createForest();
        countVisibleTrees();
        System.out.println("Nombre d'arbres visibles : " + visibleTrees);
        calculateMaxTreeScore();
        System.out.println("Score maximum : " + maxScoring);
    }

    private void calculateMaxTreeScore() {
        for (int i = 1; i < sizeForestY - 1; i++) {
            for (int j = 1; j < sizeForestX - 1; j++) {
                int actualScore = calculateTreeScore(i, j);
                if (actualScore > maxScoring)
                    maxScoring = actualScore;
            }
        }
    }

    private int calculateTreeScore(int i, int j) {
        int left = 0, right = 0, up = 0, down = 0;
        boolean stop = false;
        int x = i - 1;
        while (x >= 0 && !stop) {
            up++;
            if (forest[x][j] >= forest[i][j])
                stop = true;
            x--;
        }

        stop = false;
        x = i + 1;
        while (x < sizeForestY && !stop) {
            down++;
            if (forest[x][j] >= forest[i][j])
                stop = true;
            x++;
        }

        stop = false;
        x = j + 1;
        while (x < sizeForestX && !stop) {
            right++;
            if (forest[i][x] >= forest[i][j])
                stop = true;
            x++;
        }

        stop = false;
        x = j - 1;
        while (x >= 0 && !stop) {
            left++;
            if (forest[i][x] >= forest[i][j])
                stop = true;
            x--;
        }

        return left * right * up * down;
    }

    private void countVisibleTrees() {
        visibleTrees = sizeForestX * 2 + sizeForestY * 2 - 4;
        for (int i = 1; i < sizeForestY - 1; i++) {
            for (int j = 1; j < sizeForestX - 1; j++) {
                if (checkIfVisible(0, j, -1, i, forest[i][j]) ||
                        checkIfVisible(j + 1, sizeForestY, -1, i, forest[i][j]) ||
                        checkIfVisible(0, i, j, -1, forest[i][j]) ||
                        checkIfVisible(i + 1, sizeForestX, j, -1, forest[i][j]))
                    visibleTrees += 1;
            }
        }
    }

    private boolean checkIfVisible(int start, int end, int column, int row, int tree) {
        if (row != -1) {
            for (int x = start; x < end; x++) {
                if (forest[row][x] >= tree)
                    return false;
            }
            return true;
        }
        for (int x = start; x < end; x++) {
            if (forest[x][column] >= tree)
                return false;
        }
        return true;

    }

    private void createForest() {
        sizeForestX = input.get(0).length();
        sizeForestY = input.size();

        forest = new int[input.size()][input.get(0).length()];
        for (int i = 0; i < sizeForestY; i++) {
            String[] line = input.get(i).split("");
            for (int j = 0; j < sizeForestX; j++) {
                forest[i][j] = Integer.parseInt(line[j]);
            }
        }
    }
}
