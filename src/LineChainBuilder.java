import java.awt.*;
import java.util.*;
import java.util.List;

public class LineChainBuilder {
    private List<Line> lines;
    private Map<Point, Integer> pointCount;

    LineChainBuilder(List<Line> lines){
        this.lines = lines;
        this.pointCount = new HashMap<>();
        countPoints();

    }

    //count amount of lines which start or end at a every point
    private void countPoints(){
        for (Line line : lines){
            Point p1 = line.getStartPoint();
            Point p2 = line.getEndPoint();
            pointCount.put(p1, pointCount.getOrDefault(p1,0)+1);
            pointCount.put(p2, pointCount.getOrDefault(p2,0)+1);
        }
    }

    List<LineChain> buildLineChains(){
        List<LineChain> lineChains = new ArrayList<>();
        Set<Line> visited = new HashSet<>();

        for (Line line : lines){
            if(visited.contains(line)) continue;
            LineChain chain = new LineChain();
            chain.addLine(line);
            visited.add(line);

            boolean extended;

            do {
                extended = false;
                for(Line l : lines){
                    if (visited.contains(l)) continue;
                    if(chain.getLines().stream().anyMatch(z -> z.connectsTo(l))){
                        Point p1 = l.getStartPoint();
                        Point p2 = l.getEndPoint();
                        if(pointCount.get(p1) <= 2 && pointCount.get(p2) <=2){
                            chain.addLine(l);
                            visited.add(l);
                            extended = true;
                            break;
                        }
                    }
                }
            }
            while(extended);
            lineChains.add(chain);
        }
        lineChains.sort((a,b) -> Double.compare(b.getTotalLength(), a.getTotalLength()));
        return lineChains;
    }


}
