import java.util.ArrayList;
import java.util.List;

class LineChain {
    List<Line> lines;
    double length;

    public LineChain() {
        this.lines = new ArrayList<>();
        this.length = 0;
    }

    public void addLine(Line line) {
        lines.add(line);
        length += line.length();
    }

    List<Line> getLines(){
        return lines;
    }

    public double getTotalLength() {
        return this.length;
    }
}
