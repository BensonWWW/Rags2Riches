import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class DisplayPanel extends JPanel implements ActionListener {

    public DisplayPanel() {
        setLayout(null);  // we'll manually position components
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("Arial", Font.BOLD, 16));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object sender = e.getSource();
        repaint();
    }
}
