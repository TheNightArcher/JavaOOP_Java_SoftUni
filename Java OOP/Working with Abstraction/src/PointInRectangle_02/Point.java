package PointInRectangle_02;

public class Point {

    private final int x;
    private final int y;


    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public boolean checkIsGreaterOrEqual(Point p) {
        return x >= p.x && y >= p.y;
    }

    public boolean checkIsLessOrEqual(Point p) {
        return x <= p.x && y <= p.y;
    }
}
