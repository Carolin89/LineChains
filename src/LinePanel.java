import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A JPanel subclass that displays a list of LineChain objects.
 * Each  LineChain is drawn using a randomly assigned color.
 */
public class LinePanel extends JPanel {
    private List<LineChain> lineChains;


    /**
     * Constructs a LinePanel with the specified list of LineChains.
     *
     * @param lineChains the list of LineChain objects to be displayed on the panel
     */
    LinePanel(List<LineChain> lineChains) {
        this.lineChains = lineChains;
    }


    /**
     * Paints the component by drawing each line in the list of LineChains.
     * Each LineChain is drawn in a randomly assigned color.
     *
     * @param g the Graphics object used to paint the component
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Random rand = new Random();

        for (LineChain chain : lineChains) {
            g2.setColor(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
            for (Line line : chain.getLines()) {
                g2.draw(new Line2D.Double(line.x1, line.y1, line.x2, line.y2));
            }
        }
    }
}
