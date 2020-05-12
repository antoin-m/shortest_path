package ninja.michelantoine.shortestpath;

import java.util.Arrays;

public class DoubleArrayLayout implements Layout {
    private final Space[][] inner;

    public DoubleArrayLayout(String representation) {
        inner = Arrays.stream(representation.split("\n"))
                .map(line -> Arrays.stream(line.split("\\|")).map(c -> {
                    if ("o".equals(c)) {
                        return Space.EMPTY;
                    } else if ("x".equals(c)) {
                        return Space.WALL;
                    }

                    throw new IllegalArgumentException("Unknown type: " + c);
                }).toArray(Space[]::new))
                .toArray(Space[][]::new);
    }

    @Override
    public Space at(int x, int y) {
        return inner[y][x];
    }

    @Override
    public void setAt(int x, int y, Space type) {
        inner[y][x] = type;
    }

    @Override
    public int getWidth() {
        return inner[0].length;
    }

    @Override
    public int getHeight() {
        return inner.length;
    }
}
