package com.zuhlke.model;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class CoordinateTest {

    private Coordinate start;
    private Coordinate end;

    @Before
    public void setUp() {
        start = new Coordinate(2, 3);
        end = new Coordinate(5, 12);
    }

    @Test
    public void ExpectGetDistanceOf3and9() {
        Coordinate answer = new Coordinate(5 - 2, 12 - 3);
        assertEquals(answer.getX(), end.getDistance(start).getX());
        assertEquals(answer.getY(), end.getDistance(start).getY());
    }

    @Test
    public void ExpectStartLinearDistance5() {
        int ans = start.getX() + start.getY();
        assertEquals(ans, start.linearDistance());
    }

    @Test
    public void ExpectLinearDistance10() {
        Coordinate point = new Coordinate(3, 7);
        assertEquals(10, point.linearDistance());
    }

    @Test
    public void ExpectTestEqualsStart() {
        Coordinate test = new Coordinate(2, 3);
        assertTrue(test.equals(start));
    }

    @Test
    public void ExpectPrintOutOfCoordinates() {

        String ans = "X-Coordinate: 2, Y-Coordinate: 3" + System.getProperty("line.separator");

        //redirect output
        OutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        System.setOut(ps);

        start.print();

        assertEquals(ans, os.toString());

    }

    @Test
    public void addOneToX() {
        Coordinate test = new Coordinate(3,4);

        assertEquals(4, test.addX(1));
        assertEquals(3, test.addX(-1));

    }

    @Test
    public void addOneToY() {
        Coordinate test = new Coordinate(3,4);
        assertEquals(5, test.addY(1));
        assertEquals(4, test.addY(-1));
    }
}