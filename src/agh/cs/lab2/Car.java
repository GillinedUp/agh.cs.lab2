package agh.cs.lab2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yurii on 10/28/16.
 */
public class Car implements IMapElement, IPositionChangeObserver{
    private MapDirection direction;
    private Position position;
    private IWorldMap map;
    private List<IPositionChangeObserver> observers;

    //constructor
    public Car(IWorldMap map, int x, int y) {
        this.map = map;
        this.position = new Position(x, y);
        this.direction = MapDirection.North;
        this.observers = new ArrayList<>();
    }

    //constructor
    public Car(IWorldMap map) {
        this(map, 0, 0);
    }

    //observer service methods
    public void addListener(IPositionChangeObserver observer){
        observers.add(observer);
    }

    public void removeListener(IPositionChangeObserver observer){
        observers.remove(observer);
    }

    public void positionChanged(Position oldPosition, Position newPosition){
        for (IPositionChangeObserver observer: observers) {
            observer.positionChanged(oldPosition, newPosition);
        }
    }

    //geters
    public Position getPosition() {
        return this.position;
    }

    public void moveOptions(MoveDirection[] directions) {
        for (MoveDirection dir : directions) {
            this.move(dir);
        }
    }

    // move methods
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
        if(map.canMoveTo(newPosition)) {
            this.positionChanged(this.position, newPosition);
            this.position = newPosition;
        }
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
}