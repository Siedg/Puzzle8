import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[][] start = {{2, 3, 1}, {0, 5, 6}, {4, 7, 8}};
        //int[][] start = {{1, 6, 3}, {0, 5, 2}, {7, 4, 8}};
        //int[][] start = {{2, 3, 1}, {0, 5, 6}, {4, 7, 8}};
        //int[][] start = {{0, 8, 2}, {7, 4, 1}, {3, 5, 6}};
        //int[][] start = {{3, 2, 4}, {0, 1, 8}, {5, 6, 7}};
        //int[][] start = {{3, 0, 7}, {2, 6, 1}, {5, 4, 8}};
        //int[][] start = {{2, 5, 1}, {6, 3, 8}, {4, 7, 0}};
        //int[][] start = {{2, 3, 1}, {0, 5, 6}, {4, 7, 8}};
        int[][] goal = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        Puzzle startState = new Puzzle(start);
        Puzzle goalState = new Puzzle(goal);

        Scanner input = new Scanner(System.in);
        int op = 0;
        while (op != 3) {
            System.out.println("1 - Manhattan Distance");
            System.out.println("2 - Pieces out of Place");
            System.out.println("3 - Exit");

            op = input.nextInt();

            AStar a = new AStar();
            ArrayList<Puzzle> result = new ArrayList<Puzzle>();

            if (op == 1) {
                result = a.search(startState, goalState, "Manhattan");
                if (result != null) {
                    System.out.println("Finished\n");
                    a.printData();
                    /*
                    for (int i = 0 ; i < result.size() ; i++) {
                        result.get(i).printPuzzle();
                    }
                    */
                } else {
                    System.out.println("No solution found");
                }
            } else if (op == 2) {
                result = a.search(startState, goalState, "poop");
                if (result != null) {
                    System.out.println("Finished\n");
                    a.printData();
                    /*
                    for (int i = 0 ; i < result.size() ; i++) {
                        result.get(i).printPuzzle();
                    }
                    */
                } else {
                    System.out.println("No solution found");
                }
            } else if (op == 3) {
                System.exit(0);
            }
        }
    }
}
