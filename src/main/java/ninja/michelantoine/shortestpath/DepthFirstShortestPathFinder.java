package ninja.michelantoine.shortestpath;

public class DepthFirstShortestPathFinder implements ShortestPathFinder {

    @Override
    public Solution find(int startX, int startY, Layout layout) {
        Solution solution = new DoubleArraySolution(layout.getWidth(), layout.getHeight());

        findRec(startX, startY, layout, solution, 0);

        return solution;
    }

    private void findRec(int x, int y, Layout layout, Solution solution, int hops) {
        if (Layout.Space.WALL == layout.at(x, y)) {
            solution.setAt(x, y, -1);
            return;
        }
        solution.setAt(x, y, hops);

        if (0 < y && solution.at(x, y - 1) > hops + 1) {
            findRec(x, y - 1, layout, solution, hops + 1);
        }
        if (layout.getHeight() - 1 > y && solution.at(x, y + 1) > hops + 1) {
            findRec(x, y + 1, layout, solution, hops + 1);
        }
        if (0 < x && solution.at(x - 1, y) > hops + 1) {
            findRec(x - 1, y, layout, solution, hops + 1);
        }
        if (layout.getWidth() - 1 > x && solution.at(x + 1, y) > hops + 1) {
            findRec(x + 1, y, layout, solution, hops + 1);
        }
    }
}
