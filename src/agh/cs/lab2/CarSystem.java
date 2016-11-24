package agh.cs.lab2;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by yurii on 10/21/16.
 */
public class CarSystem {
    public static void main(String[] args) {
        try {
            MoveDirection[] directions = new OptionsParser().parse(args);
            List<IMapElement> elementList = new LinkedList<>();
            elementList.add(new HayStack(new Position(-4, -4)));
            elementList.add(new HayStack(new Position(7, 7)));
            elementList.add(new HayStack(new Position(3, 6)));
            elementList.add(new HayStack(new Position(2, 0)));
            IWorldMap map = new UnboundedMap(elementList);
            map.add(new Car(map));
            map.add(new Car(map, 3, 1));
            System.out.println(map.toString());
            map.run(directions);
            System.out.println(map.toString());
        } catch (IllegalArgumentException ex) {
            System.out.println(ex);
        }
    }
}
