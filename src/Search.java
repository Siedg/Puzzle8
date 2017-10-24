import java.util.ArrayList;

public interface Search {
    public ArrayList<Puzzle> search(Puzzle startState, Puzzle goalState, String h);
    public void printData();
}
