import java.awt.*;


/**
 * Represents a line segment defined by its start and end points.
 * Provides methods to calculate the length of the line and to determine
 * if the line connects to another line.
 */
class Line {
    double x1, y1, x2, y2;

    /**
     * Constructs a line segment with the specified start and end points.
     *
     * @param x1 the x-coordinate of the start point
     * @param y1 the y-coordinate of the start point
     * @param x2 the x-coordinate of the end point
     * @param y2 the y-coordinate of the end point
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }


    /**
     * Calculates the length of the line segment.
     *
     * @return the length of the line segment
     */
    public double length() {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    /**
     * Returns the start point of the line segment as a {@link Point}.
     *
     * @return the start point of the line segment
     */
    Point getStartPoint() {
        return new Point((int) x1, (int) y1);
    }


    /**
     * Returns the end point of the line segment as a {@link Point}.
     *
     * @return the end point of the line segment
     */
    Point getEndPoint() {
        return new Point((int) x2, (int) y2);
    }


    /**
     * Determines if this line segment connects to another line segment.
     * Two lines are considered connected if they share a common end point.
     *
     * @param other the other line segment to check for connection
     * @return {@code true} if this line segment connects to the other line segment, {@code false} otherwise
     */
    boolean connectsTo(Line other) {
        return (this.x1 == other.x1 && this.y1 == other.y1) ||
                (this.x1 == other.x2 && this.y1 == other.y2) ||
                (this.x2 == other.x1 && this.y2 == other.y1) ||
                (this.x2 == other.x2 && this.y2 == other.y2);
    }
}

