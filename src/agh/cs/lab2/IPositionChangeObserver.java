package agh.cs.lab2;

/**
 * Created by yurii on 11/25/16.
 */
public interface IPositionChangeObserver {
    void positionChanged(Position oldPosition, Position newPosition);
}
