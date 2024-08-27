import java.util.ArrayList;
import java.util.List;

class LineChain {
    List<Line> lines = new ArrayList<>();

    public void addLine(Line line) {
        lines.add(line);
    }

    public double getTotalLength() {
        return lines.stream().mapToDouble(Line::length).sum();
    }
}
