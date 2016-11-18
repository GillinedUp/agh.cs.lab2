package agh.cs.lab2;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by yurii on 10/23/16.
 */
public class MapDirectionTest {
    @Test
    public void testNext() {
        assertEquals(MapDirection.South, MapDirection.East.next());
    }
}