import javax.swing.*;
import java.util.*;
import java.util.Arrays;

public class LineChainMainProgram {
    public static void main(String[] args) {
        List<Line> lines = Arrays.asList(
                new Line(970, 362, 742, 580),
                new Line(282, 580, 44, 362),
                new Line(509, 742, 227, 882),
                new Line(509, 742, 798, 882),
                new Line(512, 512, 282, 580),
                new Line(652, 320, 970, 362),
                new Line(282, 580, 227, 882),
                new Line(509, 39, 652, 320),
                new Line(512, 512, 509, 39),
                new Line(44, 362, 371, 320),
                new Line(970, 362, 512, 512),
                new Line(742, 580, 798, 882),
                new Line(371, 320, 509, 39)
        );

        LineChainBuilder builder = new LineChainBuilder(lines);
        List<LineChain> lineChains = builder.buildLineChains();

        System.out.println("Linienzüge sortiert nach Länge: ");
        for (LineChain chain : lineChains){
            System.out.println("Länge: " + chain.getTotalLength());
        }

        JFrame frame = new JFrame("Linenzüge");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1024,1024);
        frame.add(new LinePanel(lineChains));
        frame.setVisible(true);
    }
}
