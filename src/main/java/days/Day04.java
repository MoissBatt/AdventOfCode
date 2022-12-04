package days;

import java.util.ArrayList;

public class Day04 extends Day {
    public static class Assignment {
        protected int start1;
        protected int end1;
        protected int start2;
        protected int end2;

        public Assignment(int start1, int end1, int start2, int end2) {
            this.start1 = start1;
            this.end1 = end1;
            this.start2 = start2;
            this.end2 = end2;
        }

        @Override
        public String toString() {
            return start1 + " " + end1 + " " + start2 + " " + end2;
        }
    }

    private final ArrayList<Assignment> assignments;
    private int fullOverlaps;
    private int overlaps;

    public Day04() {
        super(4, "input_4.txt");
        assignments = new ArrayList<>();
        fullOverlaps = 0;
        overlaps = 0;
    }

    public void go() {
        populateAssignments();
        checkOverlaps();
        System.out.println("Number of pairs fully overlapping : " + fullOverlaps);
        System.out.println("Number of pairs overlapping : " + overlaps);
    }

    private void checkOverlaps() {
        for (Assignment assign : assignments) {
            if ((assign.start1 <= assign.start2 && assign.end1 >= assign.end2) || (assign.start2 <= assign.start1 && assign.end2 >= assign.end1))
                fullOverlaps++;
            else if ((assign.end1 <= assign.end2 && assign.end1 >= assign.start2) || (assign.start1 <= assign.end2 && assign.start1 >= assign.start2))
                overlaps++;
        }
        overlaps += fullOverlaps;
    }

    private void populateAssignments() {
        for (String line : input) {
            String[] splitLine = line.split("[-,]");
            Assignment assignment = new Assignment(Integer.parseInt(splitLine[0]), Integer.parseInt(splitLine[1]), Integer.parseInt(splitLine[2]), Integer.parseInt(splitLine[3]));
            assignments.add(assignment);
        }
    }
}
