package agh.cs.lab2;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by yurii on 10/21/16.
 */
public class PositionTest {
    @Test
    public void testToString() {
        assertEquals("(1,2)", new Position(1, 2).toString());
        assertEquals("(-1,-2)", new Position(-1, -2).toString());
    }

    @Test
    public void testSmaller() {
        assertTrue(new Position(1, 2).smaller(new Position(3, 4)));
        assertFalse(new Position(3, 4).smaller(new Position(2, 5)));
    }

    @Test
    public void testLarger() {
        assertTrue(new Position(1, 2).larger(new Position(-1, 0)));
        assertFalse(new Position(3, 4).larger(new Position(2, 5)));
    }
}