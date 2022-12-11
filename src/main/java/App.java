import days.*;

public class App {

    public static void main(String[] args) {
        System.out.println("\n>>>>>>>>>>>>>> ADVENT OF CODE <<<<<<<<<<<<<<\n");

        Day day = new Day11();
        System.out.println(">>>>> ADVENT OF CODE -- DAY " + day.DATE + " -- START <<<<<\n");
        day.go();
        System.out.println("\n>>>>> ADVENT OF CODE --  DAY " + day.DATE + " --  END <<<<<");
    }
}
