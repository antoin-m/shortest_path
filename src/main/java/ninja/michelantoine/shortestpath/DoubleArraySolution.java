package ninja.michelantoine.shortestpath;

import java.util.Arrays;

public class DoubleArraySolution implements Solution {
    private final int[][] inner;

    public DoubleArraySolution(int width, int height) {
        inner = new int[height][width];

        for (int[] ints : inner) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }
    }

    @Override
    public int at(int x, int y) {
        return inner[y][x];
    }

    @Override
    public void setAt(int x, int y, int hops) {
        inner[y][x] = hops;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int[] row : inner) {
            for (int room : row) {
                sb.append(room);
                sb.append("|");
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
