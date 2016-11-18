package agh.cs.lab2;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by yurii on 11/4/16.
 */
public class RectangularMap extends AbstractWordMap {
    private Position UpperBound;
    private Position LowerBound;
    List<Car> carList;

    // constructor
    public RectangularMap(int width, int height){
        this.UpperBound = new Position(width, height);
        this.LowerBound = new Position(0, 0);
        this.carList = new LinkedList<>();
    }

    @Override
    public boolean add(Car car) {
        if(canMoveTo(car.getPosition())) {
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
    public boolean canMoveTo (Position position) {
        return (!isOccupied(position) && position.smaller(this.UpperBound) && position.larger(this.LowerBound));
    } // true if not occupied and in the map

    @Override
    public boolean isOccupied(Position position) {
        for (int i = 0; i < carList.size(); i++) {
            if(carList.get(i).getPosition().equals(position))
                return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Position position) {
        for (int i = 0; i < carList.size(); i++) {
            if(carList.get(i).getPosition().equals(position))
                return carList.get(i);
        }
        return null;
    }

    @Override
    public String toString() {
        return new MapVisualizer().dump(this, this.LowerBound, this.UpperBound);
    }
}
