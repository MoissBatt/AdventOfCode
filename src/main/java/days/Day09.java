package days;

import java.util.HashSet;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Day09 extends Day {
    public class Knot {
        public String name;
        public int column;
        public int line;
        public Knot tail;
        public HashSet<String> positions;
        public boolean isLast;


        public Knot(String name, int line, int col) {
            this.name = name;
            this.column = col;
            this.line = line;
            positions = new HashSet<>();
            positions.add("0/0");
            isLast = true;
        }

        public Knot(String name, int line, int col, Knot tail) {
            this.name = name;
            this.column = col;
            this.line = line;
            this.tail = tail;
            positions = new HashSet<>();
            positions.add("0/0");
            isLast = false;
        }
    }

    public Knot head1, head2;

    public Day09() {
        super(9, "input_9.txt");
        head1 = new Knot("HEAD", 0, 0, new Knot("1", 0, 0));

        head2 = new Knot("HEAD", 0, 0,
                new Knot("1", 0, 0,
                        new Knot("2", 0, 0,
                                new Knot("3", 0, 0,
                                        new Knot("4", 0, 0,
                                                new Knot("5", 0, 0,
                                                        new Knot("6", 0, 0,
                                                                new Knot("7", 0, 0,
                                                                        new Knot("8", 0, 0,
                                                                                new Knot("9", 0, 0))))))))));
    }

    public void go() {
        moveRope(head1);
        System.out.println("Le nombre de noeuds marqués est de : " + head1.tail.positions.size());
        moveRope(head2);
        System.out.println("Le nombre de noeuds marqués est de : " + head2.tail.tail.tail.tail.tail.tail.tail.tail.tail.positions.size());
    }

    private void moveRope(Knot head) {
        for (String line : input) {
            for (int i = 0; i < Integer.parseInt(line.split(" ")[1]); i++)
                moveHead(head, line.split(" ")[0]);
        }
    }

    private void moveHead(Knot head, String move) {
        if (move.contains("U")) {
            head.line++;
        } else if (move.contains("D")) {
            head.line--;
        } else if (move.contains("R")) {
            head.column++;
        } else { // L
            head.column--;
        }
        Knot h = head;
        Knot t = h.tail;
        while (!h.isLast) {
            moveTail(h, t);
            h = t;
            t = t.tail;
        }
    }

    private void moveTail(Knot head, Knot tail) {
        if (shouldMove(head, tail)) {
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
            if (tail.isLast)
                tail.positions.add(tail.line + "/" + tail.column);
        }
    }

    private boolean shouldMove(Knot head, Knot tail) {
        if (distance(head, tail) < 1.5) {
            return false;
        }
        return true;
    }

    private double distance(Knot head, Knot tail) {
        return sqrt(pow(head.line - tail.line, 2) + pow(head.column - tail.column, 2));
    }
}
