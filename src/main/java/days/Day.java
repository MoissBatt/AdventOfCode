package days;

import utils.FileReader;

import java.util.ArrayList;

public class Day {
    public int DATE = 1;
    protected ArrayList<String> input;

    public Day(int date, String fileName) {
        FileReader fileReader = new FileReader();
        this.input = fileReader.fileReader(fileName);
        this.DATE = date;
    }

    public void go() {
    }
}
