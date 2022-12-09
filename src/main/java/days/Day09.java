package days;

import java.util.HashSet;

public class Day09 extends Day {
    public class Knot {
        public int column;
        public int line;

        public Knot(int line, int col) {
            this.column = col;
            this.line = line;
        }
    }

    public Knot head;
    public Knot tail;
    public HashSet<String> positions;

    public Day09() {
        super(9, "input_9.txt");
        positions = new HashSet<>();
        head = new Knot(0, 0);
        tail = new Knot(0, 0);
    }

    public void go() {
        moveRope();
        System.out.println("Le nombre de noeuds marqués est de : " + positions.size());
    }

    private void moveRope() {
        for (String line : input) {
            for (int i = 0; i < Integer.parseInt(line.split(" ")[1]); i++)
                moveHead(line.split(" ")[0], line);
        }
    }

    private void moveHead(String move, String line) {
        if (move.contains("U")) {
            head.line++;
        } else if (move.contains("D")) {
            head.line--;
        } else if (move.contains("R")) {
            head.column++;
        } else { // L
            head.column--;
        }
        moveTail();

        System.out.println(line);
        System.out.println("Head: " + head.line + " / " + head.column);
        System.out.println("Tail: "+tail.line + " / " + tail.column);
    }

    private void moveTail() {
        if (shouldMove()) {
            if ((tail.column == head.column && tail.line == head.line - 2)) {
                tail.line++;
            }
            if ((tail.column == head.column && tail.line == head.line + 2)) {
                tail.line--;
            }
            if ((tail.column == head.column - 2 && tail.line == head.line)) {
                tail.column++;
            }
            if ((tail.column == head.column + 2 && tail.line == head.line)) {
                tail.column--;
            }
            if ((tail.column > head.column && tail.line > head.line)) {
                tail.line--;
                tail.column--;
            }
            if ((tail.column < head.column && tail.line > head.line)) {
                tail.line--;
                tail.column++;
            }
            if ((tail.column > head.column && tail.line < head.line)) {
                tail.line++;
                tail.column--;
            }
            if ((tail.column < head.column && tail.line < head.line)) {
                tail.line++;
                tail.column++;
            }
            positions.add(tail.line + "" + tail.column);
        }
    }

    private boolean shouldMove() {
        if ((head.column == tail.column && head.line == tail.line) ||
                (head.column == tail.column && ((head.line == tail.line + 1) || (head.line == tail.line - 1))) ||
                (head.line == tail.line && ((head.column == tail.column + 1) || (head.column == tail.column - 1))) ||
                (head.column == tail.column + 1 && ((head.line == tail.line + 1) || (head.line == tail.line - 1))) ||
                (head.column == tail.column - 1 && ((head.line == tail.line + 1) || (head.line == tail.line - 1)))) {
            return false;
        }
        return true;
    }

}
