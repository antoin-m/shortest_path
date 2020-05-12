package ninja.michelantoine.shortestpath;

public class Main {
    public static void main(String[] args) {
        Layout layout = new DoubleArrayLayout(
                "x|o|o|x|o\n" +
                "o|o|o|o|o\n" +
                "o|x|o|o|o"
        );
        Solution solution = new BreadthFirstShortestPathFinder().find(
                1, 1, layout
        );

        System.out.println(solution);
    }
}
