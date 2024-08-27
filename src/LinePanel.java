import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LinePanel extends JPanel {
    private List<LineChain> lineChains;

    LinePanel(List<LineChain> lineChains){
        this.lineChains = lineChains;
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Random rand = new Random();

        for (LineChain chain : lineChains){
            g2.setColor(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
            for(Line line :chain.getLines()){
                g2.draw(new Line2D.Double(line.x1, line.y1, line.x2, line.y2));
            }
        }
    }
}
