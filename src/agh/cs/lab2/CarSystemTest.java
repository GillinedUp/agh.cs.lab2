package agh.cs.lab2;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by yurii on 11/3/16.
 */
public class CarSystemTest {

    @Test
    public void testCarRectangularMap(){
        IWorldMap map = new RectangularMap(4, 4);
        Car car1 = new Car(map);
        map.add(car1);
        Position oldPosition = car1.getPosition();
        map.run(new OptionsParser().parse(new String[]{"right", "f", "forward", "f", "l", "f", "left", "f", "forward", "f", "r", "b"}));
        assertEquals(oldPosition, car1.getPosition());
    }

    @Test
    public void testCarUnboundedMap(){
        List<IMapElement> elementList = new LinkedList<>();
        IWorldMap map = new UnboundedMap(elementList);
        Car car1 = new Car(map);
        map.add(car1);
        Position oldPosition = car1.getPosition();
        map.run(new OptionsParser().parse(new String[]{"right", "f", "forward", "f", "l", "f", "left", "f", "forward", "f", "r", "b"}));
        assertEquals(oldPosition, car1.getPosition());
    }
}