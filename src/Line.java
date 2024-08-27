import java.awt.*;

class Line {
    double x1, y1, x2, y2;

    public Line(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public double length() {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    Point getStartPoint() {
        return new Point((int)x1, (int) y1);
    }


    Point getEndPoint() {
        return new Point((int)x2, (int) y2);
    }


    boolean connectsTo(Line other) {
        return (this.x1 == other.x1 && this.y1 == other.y1) ||
                (this.x1 == other.x2 && this.y1 == other.y2) ||
                (this.x2 == other.x1 && this.y2 == other.y1) ||
                (this.x2 == other.x2 && this.y2 == other.y2);
    }
}

