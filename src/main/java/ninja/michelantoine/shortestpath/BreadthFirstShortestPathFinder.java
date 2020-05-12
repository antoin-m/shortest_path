package ninja.michelantoine.shortestpath;

import java.util.ArrayDeque;
import java.util.Queue;

import static ninja.michelantoine.shortestpath.Layout.Space.WALL;

public class BreadthFirstShortestPathFinder implements ShortestPathFinder {
    @Override
    public Solution find(int startX, int startY, Layout layout) {
        Solution solution = new DoubleArraySolution(layout.getWidth(), layout.getHeight());
        Queue<int[]> queue = new ArrayDeque<>();
        int hops = 0;

        queue.add(new int[]{ startX, startY });

        while (!queue.isEmpty()) {
            queue = nextRound(queue, layout, solution, hops);
            hops++;
        }

        return solution;
    }

    private Queue<int[]> nextRound(Queue<int[]> queue, Layout layout, Solution solution, int hops) {
        Queue<int[]> nextRound = new ArrayDeque<>();

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int x = pos[0];
            int y = pos[1];

            solution.setAt(x, y, hops);
            if (0 < y && WALL != layout.at(x, y - 1) && solution.at(x, y - 1) > hops + 1) {
                nextRound.add(new int[] { x, y - 1 });
            }
            if (layout.getHeight() - 1 > y && WALL != layout.at(x, y + 1) && solution.at(x, y + 1) > hops + 1) {
                nextRound.add(new int[] { x, y + 1 });
            }
            if (0 < x && WALL != layout.at(x - 1, y) && solution.at(x - 1, y) > hops + 1) {
                nextRound.add(new int[] { x - 1, y });
            }
            if (layout.getWidth() - 1 > x && WALL != layout.at(x + 1, y) && solution.at(x + 1, y) > hops + 1) {
                nextRound.add(new int[] { x + 1, y });
            }
        }

        return nextRound;
    }
}
