package agh.cs.lab2;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yurii on 11/17/16.
 */
public abstract class AbstractWordMap implements IWorldMap, IPositionChangeObserver{
    Map<Position,Car> cars = new LinkedHashMap<>();
    List<Car> carList;

    @Override
    public void run(MoveDirection[] directions) {
        // get collection of cars values, put it in arraylist, and move every element of that array
        carList = new ArrayList<>(cars.values());
        for(int i = 0; i < directions.length; i++) {
            Car currentCar = carList.get(i % carList.size());
            currentCar.move(directions[i]);
        }
    }

    @Override
    public boolean add(Car car) {
        if(canMoveTo(car.getPosition())) {
            this.cars.put(car.getPosition(), car);
            car.addListener(this);
            return true;
        }
        throw new IllegalArgumentException(car.getPosition().toString() + " is already occupied");
    }
}