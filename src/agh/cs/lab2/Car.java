package agh.cs.lab2;

/**
 * Created by yurii on 10/28/16.
 */
public class Car implements IMapElement {
    private MapDirection direction;
    private Position position;
    private IWorldMap map;

    public Car(IWorldMap map, int x, int y) {
        this.map = map;
        this.position = new Position(x, y);
        this.direction = MapDirection.North;
    }

    public Car(IWorldMap map) {
        this(map, 0, 0);
    }

    public Position getPosition() {
        return this.position;
    }

    public String toString() {
        switch (this.direction) {
            case North: return "^";
            case South: return "v";
            case East: return ">";
            case West: return "<";
            default: return "^";
        }
    }

    public void moveOptions(MoveDirection[] directions) {
        for (MoveDirection dir : directions) {
            this.move(dir);
        }
    }

    public void move(MoveDirection direction) {
        switch (direction) {
            case Right: this.direction = this.direction.next();
                break;
            case Left: this.direction = this.direction.previous();
                break;
            case Forward: moveHelp(1);
                break;
            case Backward: moveHelp(-1);
                break;
        }
    }

    public void moveHelp(int distance) {
        Position newPosition = this.position;
        switch (this.direction) {
            case North:
                newPosition = newPosition.add(new Position(0, distance));
                break;
            case East:
                newPosition = newPosition.add(new Position(distance, 0));
                break;
            case South:
                newPosition = newPosition.add(new Position(0, -distance));
                break;
            case West:
                newPosition = newPosition.add(new Position(-distance, 0));
                break;
            default: break;
        }
        if(map.canMoveTo(newPosition))
            this.position = newPosition;
    }
}