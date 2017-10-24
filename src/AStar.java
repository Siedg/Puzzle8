
import java.util.ArrayList;
import java.util.LinkedList;

public class AStar implements Search {
    private ArrayList<State> gray = new ArrayList<State>();
    private LinkedList<State> white = new LinkedList<State>();
    private ArrayList<Puzzle> black = new ArrayList<Puzzle>();
    private long runTime = 0;
    private long startTime, endTime;

    public ArrayList<Puzzle> search(Puzzle startState, Puzzle goalState, String h) {
        ArrayList<State> child = new ArrayList<>();
        State currentState = null;

        boolean done = false;
        boolean visited = false;
        int nodeCounter = 0;

        white.offer(new State(startState, new AStarHeuristic()));

        startTime = System.nanoTime();

        System.out.println("Caminhos Possíveis");

        while(!white.isEmpty() && !done) {
            currentState = white.poll();
            nodeCounter++;

            System.out.println("Estado: " + nodeCounter);
            currentState.getPuzzle().printPuzzle();

            if(currentState.getPuzzle().isEqual(goalState)) {
                done = true;
                break;
            }

            try {
                child = currentState.createChild();
            } catch (Exception e) {
                e.printStackTrace();
            }

            for (int i = 0 ; i < child.size() ; i++) {
                State newState = child.get(i);
                visited = false;

                for (State s : gray) {
                    if (newState.equalTo(s)) {
                        System.out.println("Already visited");
                        visited = true;
                        break;
                    }
                }

                for (State s : white) {
                    if (newState.equalTo(s)) {
                        System.out.println("Not visited");
                        visited = true;
                        break;
                    }
                }

                if (!visited) {
                    boolean insert = false;

                    newState.searchHeuristic(goalState, h);

                    for (int j = 0 ; j < white.size() ; j++) {
                        if (newState.getValorHeuristica() < white.get(j).getValorHeuristica()) {
                            white.add(j, newState);
                            insert = true;
                            break;
                        }
                    }

                    if(!insert) {
                        white.offer(newState);
                    }

                    System.out.println("Cost: " + newState.getValorHeuristica());
                    newState.getPuzzle().printPuzzle();
                }
            }
            gray.add(currentState);
            white.remove(currentState);
        }
        endTime = System.nanoTime();
        runTime = (endTime - startTime) / 1000000;

        if (done) {
            boolean pathFound = false;

            black.add(currentState.getPuzzle());
            while (!pathFound) {
                currentState = currentState.getParent();
                black.add(0, currentState.getPuzzle());

                if (currentState.getPuzzle().isEqual(startState)) {
                    pathFound = true;
                }
            }
        } else {
            return null;
        }
        return black;
    }

    public void printData() {
        System.out.println("=========================================");
        System.out.println("TIMESET");
        System.out.println("Time: " + runTime + " ms");
        System.out.println("Total States: " + gray.size());
        System.out.println("Solution Length: " + black.size());
        System.out.println("=========================================");
    }
}
