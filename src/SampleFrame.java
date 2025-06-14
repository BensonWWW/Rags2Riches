import javax.swing.*;
import java.awt.*;

public class SampleFrame {
    public SampleFrame() {
        JFrame frame = new JFrame("Rags 2 Riches");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1760, 990);
        frame.setLocationRelativeTo(null);

        ImageIcon icon = new ImageIcon("src\\stonkicon.jpg");
        frame.setIconImage(icon.getImage());

        DisplayPanel panel = new DisplayPanel();

        frame.add(panel);

        frame.setVisible(true);
    }
}
