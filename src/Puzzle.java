public class Puzzle {
    private int[][] puzzle = new int[3][3];
    public int zeroPosX, zeroPosY;

    public Puzzle (int[][] initialState) {
        for (int i = 0 ; i < 3 ; i++) {
            for (int j = 0 ; j < 3 ; j++) {
                puzzle[i][j] = initialState[i][j];
            }
        }
    }
    public boolean movePuzzle(int x, int y) {
        int[] pos = getPositionTab(0);
        zeroPosX = pos[0];
        zeroPosY = pos[1];

        if (x != 0) {
            if (x > 0 && zeroPosX < 2) {
                puzzle[zeroPosX][zeroPosY] = puzzle[zeroPosX + 1][zeroPosY];
                puzzle[zeroPosX + 1][zeroPosY] = 0;
                zeroPosX++;
                return true;
            } else if (x < 0 && zeroPosX > 0) {
                puzzle[zeroPosX][zeroPosY] = puzzle[zeroPosX - 1][zeroPosY];
                puzzle[zeroPosX - 1][zeroPosY] = 0;
                zeroPosX--;
                return true;
            }
        } else if (y != 0) {
            if (y > 0 && zeroPosY < 2) {
                puzzle[zeroPosX][zeroPosY] = puzzle[zeroPosX][zeroPosY + 1];
                puzzle[zeroPosX][zeroPosY + 1] = 0;
                zeroPosY++;
                return true;
            } else if (y < 0 && zeroPosY > 0) {
                puzzle[zeroPosX][zeroPosY] = puzzle[zeroPosX][zeroPosY - 1];
                puzzle[zeroPosX][zeroPosY - 1] = 0;
                zeroPosY--;
                return true;
            }
        }
        return false;
    }

    public void printPuzzle() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(puzzle[i][j] + " ");
                //System.out.println(" ");
            }
            System.out.println("");
        }
        System.out.print("");
    }

    public int[] getPositionTab(int tile) {
        int[] pos = new int[2];

        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                if (puzzle[x][y] == tile) {
                    pos[0] = x;
                    pos[1] = y;
                }
            }
        }
        return pos;
    }

    public boolean isEqual(Puzzle p) {
        for (int y = 0; y < 3 ; y++) {
            for (int x = 0; x < 3 ; x++) {
                if (puzzle[x][y] != p.getPuzzle()[x][y]) {
                    return false;
                }
            }
        }
        return true;
    }

    public int[][] getPuzzle() {
        return puzzle;
    }
}
