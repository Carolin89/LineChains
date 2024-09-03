package com.geomagic.linechain;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class LineChainTest {

    @Test
    void testAddLine() {
        LineChain chain = new LineChain();
        Line line = new Line(0, 0, 3, 4);
        chain.addLine(line);
        assertEquals(1, chain.getLines().size(), "The chain should have 1 line");
        assertEquals(5.0, chain.getTotalLength(), 0.0001, "The total length should be 5.0");
    }

    @Test
    void testGetTotalLength() {
        LineChain chain = new LineChain();
        chain.addLine(new Line(0, 0, 3, 4));
        chain.addLine(new Line(3, 4, 6, 8));
        assertEquals(10.0, chain.getTotalLength(), 0.0001, "The total length should be 10.0");
    }
}
