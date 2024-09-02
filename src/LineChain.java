import java.util.ArrayList;
import java.util.List;

/**
 * Represents a chain of connected lines.
 * Provides methods to add lines to the chain and to calculate the total length of the chain.
 */
class LineChain {
    List<Line> lines;
    double length;

    /**
     * Constructs an empty LineChain.
     * Initializes an empty list of lines and sets the total length to zero.
     */
    public LineChain() {
        this.lines = new ArrayList<>();
        this.length = 0;
    }

    /**
     * Adds a line to the chain and updates the total length of the chain.
     *
     * @param line the line to be added to the chain
     */

    public void addLine(Line line) {
        lines.add(line);
        length += line.length();
    }

    /**
     * Returns the list of lines in the chain.
     *
     * @return a list of Line objects that make up the chain
     */
    List<Line> getLines() {
        return lines;
    }

    /**
     * Returns the total length of the chain.
     *
     * @return the total length of the lines in the chain
     */
    public double getTotalLength() {
        return this.length;
    }
}
