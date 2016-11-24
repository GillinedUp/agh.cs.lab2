package agh.cs.lab2;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yurii on 11/17/16.
 */
public abstract class AbstractWordMap implements IWorldMap{
    Map<Position,Car> cars = new LinkedHashMap<>();

    @Override
    public void run(MoveDirection[] directions) {
        // get collection of cars values, put it in arraylist, and move every element of that array
        List<Car> carList = new ArrayList<>(cars.values());
        for(int i = 0; i < directions.length; i++) {
            Car currentCar = carList.get(i % carList.size());
            Position oldPosition = currentCar.getPosition();
            currentCar.move(directions[i]);
            if(!currentCar.getPosition().equals(oldPosition)) {
                updateMap(oldPosition, currentCar);
            }
        }
    }
}