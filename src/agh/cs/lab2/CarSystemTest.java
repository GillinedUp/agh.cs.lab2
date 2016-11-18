package agh.cs.lab2;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * Created by yurii on 11/3/16.
 */
public class CarSystemTest {

    @Test
    public void testCar(){
        IWorldMap map = new RectangularMap(4, 4);
        Car ourCar1 = new Car(map);
        Car ourCar2 = new Car(map);
        String[] sampleString = new String[]{"right", "f", "forward", "f", "l", "f", "left", "f", "f", "r", "b"};
        ourCar2.moveOptions(new OptionsParser().parse(sampleString));
        assertEquals(ourCar1.toString(), ourCar2.toString());
    }

}