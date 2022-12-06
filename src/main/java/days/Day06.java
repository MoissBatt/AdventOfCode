package days;

import java.util.ArrayList;
import java.util.Collections;

public class Day06 extends Day {
    private ArrayList<Character> marker;
    private ArrayList<Character> markerMessage;

    public Day06() {
        super(6, "input_6.txt");
        this.marker = new ArrayList<>();
        this.markerMessage = new ArrayList<>();
    }

    public void go() {
        System.out.println("Le premier marqueur arrive en position : " + searchMarker(4));
        System.out.println("Le premier marqueur message arrive en position : " + searchMarker(14));
    }

    private int searchMarker(int markerSize) {
        for (int i = 0; i < input.get(0).length(); i++) {
            Character toCheck = input.get(0).charAt(i);
            if (marker.size() < markerSize) {
                marker.add(toCheck);
            } else {
                if (allDifferent()) {
                    return i;
                } else {
                    marker.add(toCheck);
                    marker.remove(0);
                }
            }
        }
        return -1;
    }

    private boolean allDifferent() {
        for (Character toCheck : marker) {
            if (Collections.frequency(marker, toCheck) > 1) {
                return false;
            }
        }
        return true;
    }
}
