package agh.cs.lab2;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by yurii on 11/17/16.
 */
public abstract class AbstractWordMap implements IWorldMap{
    protected List<Car> carList = new LinkedList<>();

    @Override
    public void run(MoveDirection[] directions) {
        for(int i = 0; i < directions.length; i++) {
            this.carList.get(i % this.carList.size()).move(directions[i]);
        }
    }
}