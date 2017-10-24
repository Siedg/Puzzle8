public interface Heuristic {
    public void heuristicValue(State current, Puzzle goalState, String h);
    public float getHeuristicValue();
}
