package com.geomagic.linechain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class LineChainBuilderTest {

    @Test
    void testBuildLineChains() {
        List<Line> lines = Arrays.asList(
                new Line(0, 0, 3, 4),
                new Line(3, 4, 6, 8),
                new Line(6, 8, 9, 12),
                new Line(10, 10, 13, 14)
        );

        LineChainBuilder builder = new LineChainBuilder(lines);
        List<LineChain> chains = builder.buildLineChains();

        assertEquals(2, chains.size(), "There should be 2 line chains");

        LineChain firstChain = chains.get(0);
        assertEquals(15.0, firstChain.getTotalLength(), 0.0001, "The length of the first chain should be 15.0");

        LineChain secondChain = chains.get(1);
        assertEquals(5.0, secondChain.getTotalLength(), 0.0001, "The length of the second chain should be 5.0");
    }
}
