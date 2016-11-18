package agh.cs.lab2;

/**
 * Created by yurii on 10/21/16.
 */
public class Position {

    public final int x;
    public final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }

    public boolean smaller(Position other) {
        return (this.x <= other.x && this.y <= other.y);
    } // true if current this position <= other position

    public boolean larger(Position other) {
        return (this.x >= other.x && this.y >= other.y);
    } // true if current this position >= other position

    public Position add(Position other){
        Position p1 = new Position(this.x + other.x, this.y + other.y);
        return p1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        if (x != position.x) return false;
        return y == position.y;

    }

}