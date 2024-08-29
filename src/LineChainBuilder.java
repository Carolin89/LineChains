import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * A class that constructs line chains from a list of lines.
 * A line chain is a sequence of connected lines where each line connects to the next at either endpoint.
 */
public class LineChainBuilder {
    private List<Line> lines;
    private Map<Point, Integer> pointCount;

    /**
     * Constructs a LineChainBuilder with a given list of lines.
     * Initializes the point count map and counts the occurrence of each point.
     *
     * @param lines the list of lines to build line chains from
     */
    LineChainBuilder(List<Line> lines) {
        this.lines = lines;
        this.pointCount = new HashMap<>();
        countPoints();

    }

    /**
     * Counts the occurrence of each point in the list of lines.
     * Updates the pointCount map with the number of times each point is either a start or end point of a line.
     */
    private void countPoints() {
        for (Line line : lines) {
            Point p1 = line.getStartPoint();
            Point p2 = line.getEndPoint();
            pointCount.put(p1, pointCount.getOrDefault(p1, 0) + 1);
            pointCount.put(p2, pointCount.getOrDefault(p2, 0) + 1);
        }
    }


    /**
     * Builds a list of line chains from the provided lines.
     * A line chain is constructed by connecting lines where possible.
     * Lines are connected if they share a common point and neither endpoint of the line is part of more than two lines.
     *
     * @return a list of LineChain objects sorted by their total length in descending order
     */
    List<LineChain> buildLineChains() {
        List<LineChain> lineChains = new ArrayList<>();
        Set<Line> visited = new HashSet<>();

        for (Line line : lines) {
            if (visited.contains(line)) continue;
            LineChain chain = new LineChain();
            chain.addLine(line);
            visited.add(line);

            boolean extended;


            // Attempt to extend the current line chain by adding more lines
            // that can be connected to it. The loop continues as long as
            // a line can be successfully added (indicated by 'extended' being true).
            do {
                    extended = false;
                    for (Line l : lines) {
                        if (visited.contains(l)) continue;
                        if (chain.getLines().stream().anyMatch(z -> z.connectsTo(l))) {
                            Point p1 = l.getStartPoint();
                            Point p2 = l.getEndPoint();
                            if (pointCount.get(p1) <= 2 && pointCount.get(p2) <= 2) {
                                chain.addLine(l);
                                visited.add(l);
                                extended = true;
                                break;
                            }
                        }
                    }
                }
                while (extended);
                lineChains.add(chain);
            }
            lineChains.sort((a, b) -> Double.compare(b.getTotalLength(), a.getTotalLength()));
            return lineChains;
        }


    }
