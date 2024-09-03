package com.geomagic.linechain;

import org.junit.jupiter.api.Test;
import java.awt.*;


import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @Test
    void testLength() {
        Line line = new Line(0, 0, 3, 4);
        assertEquals(5.0, line.length(), 0.0001, "The length should be 5.0");
    }

    @Test
    void testGetStartPoint() {
        Line line = new Line(0, 0, 3, 4);
        Point startPoint = line.getStartPoint();
        assertEquals(new Point(0, 0), startPoint, "The start point should be (0, 0)");
    }

    @Test
    void testGetEndPoint() {
        Line line = new Line(0, 0, 3, 4);
        Point endPoint = line.getEndPoint();
        assertEquals(new Point(3, 4), endPoint, "The end point should be (3, 4)");
    }

    @Test
    void testConnectsTo() {
        Line line1 = new Line(0, 0, 3, 4);
        Line line2 = new Line(3, 4, 6, 8);
        assertTrue(line1.connectsTo(line2), "Lines should be connected");

        Line line3 = new Line(1, 1, 2, 2);
        assertFalse(line1.connectsTo(line3), "Lines should not be connected");
    }
}
