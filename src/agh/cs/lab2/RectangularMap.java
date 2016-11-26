package agh.cs.lab2;

/**
 * Created by yurii on 11/4/16.
 */
public class RectangularMap extends AbstractWordMap {
    private Position UpperBound;
    private Position LowerBound;

    // constructor
    public RectangularMap(int width, int height){
        this.UpperBound = new Position(width, height);
        this.LowerBound = new Position(0, 0);
    }

    // update car position on the map
    @Override
    public void positionChanged(Position oldPosition, Position newPosition){
        Car currentCar = cars.remove(oldPosition);
        cars.put(newPosition, currentCar);
    }

    @Override
    public boolean canMoveTo (Position position) {
        return (!isOccupied(position) && position.smaller(this.UpperBound) && position.larger(this.LowerBound));
    } // true if not occupied and in the map

    @Override
    public boolean isOccupied(Position position) {
        if(cars.get(position) != null) {
            return true;
        } else return false;
    }

    @Override
    public Object objectAt(Position position) {
        if(cars.get(position) != null) {
            return cars.get(position);
        } else return false;
    }

    @Override
    public String toString() {
        return new MapVisualizer().dump(this, this.LowerBound, this.UpperBound);
    }
}
