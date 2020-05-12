package ninja.michelantoine.shortestpath;

public interface Solution {
    int at(int x, int y);
    void setAt(int x, int y, int hops);
}
