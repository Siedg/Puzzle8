public class AStarHeuristic implements Heuristic {
    private float heuristicValue = 0f;

    public void heuristicValue(State current, Puzzle goalState, String h) {
        Puzzle currentState = current.getPuzzle();
        int[] currentPos = new int[2];
        int[] goalPos = new int[2];
        int d;
        int totalD = 0;

        for (int i = 0 ; i < 9 ; i++) {
            currentPos = currentState.getPositionTab(i);
            goalPos = goalState.getPositionTab(i);

            d = (Math.abs(currentPos[0] - goalPos[0]) + Math.abs(currentPos[1] - goalPos[1]));
            totalD += d;
        }

        if (h.equals("Manhattan") || h.equals("manhattan") || h.equals("m") || h.equals("M")) {
            for (int i = 0 ; i < 9 ; i++) {
                currentPos = currentState.getPositionTab(i);
                goalPos = goalState.getPositionTab(i);

                d = (Math.abs(currentPos[0] - goalPos[0]) + Math.abs(currentPos[1] - goalPos[1]));
                totalD += d;
            }
        } else if (h.equals("poop") || h.equals("POOP") || h.equals("P") || h.equals("p")) {
            for (int i = 0 ; i < 9 ; i++) {
                currentPos = currentState.getPositionTab(i);
                goalPos = goalState.getPositionTab(i);

                if (currentPos != goalPos) {
                    totalD++;
                }
            }
        }

        int fCost = 0;
        State parent = current;
        while (parent != null) {
            parent = parent.getParent();
            fCost++;
        }

        heuristicValue = totalD + fCost;
    }

    public float getHeuristicValue() {
        return heuristicValue;
    }

}
