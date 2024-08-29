import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.Arrays;
import java.util.List;

/**
 * The main class for the Line Chain application. This class is responsible for:
 * - Creating a list of Line objects representing lines in 2D space.
 * - Building line chains from the list of lines using the LineChainBuilder class.
 * - Printing the total length of each line chain to the console.
 * - Displaying the line chains in a graphical user interface using LinePanel within a JScrollPane.
 */
public class LineChainMainProgram {

    /**
     * The entry point of the application.
     * This method initializes the lines, builds the line chains, prints the total lengths, and sets up the GUI.
     *
     * @param args command line arguments (not used)
     */
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


        // Create a LineChainBuilder with the list of lines
        LineChainBuilder builder = new LineChainBuilder(lines);
        // Build line chains from the list of lines
        List<LineChain> lineChains = builder.buildLineChains();


        // Print the total length of each line chain
        System.out.println("Linienzüge sortiert nach Länge: ");
        for (LineChain chain : lineChains) {
            System.out.println("Länge: " + chain.getTotalLength());
        }


        // Create a LinePanel to display the line chains
        LinePanel panel = new LinePanel(lineChains);
        panel.setPreferredSize(new Dimension(1024, 1024));
        // Create a JScrollPane to provide scrolling functionality
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setPreferredSize(new Dimension(800, 600));


        // Set up the main frame
        JFrame frame = new JFrame("Linenzüge");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(scrollPane);
        frame.pack();
        // Center the frame on the screen
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
