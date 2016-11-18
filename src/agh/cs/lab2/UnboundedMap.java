package agh.cs.lab2;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by yurii on 11/10/16.
 */
public class UnboundedMap extends AbstractWordMap {
    private List<IMapElement> elementList;
    private List<Car> carList;

    // constructor
    public UnboundedMap(List<IMapElement> stacks) {
        this.elementList = stacks;
        this.carList = new LinkedList<>();
    }

    @Override
    public boolean canMoveTo (Position position) {
        return (!isOccupied(position));
    } // true if not occupied and in the map

    @Override
    public boolean add(Car car) {
        if(canMoveTo(car.getPosition())) {
            this.elementList.add(car);
            this.carList.add(car);
            return true;
        }
        return false;
    }

    @Override
    public void run(MoveDirection[] directions) {
        for(int i = 0; i < directions.length; i++) {
            this.carList.get(i % this.carList.size()).move(directions[i]);
        }
    }

    @Override
    public boolean isOccupied(Position position) {
        for (int i = 0; i < elementList.size(); i++) {
            if(elementList.get(i).getPosition().equals(position))
                return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Position position) {
        for (int i = 0; i < elementList.size(); i++) {
            if(elementList.get(i).getPosition().equals(position))
                return elementList.get(i);
        }
        return null;
    }

    public String toString() {
        int highestX = 0;
        int lowestX = 0;
        int highestY = 0;
        int lowestY = 0;
        for (int i = 0; i < elementList.size(); i++) {
            Position current = elementList.get(i).getPosition();
            if(current.x > highestX) {
                highestX = current.x;
            } else if (current.x < lowestX){
                lowestX = current.x;
            }
            if(current.y > highestY) {
                highestY = current.y;
            } else if (current.y < lowestY){
                lowestY = current.y;
            }
        }
        Position lowerBound = new Position(lowestX, lowestY);
        Position upperBound = new Position(highestX, highestY);
        return new MapVisualizer().dump(this, lowerBound, upperBound);
    }
}