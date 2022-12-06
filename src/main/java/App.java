import days.Day;
import days.Day01;
import days.Day02;
import days.Day03;
import days.Day04;
import days.Day05;
import days.Day06;

public class App {

    public static void main(String[] args) {
        System.out.println("\n>>>>>>>>>>>>>> ADVENT OF CODE <<<<<<<<<<<<<<\n");

        Day day = new Day06();
        System.out.println(">>>>> ADVENT OF CODE -- DAY " + day.DATE + " -- START <<<<<\n");
        day.go();
        System.out.println("\n>>>>> ADVENT OF CODE --  DAY " + day.DATE + " --  END <<<<<");
    }
}
