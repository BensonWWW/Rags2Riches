import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Color;

public class DisplayPanel extends JPanel {

    public DisplayPanel() { }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Color green = new Color(0,153,0);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setFont(new Font("Papyrus", Font.BOLD, 35));
        g.setColor(green);
        g.drawString("Welcome to Rags 2 Riches!", 670, 35);
        g.setFont(new Font("Papyrus", Font.BOLD, 18));
        g.drawString("An application for stock market enthusiasts and learners", 660, 66);

    }
}
