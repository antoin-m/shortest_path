package ninja.michelantoine.shortestpath;

public interface Layout {
    enum Space {
        EMPTY, WALL;
    }

    Space at(int x, int y);
    void setAt(int x, int y, Space type);

    int getWidth();
    int getHeight();
}
