package main.model.utils;

import java.util.Objects;

public class Point {
    private int x;
    private int y;

    public Point(){
        x = 0;
        y = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return getX() == point.getX() &&
                getY() == point.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void setFromPoint(Point p){
        x = p.getX();
        y = p.getY();
    }
    public void setPoint(int x, int y){
        this.x=x;
        this.y=y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
