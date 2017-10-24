import java.util.ArrayList;

public class State {
    private Puzzle puzzle;
    private Heuristic h;
    private ArrayList<State> child = new ArrayList<State>();
    private State parent;

    public State(Puzzle puzzle, Heuristic h) {
        this.puzzle = puzzle;
        this.h = h;
    }

    public ArrayList<State> createChild() throws InstantiationException, IllegalAccessException {
        State state;
        Puzzle move;

        move = new Puzzle(puzzle.getPuzzle());
        if (move.movePuzzle(0, -1)) {
            state = new State(move, h.getClass().newInstance());
            state.setParent(this);
            child.add(state);
            //System.out.println("----");
            //move.printPuzzle();
            //System.out.println("----");
        }

        move = new Puzzle(puzzle.getPuzzle());
        if (move.movePuzzle(-1, 0)) {
            state = new State(move, h.getClass().newInstance());
            state.setParent(this);
            child.add(state);
        }

        move = new Puzzle(puzzle.getPuzzle());
        if (move.movePuzzle(1, 0)) {
            state = new State(move, h.getClass().newInstance());
            state.setParent(this);
            child.add(state);
        }

        move = new Puzzle(puzzle.getPuzzle());
        if (move.movePuzzle(0, 1)) {
            state = new State(move, h.getClass().newInstance());
            state.setParent(this);
            child.add(state);
        }

        return child;
    }


    public float getValorHeuristica() {
        return h.getHeuristicValue();
    }

    public void searchHeuristic (Puzzle goalState, String heuristic) {
        h.heuristicValue(this, goalState, heuristic);
    }

    public boolean equalTo(State s) {
        return puzzle.isEqual(s.getPuzzle());
    }

    public ArrayList<State> getChild() {
        return child;
    }

    public void setParent(State parent) {
        this.parent = parent;
    }

    public State getParent() {
        return parent;
    }

    public Puzzle getPuzzle() {
        return puzzle;
    }

    public void setPuzzle(Puzzle p) {
        this.puzzle = p;
    }
}
