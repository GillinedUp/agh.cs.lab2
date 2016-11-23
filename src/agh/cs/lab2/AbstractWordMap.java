package agh.cs.lab2;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by yurii on 11/17/16.
 */
public abstract class AbstractWordMap implements IWorldMap{
    Map<Position,Car> cars = new LinkedHashMap<>();

    @Override
    public void run(MoveDirection[] directions) {
        for(int i = 0; i < directions.length; i++) {
            // get collection of cars values, get Car object at specific position from that collection, put it in arraylist, and move it
            (new ArrayList<>(cars.values())).get(i % this.cars.size()).move(directions[i]);

        }
    }
}