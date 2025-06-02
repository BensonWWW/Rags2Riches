import javax.swing.*;
import java.awt.*;

public class SampleFrame {
    public SampleFrame() {
        JFrame frame = new JFrame("Rags 2 Riches");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1760, 990);
        frame.setLocationRelativeTo(null);

        ImageIcon icon = new ImageIcon("C:\\Users\\BT_1N3_26\\IdeaProjects\\Rags2Riches\\src\\stonkicon.jpg");
        frame.setIconImage(icon.getImage());

        DisplayPanel panel = new DisplayPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.BLACK);
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };

        frame.add(panel);

        frame.setVisible(true);
    }
}
