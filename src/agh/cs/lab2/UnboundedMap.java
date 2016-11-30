package agh.cs.lab2;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yurii on 11/10/16.
 */
public class UnboundedMap extends AbstractWordMap {
    private Map<Position,IMapElement> elements = new LinkedHashMap<>();

    // constructor
    public UnboundedMap(List<IMapElement> stacks) {
        this.addStack(stacks);
    }

    public void addStack(List<IMapElement> stacks) {
        for (int i = 0; i < stacks.size(); i++) {
            if(canMoveTo(stacks.get(i).getPosition())) {
                elements.put(stacks.get(i).getPosition(), stacks.get(i));
            }
            else throw new IllegalArgumentException(stacks.get(i).getPosition().toString() + " is already occupied");
        }
    }

    // update car position on the map
    public void positionChanged(Position oldPosition, Position newPosition){
        Car currentCar = cars.remove(oldPosition);
        elements.remove(oldPosition);
        cars.put(newPosition, currentCar);
        elements.put(newPosition, currentCar);
    }

    @Override
    public boolean add(Car car) {
        if(super.add(car)) {
            this.elements.put(car.getPosition(), car);
            return true;
        }
        throw new IllegalArgumentException(car.getPosition().toString() + " is already occupied");
    }

    @Override
    public boolean canMoveTo (Position position) {
        return (!isOccupied(position));
    } // true if not occupied

    @Override
    public boolean isOccupied(Position position) {
        if(elements.get(position) != null) {
            return true;
        } else return false;
    }

    @Override
    public Object objectAt(Position position) {
        if(elements.get(position) != null) {
            return elements.get(position);
        } else return false;
    }

    @Override
    public String toString() {
        // calculate map boundaries based on objects
        int highestX = 0;
        int lowestX = 0;
        int highestY = 0;
        int lowestY = 0;
        for (Map.Entry me : elements.entrySet()) {
            Position current = (Position) me.getKey();
            if (current.x > highestX) {
                highestX = current.x;
            } else if (current.x < lowestX) {
                lowestX = current.x;
            }
            if (current.y > highestY) {
                highestY = current.y;
            } else if (current.y < lowestY) {
                lowestY = current.y;
            }
        }
        Position lowerBound = new Position(lowestX, lowestY);
        Position upperBound = new Position(highestX, highestY);
        return new MapVisualizer().dump(this, lowerBound, upperBound);
    }
}
